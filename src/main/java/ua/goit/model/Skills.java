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

public class Skills implements BaseEntity<Long>, Serializable {

    @Serial
    private static final long serialVersionUID = -8495286847326134262L;

    private Long id;
    private String Language;
    private String level;


}
