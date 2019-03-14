package com.trickl.model.oanda.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import com.trickl.model.oanda.transaction.ClientExtensions;
import lombok.Data;

/** The base Order definition specifies the properties that are common to all Orders. */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(
    use = JsonTypeInfo.Id.CUSTOM, 
    include = JsonTypeInfo.As.PROPERTY, 
    property = "type"
)
@JsonTypeIdResolver(OrderTypeIdResolver.class)
@Data
public abstract class Order {

  /** The Order's identifier, unique within the Order's Account. */
  @JsonPropertyDescription("The Order's identifier, unique within the Order's Account.")
  private String id;

  /** The time when the Order was created. */
  @JsonPropertyDescription("The time when the Order was created.")
  private String createTime;

  /** The current state of the Order. */
  @JsonPropertyDescription("The current state of the Order.")
  private OrderState state;

  private ClientExtensions clientExtensions;  
  
  /** The type of the Order. */
  @JsonPropertyDescription("The type of the Order.")
  private OrderType type;
}
