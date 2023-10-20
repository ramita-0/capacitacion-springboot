package dblandit.capacitacion.springboot.backendChallenge.rest;

import dblandit.capacitacion.springboot.backendChallenge.domain.Alumno;
import dblandit.capacitacion.springboot.backendChallenge.domain.Curso;
import dblandit.capacitacion.springboot.backendChallenge.domain.Profesor;
import dblandit.capacitacion.springboot.backendChallenge.repository.AlumnoRepository;
import dblandit.capacitacion.springboot.backendChallenge.repository.CursoRepository;
import dblandit.capacitacion.springboot.backendChallenge.repository.ProfesorRepository;
import dblandit.capacitacion.springboot.backendChallenge.service.dto.EnrollmentPetitionDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class EnrollmentResource {

    private final Logger log = LoggerFactory.getLogger(AlumnoResource.class);

    private AlumnoRepository alumnoRepository;

    private ProfesorRepository profesorRepository;

    private CursoRepository cursoRepository;

    public EnrollmentResource(AlumnoRepository alumnoRepository, ProfesorRepository profesorRepository, CursoRepository cursoRepository) {
        this.alumnoRepository = alumnoRepository;
        this.profesorRepository = profesorRepository;
        this.cursoRepository = cursoRepository;
    }

    @CrossOrigin
    @PostMapping("/enroll-alumno")
    public ResponseEntity<String> enrollAlumnoToCurso(@RequestBody EnrollmentPetitionDTO enrollmentPetitionDTO) {
        Optional<Curso> curso = cursoRepository.findById(enrollmentPetitionDTO.getCursoId());
        Optional<Alumno> alumno = alumnoRepository.findById(enrollmentPetitionDTO.getPersonaId());

        if (curso.isEmpty()) {
            return ResponseEntity.badRequest().body(String.format("The curso with id: %d does not exist", enrollmentPetitionDTO.getCursoId()));
        }
        if (alumno.isEmpty()) {
            return ResponseEntity.badRequest().body(String.format("The alumno with id: %d does not exist", enrollmentPetitionDTO.getPersonaId()));
        }

        Curso cursoEntity = curso.get();
        Alumno alumnoEntity = alumno.get();

        Set<Alumno> alumnosCurso = cursoEntity.getAlumnos();
        alumnosCurso.add(alumnoEntity);
        cursoEntity.setAlumnos(alumnosCurso);

        Set<Curso> cursosAlumno = alumnoEntity.getCursos();
        cursosAlumno.add(cursoEntity);
        alumnoEntity.setCursos(cursosAlumno);

        cursoRepository.save(cursoEntity);
        alumnoRepository.save(alumnoEntity);

        return ResponseEntity.ok().body("OK");
    }

    @CrossOrigin
    @PostMapping("/enroll-profesor")
    public ResponseEntity<String> enrollProfesorToCurso(@RequestBody EnrollmentPetitionDTO enrollmentPetitionDTO) {
        Optional<Curso> curso = cursoRepository.findById(enrollmentPetitionDTO.getCursoId());
        Optional<Profesor> profesor = profesorRepository.findById(enrollmentPetitionDTO.getPersonaId());

        if (curso.isEmpty()) {
            return ResponseEntity.badRequest().body(String.format("The curso with id: %d does not exist", enrollmentPetitionDTO.getCursoId()));
        }
        if (profesor.isEmpty()) {
            return ResponseEntity.badRequest().body(String.format("The proffesor with id: %d does not exist", enrollmentPetitionDTO.getPersonaId()));
        }

        Curso cursoEntity = curso.get();
        Profesor profesorEntity = profesor.get();

        Set<Profesor> profesoresCurso = cursoEntity.getProfesores();
        profesoresCurso.add(profesorEntity);
        cursoEntity.setProfesores(profesoresCurso);

        Set<Curso> cursosProfesor = profesorEntity.getCursos();
        cursosProfesor.add(cursoEntity);
        profesorEntity.setCursos(cursosProfesor);

        cursoRepository.save(cursoEntity);
        profesorRepository.save(profesorEntity);

        return ResponseEntity.ok().body("OK");
    }
}
