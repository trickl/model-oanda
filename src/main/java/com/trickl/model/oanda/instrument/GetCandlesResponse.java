package com.trickl.model.oanda.instrument;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Builder
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class GetCandlesResponse {
  @Singular
  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private List<Candlestick> candles;

  private CandlestickGranularity granularity;
  private String instrument;
}
