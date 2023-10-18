package dblandit.capacitacion.springboot.backendChallenge.repository;

import dblandit.capacitacion.springboot.backendChallenge.domain.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {

    Optional<Alumno> findById(Integer id);
}
