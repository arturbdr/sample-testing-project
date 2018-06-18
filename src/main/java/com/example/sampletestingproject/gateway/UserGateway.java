package com.example.sampletestingproject.gateway;

import com.example.sampletestingproject.domain.User;

public interface UserGateway {

  User create(final User userToBeCreated);

}
