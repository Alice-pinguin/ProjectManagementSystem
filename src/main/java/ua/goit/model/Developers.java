package ua.goit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "developers")

public class Developers implements BaseEntity<Long>, Serializable {

    private static final long serialVersionUID = -8414974451787675055L;

    @Id
    @Column(name = "id_developer", table = "developers")
    @JsonProperty("id")
    private Long id;

    @Column(name = "name", table = "developers")
    @JsonProperty("name")
    private String name;

    @Column(name = "age", table = "developers")
    @JsonProperty("age")
    private Integer age;

    @Column(name = "gender", table = "developers")
    @JsonProperty("gender")
    private String gender;

    @Column(name = "id_salary", table = "developers")
    @JsonProperty("salary")
    private Long salary;

}
