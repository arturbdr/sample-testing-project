package com.example.sampletestingproject.gateway.http.converter;

import static org.junit.Assert.assertEquals;

import com.example.sampletestingproject.domain.User;
import com.example.sampletestingproject.gateway.http.json.CreateUserJson;
import org.junit.Before;
import org.junit.Test;

public class CreateUserJsonToUserTest {

  private CreateUserJsonToUser createUserJsonToUser;

  @Before
  public void setupTest() {
    createUserJsonToUser = new CreateUserJsonToUser();
  }

  @Test
  public void shouldConvertCreateUserJsonToUser() {
    CreateUserJson userToConvert = CreateUserJson.builder()
        .age(10)
        .name("Sample Name")
        .build();

    User result = createUserJsonToUser.convert(userToConvert);
    assertEquals(userToConvert.getAge(), result.getAge());
    assertEquals(userToConvert.getName(), result.getName());
  }
}
