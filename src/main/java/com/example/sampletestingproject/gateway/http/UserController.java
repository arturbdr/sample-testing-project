package com.example.sampletestingproject.gateway.http;

import static com.example.sampletestingproject.gateway.http.mapping.URLMapping.CREATE_NEW_USER;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import com.example.sampletestingproject.gateway.http.json.UserCreated;
import com.example.sampletestingproject.gateway.http.json.UserDataContract;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

  @ApiOperation(value = "Requesting to effect a reserve sale")
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "Reserve Effect")
  })
  @PostMapping(value = CREATE_NEW_USER, produces = APPLICATION_JSON_UTF8_VALUE,
      consumes = APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<UserCreated> createUser(
      @RequestBody final UserDataContract userDataContract) {
    return null;
  }
}
