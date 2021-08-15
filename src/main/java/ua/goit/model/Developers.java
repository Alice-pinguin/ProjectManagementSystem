package ua.goit.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ua.goit.model.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serial;
import java.io.Serializable;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

 public class Developers implements BaseEntity<Long>, Serializable {

    @Serial
    private static final long serialVersionUID = -8414974451787675055L;

    private Long id_developer;
    private String name;
    private Integer age;
    private String gender;
    private Long salary;

   @Override
   public Long getId() {
      return id_developer;
   }
}
