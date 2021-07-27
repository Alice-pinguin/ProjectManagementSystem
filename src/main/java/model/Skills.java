package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "skills")

public class Skills implements BaseEntity<Long>, Serializable {

    @Serial
    private static final long serialVersionUID = -8495286847326134262L;
    @Id
    private Long id;
    @Column(name = "Language")
    private String Language;
    @Column (name = "Level")
    private String level;

}
