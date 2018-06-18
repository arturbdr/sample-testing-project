package com.example.sampletestingproject.gateway.http;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import com.example.sampletestingproject.domain.User;
import com.example.sampletestingproject.gateway.http.converter.CreateUserJsonToUser;
import com.example.sampletestingproject.gateway.http.converter.UserToCreatedUserJson;
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
  CreateUserJsonToUser createUserJsonToUser;

  @Mock
  UserToCreatedUserJson userToCreatedUserJson;

  @Mock
  CreateUser createUser;

  @InjectMocks
  UserController userController;

  private MockMvc mockMvc;
  private ObjectMapper objectMapper;

  @Before
  public void setUp() {
    mockMvc = standaloneSetup(userController).build();
    objectMapper = new ObjectMapper();
  }

  @Test
  public void shouldCreateNewUser() throws Exception {
    User userToBeCreated = User.builder().age(35).name("John").build();
    User createdUser = User.builder().age(35).name("John").id(UUID.randomUUID().toString()).build();

    when(createUserJsonToUser.convert(any())).thenCallRealMethod();
    when(userToCreatedUserJson.convert(any())).thenCallRealMethod();
    when(createUser.createUser(any())).thenReturn(createdUser);

    MvcResult mvcResult = mockMvc.perform(post("/api/user")
        .content(objectMapper.writeValueAsString(userToBeCreated))
        .contentType(APPLICATION_JSON_UTF8))
        .andExpect(status().isCreated())
        .andReturn();

    String responseBodyAsString = mvcResult.getResponse().getContentAsString();
    User userFromResponse = objectMapper.readValue(responseBodyAsString, User.class);
    assertEquals(userFromResponse, createdUser);
  }
}
