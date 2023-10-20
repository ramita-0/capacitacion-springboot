package dblandit.capacitacion.springboot.backendChallenge.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "curso")
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "tema")
    private String tema;

    @Column(name = "anio_dictado")
    private Integer anioDictado;

    @Column(name = "duracion")
    private Integer duracion;

    @ManyToMany(mappedBy = "cursos")
    private Set<Alumno> alumnos = new HashSet<Alumno>();

    @ManyToMany(mappedBy = "cursos")
    private Set<Profesor> profesores = new HashSet<Profesor>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Integer getAnioDictado() {
        return anioDictado;
    }

    public void setAnioDictado(Integer anioDictado) {
        this.anioDictado = anioDictado;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public Set<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Set<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Set<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(Set<Profesor> profesores) {
        this.profesores = profesores;
    }
}
