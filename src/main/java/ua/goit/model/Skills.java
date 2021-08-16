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
@Entity(name = "skills")
public class Skills implements BaseEntity<Long>, Serializable {

    private static final long serialVersionUID = -8495286847326134262L;

    @Id
    @Column(name = "id_skill", table = "skills")
    @JsonProperty("id")
    private Long id;

    @Column(name = "language", table = "skills")
    @JsonProperty("language")
    private String language;

    @Column(name = "level", table = "skills")
    @JsonProperty("level")
    private String level;

}
