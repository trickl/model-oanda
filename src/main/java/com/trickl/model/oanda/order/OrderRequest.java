package com.trickl.model.oanda.order;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import lombok.Data;

/** The base Order specification used when requesting that an Order be created.
 * Each specific Order-type extends this definition."
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(
    use = JsonTypeInfo.Id.CUSTOM, 
    include = JsonTypeInfo.As.PROPERTY, 
    property = "type"
)
@JsonTypeIdResolver(OrderRequestTypeIdResolver.class)
@Data
public abstract class OrderRequest {

  /** The type of the Order. */
  @JsonPropertyDescription("The type of the Order to create.")
  private OrderRequestType type;
}
