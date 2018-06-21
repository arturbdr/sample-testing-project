package com.example.sampletestingproject.gateway.http.json;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateUserJson {

  @NotNull
  private Integer age;
  @NotNull
  private String cpf;
  @NotNull
  private String name;

}
