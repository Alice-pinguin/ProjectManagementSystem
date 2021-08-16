package ua.goit.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "customers")

public class Customers implements BaseEntity<Long>, Serializable {

    private static final long serialVersionUID = 5612028522264576789L;

    @Id
    @Column(name = "id", table = "customers")
    @JsonProperty("id")
    private Long id;

    @Column(name = "name", table = "customers")
    @JsonProperty("name")
    private String name;

    @Column(name = "city", table = "customers")
    @JsonProperty("city")
    private String city;

    @Column(name = "industry", table = "customers")
    @JsonProperty("industry")
    private String industry;

}
