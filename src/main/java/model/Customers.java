package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Customers implements BaseEntity<Long> {

        private String name;
        private Long id;
        private String city;
        private String industry;

}
