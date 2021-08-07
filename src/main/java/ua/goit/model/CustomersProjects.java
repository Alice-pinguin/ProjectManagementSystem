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

public class CustomersProjects implements BaseEntity<Long>, Serializable {

    @Serial
    private static final long serialVersionUID = -817675371517504518L;

    private Long projectId;
    private Long customerId;

    @Override
    public Long getId() {
        return projectId;
    }
}
