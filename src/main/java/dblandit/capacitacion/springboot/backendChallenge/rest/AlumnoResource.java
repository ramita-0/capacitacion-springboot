package dblandit.capacitacion.springboot.backendChallenge.rest;

import dblandit.capacitacion.springboot.backendChallenge.domain.Alumno;
import dblandit.capacitacion.springboot.backendChallenge.repository.AlumnoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AlumnoResource {
    private final Logger log = LoggerFactory.getLogger(AlumnoResource.class);

    private AlumnoRepository alumnoRepository;

    public AlumnoResource(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @GetMapping("/alumnos/{id}")
    public ResponseEntity<Alumno> getAlumno(@PathVariable Integer id) {
        Optional<Alumno> alumno = alumnoRepository.findById(id);
        return ResponseEntity.ok().body(alumno.orElse(null));
    }

    @GetMapping("/alumnos")
    public ResponseEntity<List<Alumno>> getAlumnos() {
        List<Alumno> alumno = alumnoRepository.findAll();
        return ResponseEntity.ok().body(alumno);
    }

    @CrossOrigin
    @PostMapping("/alumnos")
    public ResponseEntity<Alumno> createAlumno(@RequestBody Alumno alumno) {
        log.debug("REST request to create an 'Alumno' entity: {}", alumno);
        return ResponseEntity.ok().body(alumnoRepository.save(alumno));
    }

}
