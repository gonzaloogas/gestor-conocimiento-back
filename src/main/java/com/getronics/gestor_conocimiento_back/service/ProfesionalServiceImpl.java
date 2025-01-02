package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.exception.*;
import com.getronics.gestor_conocimiento_back.model.*;
import com.getronics.gestor_conocimiento_back.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProfesionalServiceImpl implements ProfesionalService{

    @Autowired
    private ProfesionalRepository profesionalRepository;

    @Autowired
    private ProfesionalIdiomaRepository idiomaRepository;

    @Autowired
    private FormacionAcademicaRepository formacionAcademicaRepository;

    @Autowired
    private ProfesionalHabilidadRepository profesionalHabilidadRepository;

    @Autowired
    private ExperienciaLaboralRepository experienciaLaboralRepository;

    @Autowired
    private CertificacionRepository certificacionRepository;

    @Autowired
    private ReferenciaRepository referenciaRepository;

    @Autowired
    private PublicacionesLogrosAcademicosRepository logrosAcademicosRepository;

    @Autowired
    private RedesSocialesPortafolioRepository redesSocialesPortafolioRepository;

    @Override
    public Profesional crearProfesional(Profesional profesional) throws DataNotFoundException {

        //valida que el id sap no exista en la base de datos
        if(Profesional.class.isInstance(profesionalRepository.findByIdSap(profesional.getIdSap()))){
            throw new DataNotFoundException("Id SAP ya existe en la base de datos");
        }

        Profesional profesionalCraeado = profesionalRepository.save(profesional);

        List<IdiomaProfesional> idiomasProfesional = profesionalCraeado.getIdiomasProfesional();
        idiomaRepository.saveAll(idiomasProfesional);

        List<FormacionAcademicaProfesional> formacionAcademicas = profesionalCraeado.getFormacionAcademicaProfesional();
        formacionAcademicaRepository.saveAll(formacionAcademicas);

        List<HabilidadProfesional> habilidades = profesionalCraeado.getConocimientoProfesional();
        profesionalHabilidadRepository.saveAll(habilidades);

        return profesionalCraeado;
    }

    @Override
    public Optional<Profesional> listarProfesionalPorId(Long id) throws DataNotFoundException {

        return Optional.of(profesionalRepository.findById(id).
                orElseThrow(() -> new DataNotFoundException("Profesional no encontrado")));
    }

    @Override
    public List<Profesional> listarProfesionales() {

        return profesionalRepository.findAll();
    }

    @Override
    public void eliminarProfesionalPorId(Long id) {
        profesionalRepository.deleteById(id);
    }

    @Override
    public Profesional actualizarProfesional(Profesional profesional, Long id) throws DataNotFoundException {

        Profesional profesionalUpdate = profesionalRepository.findById(id).
                orElseThrow(() -> new DataNotFoundException("Profesional no encontrado"));

        profesionalUpdate.setIdSap(profesional.getIdSap());
        profesionalUpdate.setRut(profesional.getRut());
        profesionalUpdate.setNombres(profesional.getNombres());
        profesionalUpdate.setAPaterno(profesional.getAPaterno());
        profesionalUpdate.setAMaterno(profesional.getAMaterno());
        profesionalUpdate.setFechaNacimiento(profesional.getFechaNacimiento());
        profesionalUpdate.setNacionalidad(profesional.getNacionalidad());
        profesionalUpdate.setDireccion(profesional.getDireccion());
        profesionalUpdate.setTelefono(profesional.getTelefono());
        profesionalUpdate.setCorreoElectronico(profesional.getCorreoElectronico());
        profesionalUpdate.setPerfilProfesional(profesional.getPerfilProfesional());
        profesionalUpdate.setNivelExperiencia(profesional.getNivelExperiencia());
        profesionalUpdate.setAnioExperiencia(profesional.getAnioExperiencia());
        profesionalUpdate.setFechaIngresoGetronics(profesional.getFechaIngresoGetronics());
        profesionalUpdate.setFechaEgresoGetronics(profesional.getFechaEgresoGetronics());
        profesionalUpdate.setReferido(profesional.getReferido());
        profesionalUpdate.setEstadoProfesional(profesional.getEstadoProfesional());
        profesionalUpdate.setFotografia(profesional.getFotografia());

        //conocimiento
        List<HabilidadProfesional> habilidades = new ArrayList<>();
        for(HabilidadProfesional habilidadRq: profesional.getConocimientoProfesional()){

            if(habilidadRq.getId()!=null){
                //update
                HabilidadProfesional habilidadBd = profesionalHabilidadRepository.findById(habilidadRq.getId()).orElseThrow(() -> new DataNotFoundException("Habilidad no encontrada"));
                habilidadBd.setNivelCompetencia(habilidadRq.getNivelCompetencia());
                habilidadBd.setHabilidad(habilidadRq.getHabilidad());
                habilidadBd.setTipoHabilidad(habilidadRq.getTipoHabilidad());
                habilidadBd.setAniosExperiencia(habilidadRq.getAniosExperiencia());
                profesionalHabilidadRepository.save(habilidadBd);
            }else {
                //insert
                HabilidadProfesional nuevaHabilidad = new HabilidadProfesional();
                nuevaHabilidad.setHabilidad(habilidadRq.getHabilidad());
                nuevaHabilidad.setNivelCompetencia(habilidadRq.getNivelCompetencia());
                nuevaHabilidad.setTipoHabilidad(habilidadRq.getTipoHabilidad());
                nuevaHabilidad.setAniosExperiencia(habilidadRq.getAniosExperiencia());
                nuevaHabilidad.setProfesional(profesionalUpdate);
                habilidades.add(nuevaHabilidad);
            }
        }
        profesionalUpdate.getConocimientoProfesional().addAll(habilidades);

        //idiomas
        List<IdiomaProfesional> idiomas = new ArrayList<>();
        for(IdiomaProfesional idiomaRq : profesional.getIdiomasProfesional()){
            if(idiomaRq.getId()!=null){
                IdiomaProfesional idiomaBd = idiomaRepository.findById(idiomaRq.getId()).orElseThrow(()-> new DataNotFoundException("Idioma no encontrado"));
                idiomaBd.setNombre(idiomaRq.getNombre());
                idiomaBd.setNivelDominio(idiomaRq.getNivelDominio());
                idiomaRepository.save(idiomaBd);
            }
            else{
                IdiomaProfesional nuevoIdioma = new IdiomaProfesional();
                nuevoIdioma.setNombre(idiomaRq.getNombre());
                nuevoIdioma.setNivelDominio(idiomaRq.getNivelDominio());
                nuevoIdioma.setProfesional(profesionalUpdate);
                idiomas.add(nuevoIdioma);
            }
        }
        profesionalUpdate.getIdiomasProfesional().addAll(idiomas);

        //formacion academica
        List<FormacionAcademicaProfesional> academicaList = new ArrayList<>();
        for(FormacionAcademicaProfesional formacionAcademicaRq : profesional.getFormacionAcademicaProfesional()){
            if(formacionAcademicaRq.getId()!=null){
                FormacionAcademicaProfesional formacionAcademicaBd = formacionAcademicaRepository.findById(formacionAcademicaRq.getId()).orElseThrow(()-> new DataNotFoundException("Formación académica no encontrada"));
                formacionAcademicaBd.setInstitucion(formacionAcademicaRq.getInstitucion());
                formacionAcademicaBd.setCarrera(formacionAcademicaRq.getCarrera());
                formacionAcademicaBd.setAnioInicio(formacionAcademicaRq.getAnioInicio());
                formacionAcademicaBd.setAnioFin(formacionAcademicaRq.getAnioFin());
                formacionAcademicaBd.setSituacionAcademica(formacionAcademicaRq.getSituacionAcademica());
                formacionAcademicaRepository.save(formacionAcademicaBd);
            }else {
                FormacionAcademicaProfesional nuevaFormacion = new FormacionAcademicaProfesional();
                nuevaFormacion.setCarrera(formacionAcademicaRq.getCarrera());
                nuevaFormacion.setInstitucion(formacionAcademicaRq.getInstitucion());
                nuevaFormacion.setAnioInicio(formacionAcademicaRq.getAnioInicio());
                nuevaFormacion.setAnioFin(formacionAcademicaRq.getAnioFin());
                nuevaFormacion.setSituacionAcademica(formacionAcademicaRq.getSituacionAcademica());
                nuevaFormacion.setProfesional(profesionalUpdate);
                academicaList.add(nuevaFormacion);
            }
        }
        profesionalUpdate.getFormacionAcademicaProfesional().addAll(academicaList);

        //experiencia laboral
        List<ExperienciaLaboralProfesional> experienciaLaboralList = new ArrayList<>();
        for(ExperienciaLaboralProfesional experienciaLaboralRq : profesional.getExperienciaLaboralProfesional()){
            if(experienciaLaboralRq.getId()!=null){

                ExperienciaLaboralProfesional experienciaLaboralBd = experienciaLaboralRepository.findById(experienciaLaboralRq.getId()).orElseThrow(()->
                        new DataNotFoundException("Experiencia laboral no encontrada"));
                experienciaLaboralBd.setCargo(experienciaLaboralRq.getCargo());
                experienciaLaboralBd.setDescripcion(experienciaLaboralRq.getDescripcion());
                experienciaLaboralBd.setEmpresa(experienciaLaboralRq.getEmpresa());
                experienciaLaboralBd.setFechaInicio(experienciaLaboralRq.getFechaInicio());
                experienciaLaboralBd.setFechaFin(experienciaLaboralRq.getFechaFin());
                experienciaLaboralRepository.save(experienciaLaboralBd);
            }else {
            ExperienciaLaboralProfesional nuevaExperienciaLaboral = new ExperienciaLaboralProfesional();
            nuevaExperienciaLaboral.setCargo(experienciaLaboralRq.getCargo());
            nuevaExperienciaLaboral.setDescripcion(experienciaLaboralRq.getDescripcion());
            nuevaExperienciaLaboral.setEmpresa(experienciaLaboralRq.getEmpresa());
            nuevaExperienciaLaboral.setFechaInicio(experienciaLaboralRq.getFechaInicio());
            nuevaExperienciaLaboral.setFechaFin(experienciaLaboralRq.getFechaFin());
            nuevaExperienciaLaboral.setProfesional(profesionalUpdate);
            experienciaLaboralList.add(nuevaExperienciaLaboral);
            }
        }
        profesionalUpdate.getExperienciaLaboralProfesional().addAll(experienciaLaboralList);

        //certificaciones del profesional
        List<CertificacionProfesional> certificacionesList = new ArrayList<>();
        for (CertificacionProfesional certificacionProfesionalRq : profesional.getCertificacionProfesional()){
            if(certificacionProfesionalRq.getId()!=null){
                CertificacionProfesional certificacionProfesionalBd = certificacionRepository.findById(certificacionProfesionalRq.getId()).orElseThrow(()->
                        new DataNotFoundException("Certificación profesional no encontrada"));
                certificacionProfesionalBd.setNombreCertificacion(certificacionProfesionalRq.getNombreCertificacion());
                certificacionProfesionalBd.setInstitucionEmisora(certificacionProfesionalRq.getInstitucionEmisora());
                certificacionProfesionalBd.setFechaEmision(certificacionProfesionalRq.getFechaEmision());
                certificacionProfesionalBd.setFechaVencimiento(certificacionProfesionalRq.getFechaVencimiento());
                certificacionRepository.save(certificacionProfesionalBd);
            }else {
                CertificacionProfesional nuevaCertificacionProfesional = new CertificacionProfesional();
                nuevaCertificacionProfesional.setNombreCertificacion(certificacionProfesionalRq.getNombreCertificacion());
                nuevaCertificacionProfesional.setInstitucionEmisora(certificacionProfesionalRq.getInstitucionEmisora());
                nuevaCertificacionProfesional.setFechaEmision(certificacionProfesionalRq.getFechaEmision());
                nuevaCertificacionProfesional.setFechaVencimiento(certificacionProfesionalRq.getFechaVencimiento());
                nuevaCertificacionProfesional.setProfesional(profesionalUpdate);
                certificacionesList.add(nuevaCertificacionProfesional);
            }
        }
        profesionalUpdate.getCertificacionProfesional().addAll(certificacionesList);

        //referencia profesional
        List<ReferenciaProfesional> referenciasList = new ArrayList<>();
        for (ReferenciaProfesional referenciaProfesionalRq : profesional.getReferenciaProfesional()){
            if(referenciaProfesionalRq.getId()!=null){
                ReferenciaProfesional referenciaProfesionalBd = referenciaRepository.findById(referenciaProfesionalRq.getId()).orElseThrow(()-> new DataNotFoundException("Referencia laboral no encontrada"));
                referenciaProfesionalBd.setCargo(referenciaProfesionalRq.getCargo());
                referenciaProfesionalBd.setEmpresa(referenciaProfesionalRq.getEmpresa());
                referenciaProfesionalBd.setNombreReferente(referenciaProfesionalRq.getNombreReferente());
                referenciaProfesionalBd.setRelacionCandidato(referenciaProfesionalRq.getRelacionCandidato());
                referenciaProfesionalBd.setTelefonoContacto(referenciaProfesionalRq.getTelefonoContacto());
                referenciaRepository.save(referenciaProfesionalBd);
            }else {
                ReferenciaProfesional nuevaReferenciaProfesional = new ReferenciaProfesional();
                nuevaReferenciaProfesional.setCargo(referenciaProfesionalRq.getCargo());
                nuevaReferenciaProfesional.setEmpresa(referenciaProfesionalRq.getEmpresa());
                nuevaReferenciaProfesional.setNombreReferente(referenciaProfesionalRq.getNombreReferente());
                nuevaReferenciaProfesional.setRelacionCandidato(referenciaProfesionalRq.getRelacionCandidato());
                nuevaReferenciaProfesional.setTelefonoContacto(referenciaProfesionalRq.getTelefonoContacto());
                nuevaReferenciaProfesional.setProfesional(profesionalUpdate);
                referenciasList.add(nuevaReferenciaProfesional);
            }
        }
        profesionalUpdate.getReferenciaProfesional().addAll(referenciasList);

        //logros academicos
        List<PublicacionesLogrosAcademicosProfesional> logrosAcademicosList = new ArrayList<>();
        for(PublicacionesLogrosAcademicosProfesional logrosAcademicosRq : profesional.getPublicacionesProfesional()){
            if(logrosAcademicosRq.getId()!=null){
                PublicacionesLogrosAcademicosProfesional logrosAcademicosBd = logrosAcademicosRepository.findById(logrosAcademicosRq.getId()).
                        orElseThrow(()-> new DataNotFoundException("Logro academico no encontrado"));
                logrosAcademicosBd.setTituloPublicacion(logrosAcademicosRq.getTituloPublicacion());
                logrosAcademicosBd.setDescripcion(logrosAcademicosRq.getDescripcion());
                logrosAcademicosBd.setFechaPublicacion(logrosAcademicosRq.getFechaPublicacion());
                logrosAcademicosBd.setMedioPublicacion(logrosAcademicosRq.getMedioPublicacion());
                logrosAcademicosBd.setEnlacePublicacion(logrosAcademicosRq.getEnlacePublicacion());
                logrosAcademicosRepository.save(logrosAcademicosBd);
            }else {
                PublicacionesLogrosAcademicosProfesional nuevaPublicacionLogro = new PublicacionesLogrosAcademicosProfesional();
                nuevaPublicacionLogro.setTituloPublicacion(logrosAcademicosRq.getTituloPublicacion());
                nuevaPublicacionLogro.setDescripcion(logrosAcademicosRq.getDescripcion());
                nuevaPublicacionLogro.setFechaPublicacion(logrosAcademicosRq.getFechaPublicacion());
                nuevaPublicacionLogro.setMedioPublicacion(logrosAcademicosRq.getMedioPublicacion());
                nuevaPublicacionLogro.setEnlacePublicacion(logrosAcademicosRq.getEnlacePublicacion());
                nuevaPublicacionLogro.setProfesional(profesionalUpdate);
                logrosAcademicosList.add(nuevaPublicacionLogro);
            }
        }
        profesionalUpdate.getPublicacionesProfesional().addAll(logrosAcademicosList);

        //rrss portafolio
        List<RedesSocialesPortafolioProfesional> redesSocialesPortafolioList = new ArrayList<>();
        for(RedesSocialesPortafolioProfesional redesSocialesPortafolioRq : profesional.getRrssPortafolioProfesional()){
            if(redesSocialesPortafolioRq.getId()!=null){
                RedesSocialesPortafolioProfesional redesSocialesPortafolioBd = redesSocialesPortafolioRepository.findById(redesSocialesPortafolioRq.getId()).
                        orElseThrow(()-> new DataNotFoundException("RRSS o portafolio no encontrado"));
                redesSocialesPortafolioBd.setUrl(redesSocialesPortafolioRq.getUrl());
                redesSocialesPortafolioRepository.save(redesSocialesPortafolioBd);
            }else {
                RedesSocialesPortafolioProfesional nuevaRrssPortafolio = new RedesSocialesPortafolioProfesional();
                nuevaRrssPortafolio.setUrl(redesSocialesPortafolioRq.getUrl());
                nuevaRrssPortafolio.setProfesional(profesionalUpdate);
                redesSocialesPortafolioList.add(nuevaRrssPortafolio);
            }
        }
        profesionalUpdate.getRrssPortafolioProfesional().addAll(redesSocialesPortafolioList);

        return profesionalRepository.save(profesionalUpdate);
    }

}