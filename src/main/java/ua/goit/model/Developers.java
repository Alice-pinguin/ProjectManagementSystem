package ua.goit.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "developers")

 public class Developers implements BaseEntity<Long>, Serializable {

    @Serial
    private static final long serialVersionUID = -8414974451787675055L;

    @Id
    @Column(name = "id_developer")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @Column(name = "gender")
    private String gender;
    @Column(name = "id_salary")
    private Long salary;

}
