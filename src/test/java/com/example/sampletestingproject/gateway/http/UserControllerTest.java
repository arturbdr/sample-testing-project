package com.example.sampletestingproject.gateway.http;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import com.example.sampletestingproject.domain.User;
import com.example.sampletestingproject.gateway.http.converter.CreateUserJsonToUser;
import com.example.sampletestingproject.gateway.http.converter.UserToCreatedUserJson;
import com.example.sampletestingproject.gateway.http.mapping.URLMapping;
import com.example.sampletestingproject.usecase.CreateUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

  @Mock
  private CreateUserJsonToUser createUserJsonToUser;

  @Mock
  private UserToCreatedUserJson userToCreatedUserJson;

  @Mock
  private CreateUser createUser;

  @InjectMocks
  private UserController userController;

  private MockMvc mockMvc;
  private ObjectMapper objectMapper;

  @Before
  public void setUp() {
    mockMvc = standaloneSetup(userController).build();
    objectMapper = new ObjectMapper();
  }

  @Test
  public void shouldCreateNewUser() throws Exception {
    // GIVEN a user to be created
    User userToBeCreated = User.builder().age(35).name("John").build();
    User createdUser = User.builder().age(35).name("John").id(UUID.randomUUID().toString()).build();

    when(createUserJsonToUser.convert(any())).thenCallRealMethod();
    when(userToCreatedUserJson.convert(any())).thenCallRealMethod();
    when(createUser.createUser(any())).thenReturn(createdUser);

    // WHEN I try to consume the endpoint to create a new user
    MvcResult mvcResult = mockMvc.perform(post(URLMapping.CREATE_NEW_USER)
        .content(objectMapper.writeValueAsString(userToBeCreated))
        .contentType(APPLICATION_JSON_UTF8))
        .andExpect(status().isCreated())
        .andReturn();

    // THEN It should create a new user along with the generated id
    String responseBodyAsString = mvcResult.getResponse().getContentAsString();
    User userFromResponse = objectMapper.readValue(responseBodyAsString, User.class);
    assertEquals(userFromResponse, createdUser);
    verify(createUser, times(1)).createUser(any());
    verify(createUserJsonToUser, times(1)).convert(any());
    verify(userToCreatedUserJson, times(1)).convert(any());
  }

  @Test
  public void shouldValidateIfURLChanged() {
    // If the URL changes it could break clients. This test will inform that in case of URL changes
    String expected = "/api/user";
    String actual = URLMapping.CREATE_NEW_USER;
    assertEquals(expected, actual);
  }
}
