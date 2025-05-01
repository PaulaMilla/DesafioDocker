package com.ejemplo.evaluacion.controller;

import com.ejemplo.evaluacion.model.Evaluacion;
import com.ejemplo.evaluacion.repository.EvaluacionRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api/evaluaciones")
public class EvaluacionController {

    private final EvaluacionRepository repository;
    private final RestTemplate restTemplate;

    public EvaluacionController(EvaluacionRepository repository) {
        this.repository = repository;
        this.restTemplate = new RestTemplate(); // inicializamos RestTemplate
    }

    @GetMapping
    public List<Evaluacion> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Evaluacion getById(@PathVariable Integer id) {
        return repository.findById(id).orElse(null);
    }

    @GetMapping("/por-estudiante/{rut}")
    public List<Evaluacion> getByRutEstudiante(@PathVariable String rut) {
        return repository.findByRutEstudiante(rut);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Evaluacion evaluacion) {
        // Validar que el estudiante exista
        String estudianteServiceUrl = "http://localhost:8081/api/estudiantes/" + evaluacion.getRutEstudiante();

        try {
            ResponseEntity<String> response = restTemplate.getForEntity(estudianteServiceUrl, String.class);

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                // Estudiante existe, se puede guardar la evaluación
                Evaluacion saved = repository.save(evaluacion);
                return ResponseEntity.ok(saved);
            } else {
                // Estudiante no encontrado
                return ResponseEntity.badRequest().body("El estudiante no existe");
            }

        } catch (Exception e) {
            // Error al consultar el microservicio de estudiante
            return ResponseEntity.badRequest().body("El estudiante no existe o no se pudo verificar");
        }
    }

    @PutMapping("/{id}")
    public Evaluacion update(@PathVariable Integer id, @RequestBody Evaluacion evaluacion) {
        evaluacion.setId(id);
        return repository.save(evaluacion);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
