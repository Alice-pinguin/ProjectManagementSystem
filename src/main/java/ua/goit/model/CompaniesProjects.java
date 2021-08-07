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

public class CompaniesProjects implements BaseEntity<Long>, Serializable {

    @Serial
    private static final long serialVersionUID = -3991285155798398357L;

    private Long companyId;
    private Long projectId;

    @Override
    public Long getId() {
        return projectId;
    }
}
