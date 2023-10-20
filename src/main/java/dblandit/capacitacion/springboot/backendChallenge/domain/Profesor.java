package dblandit.capacitacion.springboot.backendChallenge.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "profesor")
public class Profesor extends Persona implements Serializable  {
    // TODO: Sistema de permisos; por ejemplo un profesor podria ser jefe de catedra y disponer de mas funciones que un profesor no tiene
    // TODO: Array de tecnologias/materias/conocimientos/especialidades (evaluar extension del modelo con alguna de esas entidades)

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "curso_has_profesores", joinColumns = @JoinColumn(name = "profesor_id", referencedColumnName = "id" ),
            inverseJoinColumns = @JoinColumn(name = "curso_id", referencedColumnName = "id")
    )
    private Set<Curso> cursos = new HashSet<Curso>();

    @Column(name = "matricula", unique = true, nullable = false)
    private String matricula;

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public String toString() {
        return "Profesor{ " +
            "id='" + getId() +
            "', nombre='" + getNombre() +
            "', apellido='" + getApellido() +
            "', dni='" + getDni() +
            "', direccion='" + getDireccion() +
            "', matricula='" + getMatricula() +
            "'";
    }
}
