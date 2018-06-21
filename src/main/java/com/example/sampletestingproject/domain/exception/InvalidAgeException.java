package com.example.sampletestingproject.domain.exception;

public class InvalidAgeException extends RuntimeException {

  public InvalidAgeException(String message) {
    super(message);
  }
}
