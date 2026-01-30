package model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

// The tips I used here
// 1. Use final for immutable fields
// 2. Use BigDecimal for money (Critical)
// 3. Add Account type and creation date
public class BankAccount{
    private final String accountNumber;
    private final String ownerName;
    private BigDecimal balance;
    private final AccountType type;
    private final java.time.LocalDateTime createdAt;
}