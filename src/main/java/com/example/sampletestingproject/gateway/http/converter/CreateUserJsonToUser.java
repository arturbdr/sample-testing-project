package com.example.sampletestingproject.gateway.http.converter;


import com.example.sampletestingproject.domain.User;
import com.example.sampletestingproject.domain.User.UserBuilder;
import com.example.sampletestingproject.gateway.http.json.CreateUserJson;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CreateUserJsonToUser implements Converter<CreateUserJson, User> {

  @Override
  public User convert(final CreateUserJson source) {
    final UserBuilder builder = User.builder();

    if (source != null) {
      builder.age(source.getAge())
          .name(source.getName());
    }
    return builder.build();
  }
}
