package dblandit.capacitacion.springboot.backendChallenge.repository;

import dblandit.capacitacion.springboot.backendChallenge.domain.Alumno;
import dblandit.capacitacion.springboot.backendChallenge.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {

    Optional<Profesor> findById(Integer id);
}
