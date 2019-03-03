package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

/**
 * A TradeClientExtensionsModifyTransaction represents the modification of a Trade's Client
 * Extensions.
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
    "tradeID",
    "clientTradeID",
    "tradeClientExtensionsModify"
})
@Data
public class TradeClientExtensionsModifyTransaction {

  /** The Transaction's Identifier. */
  @JsonPropertyDescription("The Transaction's Identifier.")
  private String id;
  
  /** The date/time when the Transaction was created. */
  @JsonPropertyDescription("The date/time when the Transaction was created.")
  private String time;
  
  /** The ID of the user that initiated the creation of the Transaction. */
  @JsonProperty("userID")
  @JsonPropertyDescription("The ID of the user that initiated the creation of the"
          + " Transaction.")
  private Integer userId;
  
  /** The ID of the Account the Transaction was created for. */
  @JsonProperty("accountID")
  @JsonPropertyDescription("The ID of the Account the Transaction was created for.")
  private String accountId;
  
  /**
   * The ID of the "batch" that the Transaction belongs to. Transactions in the same batch are
   * applied to the Account simultaneously.
   */
  @JsonProperty("batchID")
  @JsonPropertyDescription(
      "The ID of the \"batch\" that the Transaction belongs to. Transactions in"
              + " the same batch are applied to the Account simultaneously.")
  private String batchId;
  
  /** The Request ID of the request which generated the transaction. */
  @JsonProperty("requestID")
  @JsonPropertyDescription("The Request ID of the request which generated the transaction.")
  private String requestId;
  
  /**
   * The Type of the Transaction. Always set to "TRADE_CLIENT_EXTENSIONS_MODIFY" for a
   * TradeClientExtensionsModifyTransaction.
   */
  @JsonPropertyDescription(
      "The Type of the Transaction. Always set to \"TRADE_CLIENT_EXTENSIONS_MODIFY\" "
              + "for a TradeClientExtensionsModifyTransaction.")
  private TransactionType type;
  
  /** The ID of the Trade who's client extensions are to be modified. */
  @JsonProperty("tradeID")
  @JsonPropertyDescription("The ID of the Trade who's client extensions are to be modified.")
  private String tradeId;
  
  /** The original Client ID of the Trade who's client extensions are to be modified. */
  @JsonProperty("clientTradeID")
  @JsonPropertyDescription(
      "The original Client ID of the Trade who's client extensions are to be modified.")
  private String clientTradeId;  

  private Object tradeClientExtensionsModify;
}
