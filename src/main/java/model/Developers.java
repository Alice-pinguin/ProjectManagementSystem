package model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

 public class Developers implements BaseEntity<Long> {

    private Long id;
    private String name;
    private Integer age;
    private String gender;

    @Override
    public Long getId() {
        return id;
    }
}
