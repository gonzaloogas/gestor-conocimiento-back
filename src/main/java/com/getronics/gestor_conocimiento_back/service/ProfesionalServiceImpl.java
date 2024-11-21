package com.getronics.gestor_conocimiento_back.service;

import com.getronics.gestor_conocimiento_back.model.*;
import com.getronics.gestor_conocimiento_back.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Profesional crearProfesional(Profesional profesional) {

        Profesional profesionalCraeado = profesionalRepository.save(profesional);

        List<ProfesionalIdioma> idiomasProfesional = profesionalCraeado.getIdiomasProfesional();
        idiomaRepository.saveAll(idiomasProfesional);

        List<FormacionAcademica> formacionAcademicas = profesionalCraeado.getFormacionAcademicaProfesional();
        formacionAcademicaRepository.saveAll(formacionAcademicas);

        List<ProfesionalHabilidad> habilidades = profesionalCraeado.getHabilidadesProfesional();
        profesionalHabilidadRepository.saveAll(habilidades);

        return profesionalCraeado;
    }

    @Override
    public Optional<Profesional> listarProfesionalPorId(Long id) {

        return profesionalRepository.findById(id);
    }

    @Override
    public List<Profesional> listarProfesionales() {

        return profesionalRepository.findAll();
    }

    @Override
    public void eliminarProfesionalPorId(Long id) {

        profesionalRepository.deleteById(id);
    }
}
