package com.example.sampletestingproject.gateway.mongodb.repository;

import com.example.sampletestingproject.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
