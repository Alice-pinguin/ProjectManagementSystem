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
@Table (name = "customers")

public class Customers implements BaseEntity<Long>, Serializable {

        @Serial
        private static final long serialVersionUID = 5612028522264576789L;
        @Id
        private Long id;
        @Column (name = "Name")
        private String name;
        @Column (name = "City")
        private String city;
        @Column (name = "Industry")
        private String industry;

}
