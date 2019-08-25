package com.trickl.model.oanda.instrument;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import static com.trickl.assertj.core.api.JsonObjectAssertions.assertThat;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Currency;
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
        Candlestick.builder()
              .complete(true)
              .volume(6L)
              .time(Instant.parse("2007-12-03T10:15:30.00Z"))
              .mid(CandlestickData.builder()
                .open(new BigDecimal("0.89551"))
                .high(new BigDecimal("0.89552"))
                .low(new BigDecimal("0.89553"))
                .close(new BigDecimal("0.89554"))
                .build())
              .build(),
        CandlestickData.builder()
                .open(new BigDecimal("0.89551"))
                .high(new BigDecimal("0.89552"))
                .low(new BigDecimal("0.89553"))
                .close(new BigDecimal("0.89554"))
                .build(),
        OrderBook.builder()
        .build(),
        OrderBookBucket.builder()
        .build(),
        PositionBook.builder()
        .build(),
        PositionBookBucket.builder()
        .build(),
        GetCandlesResponse.builder()
            .instrument("EUR_GBP")
            .granularity(CandlestickGranularity.M5)
            .candle(Candlestick.builder()
              .complete(true)
              .volume(6L)
              .time(Instant.parse("2007-12-03T10:15:30.00Z"))
              .mid(CandlestickData.builder()
                .open(new BigDecimal("0.89551"))
                .high(new BigDecimal("0.89552"))
                .low(new BigDecimal("0.89553"))
                .close(new BigDecimal("0.89554"))
                .build())
              .build())
            .build(),
        new CurrencyPair(Currency.getInstance("GBP"), Currency.getInstance("EUR"))
     );
  }   
}
