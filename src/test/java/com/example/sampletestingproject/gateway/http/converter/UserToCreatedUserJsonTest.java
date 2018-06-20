package com.example.sampletestingproject.gateway.http.converter;

import static org.junit.Assert.assertEquals;

import com.example.sampletestingproject.domain.User;
import com.example.sampletestingproject.gateway.http.json.CreatedUserJson;
import org.junit.Before;
import org.junit.Test;

public class UserToCreatedUserJsonTest {

  private UserToCreatedUserJson userToCreatedUserJson;

  @Before
  public void setupTest() {
    userToCreatedUserJson = new UserToCreatedUserJson();
  }

  @Test
  public void shouldConvertCreateUserJsonToUser() {
    User userToConvert = User.builder()
        .age(10)
        .name("Sample Name")
        .build();

    CreatedUserJson convertedUser = userToCreatedUserJson.convert(userToConvert);
    assertEquals(userToConvert.getAge(), convertedUser.getAge());
    assertEquals(userToConvert.getName(), convertedUser.getName());
  }
}