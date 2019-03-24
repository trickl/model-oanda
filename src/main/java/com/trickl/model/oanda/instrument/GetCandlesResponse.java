package com.trickl.model.oanda.instrument;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.Builder;
import lombok.Singular;
import lombok.Value;

@Value
@Builder
public class GetCandlesResponse {
  @Singular
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<Candlestick> candles;

  private CandlestickGranularity granularity;
  private String instrument;
}
