package ua.goit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "projects")

public class Project implements BaseEntity<Long> {

    private static final long serialVersionUID = -1377026457906295951L;

    @Id
    @Column(name = "id")
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
