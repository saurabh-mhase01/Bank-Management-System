package com.accounts;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Statement {
    boolean type ;
    double amount ;
    double availableBalance;
    LocalDateTime timestamp;
    public Statement(boolean type, double amount, double availableBalance, LocalDateTime timestamp) {
        super();
        this.type = type;
        this.amount = amount;
        this.availableBalance = availableBalance;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTimestamp = timestamp.format(formatter);

        String statementType = type ? "Credit" : "Debit";
        String sign = type? "+":"-";
        return "Type: " + statementType + " " + "Amount: " + sign + amount + " " + "Available Balance: " + availableBalance + " "  + "Timestamp: " + formattedTimestamp;
    }
}
