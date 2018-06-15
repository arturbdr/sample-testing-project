package com.example.sampletestingproject.gateway.http.json;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserDataContract {

  @Size(max = 30)
  @NotBlank
  private String name;

  @NotNull
  private Integer age;

}
