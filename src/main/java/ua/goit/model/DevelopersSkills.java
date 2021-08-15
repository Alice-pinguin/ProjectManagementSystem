package ua.goit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class DevelopersSkills implements BaseEntity<Long>, Serializable {

    @Serial
    private static final long serialVersionUID = 4613032931473118565L;

    private Long id_developer;
    private Long id_skill;

    @Override
    public Long getId() {
        return id_developer;
    }
}
