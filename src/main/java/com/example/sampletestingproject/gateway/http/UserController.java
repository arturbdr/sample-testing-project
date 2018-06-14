package com.example.sampletestingproject.gateway.http;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import com.example.sampletestingproject.gateway.http.json.UserCreated;
import com.example.sampletestingproject.gateway.http.json.UserDataContract;
import com.example.sampletestingproject.gateway.http.mapping.URLMapping;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

  @PostMapping(value = URLMapping.CREATE_NEW_USER, produces = APPLICATION_JSON_UTF8_VALUE,
      consumes = APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<UserCreated> createUser(@RequestBody final UserDataContract userDataContract) {

    return null;
  }
}
