package com.trickl.model.oanda.transaction;

/** The reason that an Account is being funded. */
enum FundingReason {
  CLIENT_FUNDING,
  ACCOUNT_TRANSFER,
  DIVISION_MIGRATION,
  SITE_MIGRATION,
  ADJUSTMENT;
}
