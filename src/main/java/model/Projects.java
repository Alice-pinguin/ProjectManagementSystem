package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data

@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Projects implements BaseEntity<Long> {

    private Long id;
    private String name;
    private String field;

}