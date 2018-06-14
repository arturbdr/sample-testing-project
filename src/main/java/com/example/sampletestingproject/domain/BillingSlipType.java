package com.example.sampletestingproject.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillingSlipType extends GenericPayment {

  private String billingSlipId;
  private String bankCode;

}
