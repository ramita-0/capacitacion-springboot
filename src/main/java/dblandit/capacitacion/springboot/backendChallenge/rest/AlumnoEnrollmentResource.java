package dblandit.capacitacion.springboot.backendChallenge.rest;

import dblandit.capacitacion.springboot.backendChallenge.domain.Alumno;
import dblandit.capacitacion.springboot.backendChallenge.domain.Curso;
import dblandit.capacitacion.springboot.backendChallenge.repository.AlumnoRepository;
import dblandit.capacitacion.springboot.backendChallenge.repository.CursoRepository;
import dblandit.capacitacion.springboot.backendChallenge.service.dto.EnrollmentPetitionDTO;
import org.apache.coyote.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AlumnoEnrollmentResource {

    private final Logger log = LoggerFactory.getLogger(AlumnoResource.class);

    private AlumnoRepository alumnoRepository;

    private CursoRepository cursoRepository;

    public AlumnoEnrollmentResource(AlumnoRepository alumnoRepository, CursoRepository cursoRepository) {
        this.alumnoRepository = alumnoRepository;
        this.cursoRepository = cursoRepository;
    }

    @CrossOrigin
    @PostMapping("/enroll-alumno-to-curso")
    public ResponseEntity<String> enrollAlumnoToCurso(@RequestBody EnrollmentPetitionDTO enrollmentPetitionDTO) {
        Optional<Curso> curso = cursoRepository.findById(enrollmentPetitionDTO.getCursoId());
        Optional<Alumno> alumno = alumnoRepository.findById(enrollmentPetitionDTO.getAlumnoId());

        if (curso.isEmpty()) {
            return ResponseEntity.badRequest().body(String.format("The curso with id: %d does not exist", enrollmentPetitionDTO.getCursoId()));
        }
        if (alumno.isEmpty()) {
            return ResponseEntity.badRequest().body(String.format("The alumno with id: %d does not exist", enrollmentPetitionDTO.getAlumnoId()));
        }
        // TODO: Chequear si el alumno no esta ya asociado al curso! Probar con un Set en vez de un List a ver si arregla esto.
        Curso cursoEntity = curso.get();
        Alumno alumnoEntity = alumno.get();

        List<Alumno> alumnosCurso = cursoEntity.getAlumnos();
        alumnosCurso.add(alumnoEntity);
        cursoEntity.setAlumnos(alumnosCurso);

        List<Curso> cursosAlumno = alumnoEntity.getCursos();
        cursosAlumno.add(cursoEntity);
        alumnoEntity.setCursos(cursosAlumno);

        cursoRepository.save(cursoEntity);
        alumnoRepository.save(alumnoEntity);

        return ResponseEntity.ok().body("OK");
    }
}
