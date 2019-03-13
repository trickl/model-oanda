package com.trickl.model.oanda.transaction;

import lombok.Builder;
import lombok.Data;

/** A MarginCallEnterTransaction is created when an Account enters the margin call state. */
@Data
@Builder
public class MarginCallEnterTransaction extends Transaction {
}
