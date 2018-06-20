package com.example.sampletestingproject.gateway.mongodb;

import com.example.sampletestingproject.domain.User;
import com.example.sampletestingproject.gateway.UserGateway;
import com.example.sampletestingproject.gateway.mongodb.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserGatewayMongoImpl implements UserGateway {

  private final UserRepository userRepository;

  public UserGatewayMongoImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public User create(final User userToBeCreated) {
    return userRepository.save(userToBeCreated);
  }
}
