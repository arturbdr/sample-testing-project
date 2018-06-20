package com.example.sampletestingproject.gateway.mongodb;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.example.sampletestingproject.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataMongoTest
@ComponentScan(basePackageClasses = UserGatewayMongoImpl.class)
public class UserGatewayMongoImplTest {

  @Autowired
  private UserGatewayMongoImpl userGatewayMongoImpl;

  @Autowired
  private MongoTemplate mongoTemplate;

  @Before
  public void setUp() {
    // Clean all data before each test
    mongoTemplate.findAllAndRemove(new Query(), User.class);
  }

  @Test
  public void shouldCreateANewUser() {
    User sampleTestingUser = User.builder().name("Sample Testing user").age(100).build();
    User result = userGatewayMongoImpl.create(sampleTestingUser);
    assertEquals(sampleTestingUser, result);
    assertNotNull(result.getId());
  }
}
