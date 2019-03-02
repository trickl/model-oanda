package com.trickl.model.oanda.account;

import static com.trickl.assertj.core.api.JsonObjectAssertions.assertThat;
import org.junit.Test;

public class JsonSerializationTest {

  @Test
  public void testAccount() throws Exception {
    Account account = Account.builder()
        .netAssetValue("43650.78835") 
        .alias("My New Account #2") 
        .balance("43650.78835") 
        .createdByUserId(123) 
        .createdTime("2015-08-12T18:21:00.697504698Z") 
        .currency("CHF") 
        .hedgingEnabled(false) 
        .id("<ACCOUNT>") 
        .lastTransactionId("6356") 
        .marginAvailable("43650.78835") 
        .marginCloseoutMarginUsed("0.00000") 
        .marginCloseoutNetAssetValue("43650.78835") 
        .marginCloseoutPercent("0.00000") 
        .marginCloseoutPositionValue("0.00000") 
        .marginCloseoutUnrealizedPandL("0.00000") 
        .marginRate("0.02") 
        .marginUsed("0.00000") 
        .openPositionCount(0) 
        .openTradeCount(0) 
        .pl("-56034.41199") 
        .positionValue("0.00000") 
        .build();
    
    assertThat(account)
        .serializesAsExpected()
        .deserializesAsExpected()
        .schemaAsExpected();
  }
}
