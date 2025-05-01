# DesafioDocker

Para el ejercicio se creó una base de datos inicial que se llama dentro del docker-compose.yml. Para cada microservicio se generaron los servicios de POST y GET (getById() y getAll()).

Los puertos utilizados son:

- 8081: http://localhost:8081/api/estudiantes
- 8982: http://localhost:8082/api/evaluaciones

Para el POST:
- Estudiante:
{
    "rut": VARCHAR,
    "nombreCompleto": VARCHAR,
    "edad": INT,
    "curso": VARCHAR

}
- Evaluación:
{
  "rutEstudiante": VARCHAR,
  "semestre": VARCHAR,
  "asignatura": VARCHAR,
  "evaluacion": INT

}

_Paula Veloso_
