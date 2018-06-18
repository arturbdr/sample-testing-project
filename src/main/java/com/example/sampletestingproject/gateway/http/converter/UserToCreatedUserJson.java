package com.example.sampletestingproject.gateway.http.converter;

import com.example.sampletestingproject.domain.User;
import com.example.sampletestingproject.gateway.http.json.CreatedUserJson;
import com.example.sampletestingproject.gateway.http.json.CreatedUserJson.CreatedUserJsonBuilder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserToCreatedUserJson implements Converter<User, CreatedUserJson> {

  @Override
  public CreatedUserJson convert(final User source) {
    final CreatedUserJsonBuilder builder = CreatedUserJson.builder();

    if (source != null) {
      builder.id(source.getId())
          .name(source.getName())
          .age(source.getAge());
    }
    return builder.build();
  }
}
