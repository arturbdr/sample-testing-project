package com.example.sampletestingproject.usecase;

import com.example.sampletestingproject.domain.User;
import com.example.sampletestingproject.gateway.UserGateway;
import org.springframework.stereotype.Service;

@Service
public class CreateUser {

  private final UserGateway userGateway;

  public CreateUser(UserGateway userGateway) {
    this.userGateway = userGateway;
  }

  public User createUser(final User userToBeCreated) {
    return userGateway.create(userToBeCreated);
  }
}
