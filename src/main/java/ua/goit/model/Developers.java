package ua.goit.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "developers")

 public class Developers implements BaseEntity<Long>, Serializable {

    @Serial
    private static final long serialVersionUID = -3714701074803525069L;
    @Id
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column (name = "Age")
    private Integer age;
    @Column (name = "Gender")
    private String gender;

}
