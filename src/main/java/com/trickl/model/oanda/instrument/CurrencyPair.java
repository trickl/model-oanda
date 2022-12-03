package com.trickl.model.oanda.instrument;

import java.util.Currency;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class CurrencyPair {
  private Currency buyCurrency;
  private Currency sellCurrency;
}