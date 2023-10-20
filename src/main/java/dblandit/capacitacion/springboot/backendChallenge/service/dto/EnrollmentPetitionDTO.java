package dblandit.capacitacion.springboot.backendChallenge.service.dto;

import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class EnrollmentPetitionDTO implements Serializable {

    @NotNull
    private Integer cursoId;

    @NotNull
    private Integer personaId;

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }

    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }
}
