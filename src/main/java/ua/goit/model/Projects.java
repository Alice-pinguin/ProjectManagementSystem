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
@Entity(name = "projects")

public class Projects implements BaseEntity<Long>, Serializable {

    private static final long serialVersionUID = -1377026457906295951L;

    @Id
    @Column(name = "id_project")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "field")
    private String field;

    @Column(name = "cost")
    private Long cost;

    @Column(name = "create_date")
    private String createDate;

}
