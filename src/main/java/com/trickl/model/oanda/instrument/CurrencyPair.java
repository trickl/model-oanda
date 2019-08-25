package com.trickl.model.oanda.instrument;

import java.util.Currency;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class CurrencyPair {
  private final Currency buyCurrency;
  private final Currency sellCurrency;
}