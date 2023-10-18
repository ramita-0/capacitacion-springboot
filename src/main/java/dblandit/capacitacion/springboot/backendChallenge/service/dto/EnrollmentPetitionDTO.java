package dblandit.capacitacion.springboot.backendChallenge.service.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class EnrollmentPetitionDTO implements Serializable {

    @NotNull
    private Integer cursoId;

    @NotNull
    private Integer alumnoId;

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }

    public Integer getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(Integer alumnoId) {
        this.alumnoId = alumnoId;
    }
}
