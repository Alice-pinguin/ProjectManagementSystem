package ua.goit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "customers_projects")

public class CustomersProjects implements BaseEntity<Long>, Serializable {

    @Serial
    private static final long serialVersionUID = -817675371517504518L;
    @Id
    @Column(name = "id_customer")
    private Long customerId;
    @Column(name = "id_project")
    private Long projectId;

    @Override
    public Long getId() {
        return customerId;
    }
}
