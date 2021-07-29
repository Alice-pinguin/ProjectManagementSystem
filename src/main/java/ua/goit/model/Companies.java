package ua.goit.model;

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
@Table(name = "companies")

public class Companies implements Serializable, BaseEntity <Long> {

    @Serial
    private static final long serialVersionUID = 5773288014188515682L;
    @Id
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column (name = "City")
    private String city;

}



