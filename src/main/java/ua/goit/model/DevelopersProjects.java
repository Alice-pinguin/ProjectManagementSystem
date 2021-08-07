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

public class DevelopersProjects implements BaseEntity<Long>, Serializable {

    @Serial
    private static final long serialVersionUID = -5031849844298978951L;

    private Long developerID;
    private Long projectID;

    @Override
    public Long getId() {
        return developerID;
    }
}

