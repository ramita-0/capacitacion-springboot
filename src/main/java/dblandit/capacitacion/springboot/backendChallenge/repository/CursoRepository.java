package dblandit.capacitacion.springboot.backendChallenge.repository;

import dblandit.capacitacion.springboot.backendChallenge.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository<Curso, Integer> {

}
