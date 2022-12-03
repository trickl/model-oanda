package com.trickl.model.oanda.order;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonTypeIdResolver;
import com.trickl.model.oanda.transaction.ClientExtensions;
import java.time.Instant;
import lombok.Data;
import lombok.NoArgsConstructor;

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
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.nnnnnnnnnX", timezone = "UTC")
  private Instant createTime;

  /** The current state of the Order. */
  @JsonPropertyDescription("The current state of the Order.")
  private OrderState state;

  private ClientExtensions clientExtensions;
  
  abstract OrderType getType();
}
