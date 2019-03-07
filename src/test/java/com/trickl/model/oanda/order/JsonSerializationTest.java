package com.trickl.model.oanda.order;

import static com.trickl.assertj.core.api.JsonObjectAssertions.assertThat;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class JsonSerializationTest {

  @ParameterizedTest
  @MethodSource("pojoProvider")
  public void testSerialization(Object obj) throws Exception {  
    assertThat(obj)
        .serializesAsExpected()
        .deserializesAsExpected()
        .schemaAsExpected();
  }
  
  static Stream<Object> pojoProvider() {
     return Stream.of(
         DynamicOrderState.builder()
         .build(),
         FixedPriceOrder.builder()
         .build(),
         GuaranteedStopLossOrderEntryData.builder()
         .build(),
         LimitOrder.builder()
         .build(),
         LimitOrderRequest.builder()
         .build(),
         MarketIfTouchedOrder.builder()
         .build(),
         MarketIfTouchedOrderRequest.builder()
         .build(),
         MarketOrder.builder()
         .build(),
         Order.builder()
           .state(OrderState.FILLED)
         .build(),
         OrderIdentifier.builder()
         .build(),
         StopLossOrder.builder()
         .build(),
         StopLossOrderRequest.builder()
         .build(),
         StopOrder.builder()
         .build(),
         StopOrderRequest.builder()
         .build(),
         TakeProfitOrder.builder()
         .build(),
         TakeProfitOrderRequest.builder()
         .build(),
         TrailingStopLossOrder.builder()
         .build(),
         TrailingStopLossOrderRequest.builder()
         .build(),
         UnitsAvailable.builder()
         .build(),
         UnitsAvailableDetails.builder()
         .build()
     );
  }        
}
