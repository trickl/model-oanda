package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import static com.trickl.assertj.core.api.JsonObjectAssertions.assertThat;
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
         ClientConfigureRejectTransaction.builder()
         .build(),
         ClientConfigureTransaction.builder()
         .build(),
         ClientExtensions.builder()
         .build(),
         CloseTransaction.builder()
         .build(),
         CreateTransaction.builder()
         .build(),
         DailyFinancingTransaction.builder()
         .build(),
         DelayedTradeClosureTransaction.builder()
         .build(),
         FixedPriceOrderTransaction.builder()
         .build(),
         LimitOrderRejectTransaction.builder()
         .build(),
         LimitOrderTransaction.builder()
         .build(),
         LiquidityRegenerationSchedule.builder()
         .build(),
         LiquidityRegenerationScheduleStep.builder()
         .build(),
         MarginCallEnterTransaction.builder()
         .build(),
         MarginCallExitTransaction.builder()
         .build(),
         MarginCallExtendTransaction.builder()
         .build(),
         MarketIfTouchedOrderRejectTransaction.builder()
         .build(),
         MarketIfTouchedOrderTransaction.builder()
         .build(),
         MarketOrderDelayedTradeClose.builder()
         .build(),
         MarketOrderMarginCloseout.builder()
         .build(),
         MarketOrderPositionCloseout.builder()
         .build(),
         MarketOrderRejectTransaction.builder()
         .build(),
         MarketOrderTradeClose.builder()
         .build(),
         MarketOrderTransaction.builder()
         .build(),
         OpenTradeFinancing.builder()
         .build(),
         OrderCancelRejectTransaction.builder()
         .build(),
         OrderCancelTransaction.builder()
         .build(),
         OrderClientExtensionsModifyRejectTransaction.builder()
         .build(),
         OrderFillTransaction.builder()
         .build(),
         PositionFinancing.builder()
         .build(),
         ReopenTransaction.builder()
         .build(),
         ResetResettablePandLTransaction.builder()
         .build(),
         StopLossDetails.builder()
         .build(),
         StopLossOrderRejectTransaction.builder()
         .build(),
         StopLossOrderTransaction.builder()
         .build(),
         StopOrderRejectTransaction.builder()
         .build(),
         StopOrderTransaction.builder()
         .build(),
         TakeProfitDetails.builder()
         .build(),
         TakeProfitOrderRejectTransaction.builder()
         .build(),
         TakeProfitOrderTransaction.builder()
         .build(),
         TradeClientExtensionsModifyRejectTransaction.builder()
         .build(),
         TradeClientExtensionsModifyTransaction.builder()
         .build(),
         TradeOpen.builder()
         .build(),
         TradeReduce.builder()
         .build(),
         TrailingStopLossOrderRejectTransaction.builder()
         .build(),
         TrailingStopLossOrderTransaction.builder()
         .build(),
         TransactionHeartbeat.builder()
         .build(),
         TransferFundsRejectTransaction.builder()
         .build(),
         TransferFundsTransaction.builder()
         .build(),
         GetTransactionsByIdsBetweenResponse.builder()
         .build(),
         GetTransactionsByCreatedBetweenResponse.builder()
         .build(),
         GetTransactionResponse.builder()
         .build()
     );
  }   
}
