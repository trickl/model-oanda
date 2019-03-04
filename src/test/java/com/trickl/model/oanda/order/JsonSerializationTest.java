package com.trickl.model.oanda.order;

import static com.trickl.assertj.core.api.JsonObjectAssertions.assertThat;
import org.junit.Test;

public class JsonSerializationTest {

  @Test
  public void testOrder() throws Exception {
    Order order = Order.builder()
        .state(OrderState.FILLED)
        .build();
    
    assertThat(order)
        .serializesAsExpected()
        .deserializesAsExpected()
        .schemaAsExpected();
  }
}
