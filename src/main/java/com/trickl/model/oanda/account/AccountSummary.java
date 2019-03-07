package com.trickl.model.oanda.account;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

/**
 * A summary representation of a client's Account. The AccountSummary does not provide to full
 * specification of pending Orders, open Trades and Positions.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "alias",
    "currency",
    "balance",
    "createdByUserID",
    "createdTime",
    "guaranteedStopLossOrderMode",
    "pl",
    "resettablePL",
    "resettablePLTime",
    "financing",
    "commission",
    "guaranteedExecutionFees",
    "marginRate",
    "marginCallEnterTime",
    "marginCallExtensionCount",
    "lastMarginCallExtensionTime",
    "openTradeCount",
    "openPositionCount",
    "pendingOrderCount",
    "hedgingEnabled",
    "lastOrderFillTimestamp",
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
    "marginCallPercent",
    "lastTransactionID"
})
@Builder
@Data
public class AccountSummary {

  /** The account's identifier. */
  @JsonPropertyDescription("The Account's identifier")
  private String id;

  /** Client-assigned alias for the Account. Only provided if the Account has an alias set */
  @JsonPropertyDescription(
      "Client-assigned alias for the Account. Only provided if the Account has an alias set")
  private String alias;

  /** The home currency of the Account. */
  @JsonPropertyDescription("The home currency of the Account")
  private String currency;

  /** The current balance of the Account. */
  @JsonPropertyDescription("The current balance of the Account.")
  private String balance;

  /** ID of the user that created the Account. */
  @JsonProperty("createdByUserID")
  @JsonPropertyDescription("ID of the user that created the Account.")
  private Integer createdByUserId;

  /** The date/time when the Account was created. */
  @JsonPropertyDescription("The date/time when the Account was created.")
  private String createdTime;

  /** The current guaranteed Stop Loss Order mode of the Account. */
  @JsonPropertyDescription("The current guaranteed Stop Loss Order mode of the Account.")
  private GuaranteedStopLossOrderMode guaranteedStopLossOrderMode;

  /** The total profit/loss realized over the lifetime of the Account. */
  @JsonProperty("pl")
  @JsonPropertyDescription("The total profit/loss realized over the lifetime of the Account.")
  private String pandl;

  /** The total realized profit/loss for the Account since it was last reset by the client. */
  @JsonProperty("resettablePL")
  @JsonPropertyDescription(
      "The total realized profit/loss for the Account since it was last reset by the client.")
  private String resettablePandL;

  /** The date/time that the account's resettablePL was last reset. */
  @JsonProperty("resettablePLTime")
  @JsonPropertyDescription("The date/time that the Account's resettablePL was last reset.")
  private String resettablePandLTime;

  /** The total amount of financing paid/collected over the lifetime of the Account. */
  @JsonPropertyDescription(
      "The total amount of financing paid/collected over the lifetime of the Account.")
  private String financing;

  /** The total amount of commission paid over the lifetime of the Account. */
  @JsonPropertyDescription("The total amount of commission paid over the lifetime of the Account.")
  private String commission;

  /**
   * The total amount of fees charged over the lifetime of the Account for the execution of
   * guaranteed Stop Loss Orders.
   */
  @JsonPropertyDescription(
      "The total amount of fees charged over the lifetime of the Account"
          + " for the execution of guaranteed Stop Loss Orders.")
  private String guaranteedExecutionFees;

  /**
   * Client-provided margin rate override for the Account. The effective margin rate of the Account
   * is the lesser of this value and the OANDA margin rate for the Account's division. This value is
   * only provided if a margin rate override exists for the Account.
   */
  @JsonPropertyDescription(
      "Client-provided margin rate override for the Account."
          + " The effective margin rate of the Account is the lesser of "
          + "this value and the OANDA margin rate for the Account's division."
          + " This value is only provided if a margin rate override exists"
          + " for the Account.")
  private String marginRate;

  /**
   * The date/time when the Account entered a margin call state. Only provided if the Account is in
   * a margin call.
   */
  @JsonPropertyDescription(
      "The date/time when the Account entered a margin call state."
          + " Only provided if the Account is in a margin call.")
  private String marginCallEnterTime;

  /** The number of times that the account's current margin call was extended. */
  @JsonPropertyDescription(
      "The number of times that the Account's current margin call was extended.")
  private Integer marginCallExtensionCount;

  /** The date/time of the account's last margin call extension. */
  @JsonPropertyDescription("The date/time of the Account's last margin call extension.")
  private String lastMarginCallExtensionTime;

  /** The number of Trades currently open in the Account. */
  @JsonPropertyDescription("The number of Trades currently open in the Account.")
  private Integer openTradeCount;

  /** The number of Positions currently open in the Account. */
  @JsonPropertyDescription("The number of Positions currently open in the Account.")
  private Integer openPositionCount;

  /** The number of Orders currently pending in the Account. */
  @JsonPropertyDescription("The number of Orders currently pending in the Account.")
  private Integer pendingOrderCount;

  /** Flag indicating that the Account has hedging enabled. */
  @JsonPropertyDescription("Flag indicating that the Account has hedging enabled.")
  private Boolean hedgingEnabled;

  /** The date/time of the last order that was filled for this account. */
  @JsonPropertyDescription("The date/time of the last order that was filled for this account.")
  private String lastOrderFillTimestamp;

  /** The total unrealized profit/loss for all Trades currently open in the Account. */
  @JsonProperty("unrealizedPL")
  @JsonPropertyDescription(
      "The total unrealized profit/loss for all Trades currently open in the Account.")
  private String unrealizedPanL;

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
      "The Account's margin closeout percentage. When this value is 1.0 or above"
          + " the Account is in a margin closeout situation.")
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
      "The current WithdrawalLimit for the account which will be zero or a "
          + "positive value indicating how much can be withdrawn from the account.")
  private String withdrawalLimit;

  /** The account's margin call margin used. */
  @JsonPropertyDescription("The Account's margin call margin used.")
  private String marginCallMarginUsed;

  /**
   * The account's margin call percentage. When this value is 1.0 or above the Account is in a
   * margin call situation.
   */
  @JsonPropertyDescription(
      "The Account's margin call percentage. When this value is 1.0 or above "
          + "the Account is in a margin call situation.")
  private String marginCallPercent;

  /** The ID of the last Transaction created for the Account. */
  @JsonProperty("lastTransactionID")
  @JsonPropertyDescription("The ID of the last Transaction created for the Account.")
  private String lastTransactionId;
}
