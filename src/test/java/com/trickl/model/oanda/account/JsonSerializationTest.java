package com.trickl.model.oanda.account;

import org.junit.Test;

public class JsonSerializationTest {

  @Test
  public void testAccount() throws Exception {
    Account account = Account.builder()
        .id("123-123-123")
        .balance("10.00")
        .build();
   // verifySerialization(palette);
  }}
