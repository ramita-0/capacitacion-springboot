package dblandit.capacitacion.springboot.backendChallenge.domain;


import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "alumno")
public class Alumno extends Persona implements Serializable {

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(
            name = "curso_has_alumnos", joinColumns = @JoinColumn(name = "alumno_id", referencedColumnName = "id" ),
            inverseJoinColumns = @JoinColumn(name = "curso_id", referencedColumnName = "id")
    )
    private Set<Curso> cursos = new HashSet<Curso>();

    @Column(name = "legajo", unique = true, nullable = false)
    private String legajo;

    public Set<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Set<Curso> cursos) {
        this.cursos = cursos;
    }

    public String getLegajo() {
        return legajo;
    }

    public void setLegajo(String legajo) {
        this.legajo = legajo;
    }

    @Override
    public String toString() {
        return "Alumno{ " +
                "id='" + getId() +
                "', nombre='" + getNombre() +
                "', apellido='" + getApellido() +
                "', dni='" + getDni() +
                "', direccion='" + getDireccion() +
                "', legajo='" + getLegajo() +
                "'";
    }
}
