package com.example.sampletestingproject.usecase

import com.example.sampletestingproject.domain.User
import com.example.sampletestingproject.domain.exception.InvalidAgeException
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
        def userToBeCreated = User.builder().name("nome").cpf("333.333.333-00").age(35).build()
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

    def "Should throw Exception due to null object"() {
        given: "Given an invalid null user"
        User userToBeCreated = null

        when: "I try to create the user"
        createUser.createUser(userToBeCreated)

        then: "It should throw an exception"
        def e = thrown(IllegalArgumentException)
        e.message == "The user object must be defined"


    }

    def "Check if the age is less 30 throws exception"(){
        given: "user with invalid age (below 30 years)"
        User userToBeCreated = User.builder()
                .age(20)
                .cpf("99999999")
                .name("Esdras Faconi")
                .build()

        when: "try to create an user"
        createUser.createUser(userToBeCreated)

        then: "an Exception should be thrown"
        def exception = thrown(InvalidAgeException)
        exception.message == "The user age should be greater than 30"
    }

    def "Este teste realiza a validaçao se a idade eh nula"(){
        given: "Dado um usuario com idade invalida (idade menor que 30 anos"
        User userToBeCreated = User.builder()
                .cpf("99999999")
                .name("Esdras Faconi")
                .build()

        when: "Quando tentar criar um usuario"
        createUser.createUser(userToBeCreated)

        then: "Entao deve lancar uma excecao"
        def exception = thrown(InvalidAgeException)
        exception.message == "The user age should be greater than 30"
    }
}
