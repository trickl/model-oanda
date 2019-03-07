package com.trickl.model.oanda.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.trickl.model.oanda.order.Order;
import com.trickl.model.oanda.position.Position;
import com.trickl.model.oanda.trade.TradeSummary;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * An AccountState Object is used to represent an Account's current price-dependent state.
 * Price-dependent Account state is dependent on OANDA's current Prices, and includes things like
 * unrealized PL, NAV and Trailing Stop Loss Order state.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "unrealizedPL",
    "NAV",
    "marginUsed",
    "marginAvailable",
    "positionValue",
    "marginCloseoutUnrealizedPL",
    "marginCloseoutNAV",
    "marginCloseoutMarginUsed",
    "marginCloseoutPercent",
    "marginCloseoutPositionValue",
    "withdrawalLimit",
    "marginCallMarginUsed",
    "marginCallPercent"
})
@Data
@Builder
public class AccountChangesState {

  /** The total unrealized profit/loss for all Trades currently open in the Account. */
  @JsonProperty("unrealizedPL")
  @JsonPropertyDescription(
      "The total unrealized profit/loss for all Trades currently open in the Account.")
  private String unrealizedPandL;

  /** The net asset value of the Account. Equal to Account balance + unrealizedPL. */
  @JsonProperty("NAV")
  @JsonPropertyDescription(
      "The net asset value of the Account. Equal to Account balance + unrealizedPL.")
  private String netAssetValue;

  /** Margin currently used for the Account. */
  @JsonPropertyDescription("Margin currently used for the Account.")
  private String marginUsed;

  /** Margin available for Account currency. */
  @JsonPropertyDescription("Margin available for Account currency.")
  private String marginAvailable;

  /** The value of the Account's open positions represented in the Account's home currency. */
  @JsonPropertyDescription(
      "The value of the Account's open positions represented in the Account's home currency.")
  private String positionValue;

  /** The Account's margin closeout unrealized PL. */
  @JsonProperty("marginCloseoutUnrealizedPL")
  @JsonPropertyDescription("The Account's margin closeout unrealized PL.")
  private String marginCloseoutUnrealizedPandL;

  /** The Account's margin closeout NAV. */
  @JsonProperty("marginCloseoutNAV")
  @JsonPropertyDescription("The Account's margin closeout NAV.")
  private String marginCloseoutNetAssetValue;

  /** The Account's margin closeout margin used. */
  @JsonPropertyDescription("The Account's margin closeout margin used.")
  private String marginCloseoutMarginUsed;

  /**
   * The Account's margin closeout percentage. When this value is 1.0 or above the Account is in a
   * margin closeout situation.
   */
  @JsonPropertyDescription(
      "The Account's margin closeout percentage. When this value is 1.0 "
          + "or above the Account is in a margin closeout situation.")
  private String marginCloseoutPercent;

  /**
   * The value of the Account's open positions as used for margin closeout calculations represented
   * in the Account's home currency.
   */
  @JsonPropertyDescription(
      "The value of the Account's open positions as used for margin closeout "
          + "calculations represented in the Account's home currency.")
  private String marginCloseoutPositionValue;

  /**
   * The current WithdrawalLimit for the account which will be zero or a positive value indicating
   * how much can be withdrawn from the account.
   */
  @JsonPropertyDescription(
      "The current WithdrawalLimit for the account which will be zero or a"
          + " positive value indicating how much can be withdrawn from the account.")
  private String withdrawalLimit;

  /** The Account's margin call margin used. */
  @JsonPropertyDescription("The Account's margin call margin used.")
  private String marginCallMarginUsed;

  /**
   * The Account's margin call percentage. When this value is 1.0 or above the Account is in a
   * margin call situation.
   */
  @JsonPropertyDescription(
      "The Account's margin call percentage. When this value is 1.0 or above"
           + " the Account is in a margin call situation.")
  private String marginCallPercent;

  @JsonPropertyDescription("The price-dependent state of each pending Order in the Account.")
  private List<Order> orders;

  @JsonPropertyDescription("The price-dependent state for each open Trade in the Account.")
  private List<TradeSummary> trades;

  @JsonPropertyDescription("The price-dependent state for each open Position in the Account.")
  private List<Position> positions;
}
