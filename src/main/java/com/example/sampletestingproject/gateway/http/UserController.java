package com.example.sampletestingproject.gateway.http;

import static com.example.sampletestingproject.gateway.http.mapping.URLMapping.CREATE_NEW_USER;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

import com.example.sampletestingproject.domain.User;
import com.example.sampletestingproject.gateway.http.converter.CreateUserJsonToUser;
import com.example.sampletestingproject.gateway.http.converter.UserToCreatedUserJson;
import com.example.sampletestingproject.gateway.http.json.CreateUserJson;
import com.example.sampletestingproject.gateway.http.json.CreatedUserJson;
import com.example.sampletestingproject.usecase.CreateUser;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class UserController {

  private final CreateUserJsonToUser createUserJsonToUser;
  private final UserToCreatedUserJson userToCreatedUserJson;
  private final CreateUser createUser;

  public UserController(
      CreateUserJsonToUser createUserJsonToUser,
      UserToCreatedUserJson userToCreatedUserJson,
      CreateUser createUser) {
    this.createUserJsonToUser = createUserJsonToUser;
    this.userToCreatedUserJson = userToCreatedUserJson;
    this.createUser = createUser;
  }

  @ApiOperation(value = "Create a new User")
  @ApiResponses(value = {
      @ApiResponse(code = 201, message = "User Created along with identification"),
      @ApiResponse(code = 400, message = "Bad request")
  })
  @PostMapping(value = CREATE_NEW_USER, produces = APPLICATION_JSON_UTF8_VALUE, consumes = APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<CreatedUserJson> createUser(
      @RequestBody final CreateUserJson createUserJson) {

    final User userToBeCreated = createUserJsonToUser.convert(createUserJson);
    final User userCreated = createUser.createUser(userToBeCreated);

    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(userToCreatedUserJson.convert(userCreated));
  }
}
