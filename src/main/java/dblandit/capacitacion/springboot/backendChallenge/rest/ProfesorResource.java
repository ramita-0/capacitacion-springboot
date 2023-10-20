package dblandit.capacitacion.springboot.backendChallenge.rest;

import dblandit.capacitacion.springboot.backendChallenge.domain.Profesor;
import dblandit.capacitacion.springboot.backendChallenge.repository.ProfesorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProfesorResource {

    private final Logger log = LoggerFactory.getLogger(AlumnoResource.class);

    private ProfesorRepository profesorRepository;

    public ProfesorResource(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    @CrossOrigin
    @PostMapping("/profesores")
    public ResponseEntity<Profesor> createProfesor(@RequestBody Profesor profesor) {
        log.debug("REST request to create a 'Profesor' entity: {}", profesor);
        return ResponseEntity.ok().body(profesorRepository.save(profesor));
    }
}
