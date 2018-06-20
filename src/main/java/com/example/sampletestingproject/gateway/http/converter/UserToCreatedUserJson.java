package com.example.sampletestingproject.gateway.http.converter;

import com.example.sampletestingproject.domain.User;
import com.example.sampletestingproject.gateway.http.json.CreatedUserJson;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToCreatedUserJson implements Converter<User, CreatedUserJson> {

  @Override
  public CreatedUserJson convert(final User source) {
    return CreatedUserJson.builder()
        .id(source.getId())
        .name(source.getName())
        .age(source.getAge())
        .build();
  }
}
