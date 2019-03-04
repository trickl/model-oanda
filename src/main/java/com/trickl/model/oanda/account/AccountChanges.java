package com.trickl.model.oanda.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.trickl.model.oanda.order.Order;
import com.trickl.model.oanda.position.Position;
import com.trickl.model.oanda.trade.TradeSummary;
import com.trickl.model.oanda.transaction.Transaction;
import java.util.List;
import lombok.Builder;
import lombok.Data;
import lombok.Singular;

/**
 * An AccountChanges Object is used to represent the changes to an Account's Orders, Trades and
 * Positions since a specified Account TransactionID in the past.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@Builder
public class AccountChanges {
  @Singular("orderCreated")
  @JsonPropertyDescription(
      "The Orders created. These Orders may have been filled, cancelled or "
          + "triggered in the same period.")  
  private List<Order> ordersCreated;

  @Singular("orderCancelled")
  @JsonPropertyDescription("The Orders cancelled.")
  private List<Order> ordersCancelled;

  @Singular("orderFilled")
  @JsonPropertyDescription("The Orders filled.")
  private List<Order> ordersFilled;

  @Singular("orderTriggered")
  @JsonPropertyDescription("The Orders triggered.")
  private List<Order> ordersTriggered;

  @Singular("tradeOpened")
  @JsonPropertyDescription("The Trades opened.")
  private List<TradeSummary> tradesOpened;

  @Singular("tradeReduced")
  @JsonPropertyDescription("The Trades reduced")
  private List<TradeSummary> tradesReduced;

  @Singular("tradeClosed")
  @JsonPropertyDescription("The Trades closed.")
  private List<TradeSummary> tradesClosed;

  @JsonPropertyDescription("The Positions changed.")
  private List<Position> positions;

  @Singular
  @JsonPropertyDescription("The Transactions that have been generated.")
  private List<Transaction> transactions;
}
