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

public class Projects implements BaseEntity<Long>, Serializable {

    @Serial
    private static final long serialVersionUID = -1377026457906295951L;

    private Long id_project;
    private Long id_developer;
    private Long id_company;
    private String name;
    private String field;
    private Long cost;
    private String createDate;


    @Override
    public Long getId() {
        return id_project;
    }
}
