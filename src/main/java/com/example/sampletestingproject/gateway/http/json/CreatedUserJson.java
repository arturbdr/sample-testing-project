package com.example.sampletestingproject.gateway.http.json;

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
public class CreatedUserJson {

  private Integer age;
  private String cpf;
  private String id;
  private String name;

}
