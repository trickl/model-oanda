package com.trickl.model.oanda.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.trickl.model.oanda.order.Order;
import com.trickl.model.oanda.position.Position;
import com.trickl.model.oanda.trade.TradeSummary;
import com.trickl.model.oanda.transaction.Transaction;
import java.util.List;
import lombok.Data;

/**
 * An AccountChanges Object is used to represent the changes to an Account's Orders, Trades and
 * Positions since a specified Account TransactionID in the past.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AccountChanges {
  @JsonPropertyDescription(
      "The Orders created. These Orders may have been filled, cancelled or "
          + "triggered in the same period.")
  private List<Order> ordersCreated;

  @JsonPropertyDescription("The Orders cancelled.")
  private List<Order> ordersCancelled;

  @JsonPropertyDescription("The Orders filled.")
  private List<Order> ordersFilled;

  @JsonPropertyDescription("The Orders triggered.")
  private List<Order> ordersTriggered;

  @JsonPropertyDescription("The Trades opened.")
  private List<TradeSummary> tradesOpened;

  @JsonPropertyDescription("The Trades reduced")
  private List<TradeSummary> tradesReduced;

  @JsonPropertyDescription("The Trades closed.")
  private List<TradeSummary> tradesClosed;

  @JsonPropertyDescription("The Positions changed.")
  private List<Position> positions;

  @JsonPropertyDescription("The Transactions that have been generated.")
  private List<Transaction> transactions;
}
