package com.trickl.model.oanda.instrument;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class GetOrderBookResponse {
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private OrderBook orderBook;
}
