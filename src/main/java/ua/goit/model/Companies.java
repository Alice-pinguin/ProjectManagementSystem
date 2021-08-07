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

public class Companies implements Serializable, BaseEntity<Long> {

    @Serial
    private static final long serialVersionUID = 5773288014188515682L;

    private Long id;
    private String name;
    private String city;


}



