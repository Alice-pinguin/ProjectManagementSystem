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
@Entity(name = "developers_projects")

public class DevelopersProjects implements BaseEntity<Long>, Serializable {

    private static final long serialVersionUID = -5031849844298978951L;

    @Id
    @Column(name = "id_developer")
    private Long delevoperId;

    @Column(name = "id_project")
    private Long projectId;

    @Override
    public Long getId() {
        return delevoperId;
    }
}
