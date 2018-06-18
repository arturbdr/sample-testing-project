package com.example.sampletestingproject.usecase

import com.example.sampletestingproject.domain.User
import com.example.sampletestingproject.gateway.UserGateway
import spock.lang.Specification

class CreateUserSpec extends Specification {
    UserGateway userGateway = Mock(UserGateway.class)
    CreateUser createUser

    def setup() {
        createUser = new CreateUser(userGateway)
    }

    def "test create User"() {
        given: "A new user to be created"
        def userToBeCreated = User.builder().name("nome").age(35).build()
        println "userToBeCreated = $userToBeCreated"

        and: "a random UUID identifying the user id created"
        def randomUUID = UUID.randomUUID().toString()
        userGateway.create(userToBeCreated) >> {
            def createdUser = User.builder().name("nome").age(35).id(randomUUID).build()
            createdUser
        }

        when: "I try to create the user"
        User createdUser = createUser.createUser(userToBeCreated)

        then: "The user should be created successfully"
        createdUser != null
        createdUser.getAge().equals(userToBeCreated.getAge())
        createdUser.getName().equals(userToBeCreated.getName())
        createdUser.getId().equals(randomUUID)
    }
}
