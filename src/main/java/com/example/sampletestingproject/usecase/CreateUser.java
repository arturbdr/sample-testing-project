package com.example.sampletestingproject.usecase;

import com.example.sampletestingproject.domain.User;
import com.example.sampletestingproject.gateway.UserGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CreateUser {

  @Autowired
  @Qualifier("mockUserGatewayImpl")
  private UserGateway userGateway;

  public User createUser(final User userToBeCreated) {
    log.info("Creating user {}", userToBeCreated);

    final User createdUser = userGateway.create(userToBeCreated);

    return createdUser;
  }


}
