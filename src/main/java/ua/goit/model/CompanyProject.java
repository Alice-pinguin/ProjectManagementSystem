package ua.goit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "companies_project")

public class CompanyProject implements BaseEntity<Long> {

    private static final long serialVersionUID = -3991285155798398357L;

    @Id
    @Column(name = "id_company")
    private Long companyId;

    @Column(name = "id_project")
    private Long projectId;

    @Override
    public Long getId() {
        return companyId;
    }

}
