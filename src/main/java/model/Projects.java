package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "projects")

public class Projects implements BaseEntity<Long>, Serializable {

    @Serial
    private static final long serialVersionUID = -1377026457906295951L;
    @Id
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column (name = "Field")
    private String field;

}
