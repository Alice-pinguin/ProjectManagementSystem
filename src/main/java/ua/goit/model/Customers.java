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

public class Customers implements BaseEntity<Long>, Serializable {

        @Serial
        private static final long serialVersionUID = 5612028522264576789L;

        private Long id_customer;
        private String name;
        private String city;
        private String industry;
        private Long id_company;
        private Long id_project;

        @Override
        public Long getId() {
                return id_customer;
        }
}

