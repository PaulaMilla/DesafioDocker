package com.ejemplo.estudiante.controller;

import com.ejemplo.estudiante.model.Estudiante;
import com.ejemplo.estudiante.repository.EstudianteRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteRepository repository;

    public EstudianteController(EstudianteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Estudiante> getAll() {
        return (List<Estudiante>) repository.findAll();
    }

    @GetMapping("/{rut}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Estudiante> getByRut(@PathVariable String rut) {
        return repository.findById(rut).
        map(resource -> ResponseEntity.ok(resource))
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estudiante create(@RequestBody Estudiante estudiante) {
        return repository.save(estudiante);
    }


    @DeleteMapping("/{rut}")
    public void delete(@PathVariable String rut) {
        repository.deleteById(rut);
    }
}