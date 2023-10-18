package dblandit.capacitacion.springboot.backendChallenge.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

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
    private List<Alumno> alumnos;
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

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}
