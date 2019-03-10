package com.trickl.model.oanda.transaction;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import lombok.Builder;
import lombok.Data;

/** The response from the /v3/accounts/{accountId}/transactions endpoint. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"from", "to", "pageSize", "type", "count", "pages", "lastTransactionID"})
@Data
@Builder
public class TransactionDateRangeResponse {
  /* The starting time provided in the request. */
  @JsonPropertyDescription("The starting time provided in the request.")
  private String from;

  /* The ending time provided in the request. */
  @JsonPropertyDescription("The ending time provided in the request.")
  private String to;

  /* The pageSize provided in the request. */
  @JsonPropertyDescription("The pageSize provided in the request.")
  private Integer pageSize;

  /* The Transaction-type filter provided in the request. */
  @JsonPropertyDescription("The Transaction-type filter provided in the request.")
  private List<TransactionFilter> type;

  /* The number of Transactions that are contained in the pages returned. */
  @JsonPropertyDescription(
      "The number of Transactions that are contained in the" + " pages returned.")
  private Integer count;

  /* The list of URLs that represent idrange queries providing the data for
   * each page in the query results. */
  @JsonPropertyDescription(
      "The list of URLs that represent idrange queries providing"
          + " the data for each page in the query results.")
  private List<String> pages;

  /* The ID of the most recent Transaction created for the Account. */
  @JsonProperty("lastTransactionID")
  @JsonPropertyDescription("The ID of the most recent Transaction created for the Account")
  private String lastTransactionId;
}
