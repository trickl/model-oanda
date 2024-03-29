package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DailyFinancingTransaction represents the daily payment/collection of financing for an Account.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "time",
    "userID",
    "accountID",
    "batchID",
    "requestID",
    "type",
    "financing",
    "accountBalance",
    "accountFinancingMode",
    "positionFinancings"
})
@Data
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class DailyFinancingTransaction extends Transaction {
  /**
   * The Type of the Transaction.
   */
  @JsonPropertyDescription("The Type of the Transaction.")
  private final TransactionStreamMessageType type = TransactionStreamMessageType.DAILY_FINANCING;  
    
  /** The amount of financing paid/collected for the Account. */
  @JsonPropertyDescription("The amount of financing paid/collected for the Account.")
  private String financing;
  
  /** The Account's balance after daily financing. */
  @JsonPropertyDescription("The Account's balance after daily financing.")
  private String accountBalance;
  
  /** The account financing mode at the time of the daily financing. */
  @JsonPropertyDescription("The account financing mode at the time of the daily financing.")
  private AccountFinancingMode accountFinancingMode;
  
  /** The financing paid/collected for each Position in the Account. */
  @JsonPropertyDescription("The financing paid/collected for each Position in the Account.")
  private List<PositionFinancing> positionFinancings = null;  
}
