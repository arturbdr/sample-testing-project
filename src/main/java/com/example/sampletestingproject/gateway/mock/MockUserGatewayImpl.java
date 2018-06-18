package com.example.sampletestingproject.gateway.mock;

import com.example.sampletestingproject.domain.User;
import com.example.sampletestingproject.gateway.UserGateway;
import java.util.UUID;
import org.springframework.stereotype.Component;

@Component
public class MockUserGatewayImpl implements UserGateway {

  @Override
  public User create(final User userToBeCreated) {
    return User.builder()
        .name(userToBeCreated.getName())
        .age(userToBeCreated.getAge())
        .id(UUID.randomUUID().toString())
        .build();
  }
}
