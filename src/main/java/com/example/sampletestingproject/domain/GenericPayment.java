package com.example.sampletestingproject.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class GenericPayment {

  private Long totalValueInCents;
}
