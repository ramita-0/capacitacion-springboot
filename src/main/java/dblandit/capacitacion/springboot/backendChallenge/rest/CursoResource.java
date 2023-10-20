package dblandit.capacitacion.springboot.backendChallenge.rest;

import dblandit.capacitacion.springboot.backendChallenge.domain.Curso;
import dblandit.capacitacion.springboot.backendChallenge.repository.CursoRepository;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CursoResource {

    private final Logger log = LoggerFactory.getLogger(AlumnoResource.class);

    private CursoRepository cursoRepository;

    public CursoResource(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @CrossOrigin
    @PostMapping("/cursos")
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso) {
        log.debug("REST request to create a 'Curso': {}", curso);
        Curso newCurso = cursoRepository.save(curso);
        return ResponseEntity.ok().body(newCurso);
    }
}
