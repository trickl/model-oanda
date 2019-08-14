package com.trickl.model.oanda.pricing.common;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import static com.trickl.assertj.core.api.JsonObjectAssertions.assertThat;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class JsonSerializationTest {
     
  private static ObjectMapper objectMapper;
    
  @BeforeAll
  public static void setup() {    
    objectMapper = new ObjectMapper();
    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
  }   

  @ParameterizedTest
  @MethodSource("pojoProvider")
  public void testSerialization(Object obj) throws Exception {  
    assertThat(obj)
        .usingObjectMapper(objectMapper)
        .serializesAsExpected()
        .deserializesAsExpected()
        .schemaAsExpected();
  }
  
  static Stream<Object> pojoProvider() {
     return Stream.of(
         Price.builder()
            .time(Instant.parse("2007-12-03T10:15:30.00Z"))
            .bid(PriceBucket.builder().price(new BigDecimal("0.89443")).liquidity(1000000).build())
            .ask(PriceBucket.builder().price(new BigDecimal("0.89552")).liquidity(1000000).build())
            .closeoutBid(new BigDecimal("0.89101"))
            .closeoutAsk(new BigDecimal("0.89782"))
            .tradeable(false)
            .instrument("EUR_GBP")
         .build(),
         PricingHeartbeat.builder().time(Instant.parse("2007-12-03T10:15:30.00Z"))
         .build(),
         PriceBucket.builder().price(new BigDecimal("0.89443")).liquidity(1000000)
         .build()
     );
  }   
}
