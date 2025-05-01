package com.ejemplo.evaluacion.repository;

import com.ejemplo.evaluacion.model.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Integer> {
    List<Evaluacion> findByRutEstudiante(String rutEstudiante);
}
