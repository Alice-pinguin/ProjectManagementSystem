package model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

 public class Developers {

    private Long id_developer;
    private String name;
    private Integer age;
    private String gender;


}
