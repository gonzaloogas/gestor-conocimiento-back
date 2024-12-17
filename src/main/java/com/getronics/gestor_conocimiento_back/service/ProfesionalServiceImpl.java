package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.exception.*;
import com.getronics.gestor_conocimiento_back.model.*;
import com.getronics.gestor_conocimiento_back.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
    private ClienteRepository clienteRepository;

    @Override
    public Profesional crearProfesional(Profesional profesional) throws ClienteNotFoundException {

        if (profesional.getCliente() != null && profesional.getCliente().getId() != null) {
            Cliente cliente = clienteRepository.findById(profesional.getCliente().getId())
                    .orElseThrow(() -> new ClienteNotFoundException("Cliente no encontrado con ID: " + profesional.getCliente().getId()));
            profesional.setCliente(cliente); // Asocia el cliente gestionado
        }

        Profesional profesionalCraeado = profesionalRepository.save(profesional);

        List<IdiomaProfesional> idiomasProfesional = profesionalCraeado.getIdiomasProfesional();
        idiomaRepository.saveAll(idiomasProfesional);

        List<FormacionAcademicaProfesional> formacionAcademicas = profesionalCraeado.getFormacionAcademicaProfesional();
        formacionAcademicaRepository.saveAll(formacionAcademicas);

        List<ConocimientoTecnicoProfesional> habilidades = profesionalCraeado.getConocimientoTecnicoProfesional();
        profesionalHabilidadRepository.saveAll(habilidades);

        return profesionalCraeado;
    }

    @Override
    public Optional<Profesional> listarProfesionalPorId(Long id) throws ProfesionalNotFoundException {

        return Optional.of(profesionalRepository.findById(id).
                orElseThrow(() -> new ProfesionalNotFoundException("Profesional no encontrado")));
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
    public Profesional actualizarProfesional(Profesional profesional, Long id) throws ProfesionalNotFoundException, HabilidadNotFoundException, IdiomaNotFoundException, FormacionAcademicaNotFoundException, ClienteNotFoundException {

        Profesional profesionalUpdate = profesionalRepository.findById(id).
                orElseThrow(() -> new ProfesionalNotFoundException("Profesional no encontrado"));

        Cliente nuevoCliente = clienteRepository.findById(profesional.getCliente().getId()).
                orElseThrow(() -> new ClienteNotFoundException("Cliente no encontrado"));

        profesionalUpdate.setNombres(profesional.getNombres());
        profesionalUpdate.setAPaterno(profesional.getAPaterno());
        profesionalUpdate.setAMaterno(profesional.getAMaterno());
        profesionalUpdate.setNivelExperiencia(profesional.getNivelExperiencia());
        profesionalUpdate.setAnioExperiencia(profesional.getAnioExperiencia());
        profesionalUpdate.setCliente(nuevoCliente);


        //habilidades
        List<ConocimientoTecnicoProfesional> habilidades = new ArrayList<>();
        for(ConocimientoTecnicoProfesional habilidadRq: profesional.getConocimientoTecnicoProfesional()){

            if(habilidadRq.getId()!=null){
                //update
                ConocimientoTecnicoProfesional habilidadBd = profesionalHabilidadRepository.findById(habilidadRq.getId()).orElseThrow(() -> new HabilidadNotFoundException("Habilidad no encontrada"));
                habilidadBd.setNivelCompetencia(habilidadRq.getNivelCompetencia());
                profesionalHabilidadRepository.save(habilidadBd);
            }else {
                //insert
                ConocimientoTecnicoProfesional nuevaHabilidad = new ConocimientoTecnicoProfesional();
                nuevaHabilidad.setHabilidadTecnologica(habilidadRq.getHabilidadTecnologica());
                nuevaHabilidad.setNivelCompetencia(habilidadRq.getNivelCompetencia());
                nuevaHabilidad.setProfesional(profesionalUpdate);
                habilidades.add(nuevaHabilidad);
            }
        }
        profesionalUpdate.getConocimientoTecnicoProfesional().addAll(habilidades);

        //idiomas
        List<IdiomaProfesional> idiomas = new ArrayList<>();
        for(IdiomaProfesional idiomaRq : profesional.getIdiomasProfesional()){
            if(idiomaRq.getId()!=null){
                IdiomaProfesional idiomaBd = idiomaRepository.findById(idiomaRq.getId()).orElseThrow(()-> new IdiomaNotFoundException("Idioma no encontrado"));
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
                FormacionAcademicaProfesional formacionAcademicaBd = formacionAcademicaRepository.findById(formacionAcademicaRq.getId()).orElseThrow(()-> new FormacionAcademicaNotFoundException("Formación académica no encontrada"));
                formacionAcademicaBd.setInstitucion(formacionAcademicaRq.getInstitucion());
                formacionAcademicaBd.setCarrera(formacionAcademicaRq.getCarrera());
                formacionAcademicaRepository.save(formacionAcademicaBd);
            }else {
                FormacionAcademicaProfesional nuevaFormacion = new FormacionAcademicaProfesional();
                nuevaFormacion.setCarrera(formacionAcademicaRq.getCarrera());
                nuevaFormacion.setInstitucion(formacionAcademicaRq.getInstitucion());
                nuevaFormacion.setProfesional(profesionalUpdate);
                academicaList.add(nuevaFormacion);
            }
        }
        profesionalUpdate.getFormacionAcademicaProfesional().addAll(academicaList);

        return profesionalRepository.save(profesionalUpdate);

    }

}