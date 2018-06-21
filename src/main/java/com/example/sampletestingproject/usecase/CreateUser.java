package com.example.sampletestingproject.usecase;

import static org.springframework.util.Assert.isTrue;
import static org.springframework.util.Assert.notNull;

import com.example.sampletestingproject.domain.User;
import com.example.sampletestingproject.domain.exception.InvalidAgeException;
import com.example.sampletestingproject.gateway.UserGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreateUser {

  public static final String USER_AGE_MUST_BE_ABOVE_30 = "The user age should be greater than 30";
  private final UserGateway userGateway;

  public CreateUser(final UserGateway userGateway) {
    this.userGateway = userGateway;
  }

  public User createUser(final User userToBeCreated) {
    validateUser(userToBeCreated);
    log.info("Creating user {}", userToBeCreated);
    return userGateway.create(userToBeCreated);
  }

  private void validateUser(final User userToBeCreated) {
    notNull(userToBeCreated, "The user object must be defined");
    notNull(userToBeCreated.getCpf(), "The user cpf must be defined");
    notNull(userToBeCreated.getName(), "The user name must be defined");
    if (userToBeCreated.getAge() == null || userToBeCreated.getAge() <= 30) {
      throw new InvalidAgeException(USER_AGE_MUST_BE_ABOVE_30);
    }
  }
}
