CREATE TABLE IF NOT EXISTS ejemplo.estudiante (
    rut VARCHAR(10) NOT NULL PRIMARY KEY,
    nombre_completo VARCHAR(50),
    edad INT,
    curso VARCHAR(50)
);

INSERT INTO ejemplo.estudiante (rut, nombre_completo, edad, curso) 
VALUES ('20729079-3', 'Millaaaaaa', 24, 'sdfkjasdf');

CREATE TABLE IF NOT EXISTS ejemplo.evaluacion (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    rut_estudiante VARCHAR(10),
    semestre VARCHAR(50),
    asignatura VARCHAR(50),
    evaluacion INT
);

INSERT INTO ejemplo.evaluacion (rut_estudiante, semestre, asignatura, evaluacion) 
VALUES ('20729079-3', 'noveno', 'GPS', 7);