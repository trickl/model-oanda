package com.trickl.model.oanda.pricing;

import static com.trickl.assertj.core.api.JsonObjectAssertions.assertThat;
import com.trickl.model.oanda.order.Order;
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
         ClientPrice.builder()
         .build(),
         HomeConversions.builder()
         .build(),
         PricingHeartbeat.builder()
         .build(),
         QuoteHomeConversionFactors.builder()
         .build()
     );
  }   
}