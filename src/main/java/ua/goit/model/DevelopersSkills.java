package ua.goit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "developers_skills")

public class DevelopersSkills implements BaseEntity<Long>, Serializable {

    private static final long serialVersionUID = 4613032931473118565L;

    @Id
    @Column(name = "id_developer", table = "developers_skills")
    @JsonProperty("id_developer")
    private Long developerId;

    @Column(name = "id_skill", table = "developers_skills")
    @JsonProperty("id_skill")
    private Long skillId;

    @Override
    public Long getId() {
        return developerId;
    }
}
