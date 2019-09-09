package ru.molcom.domain;

import java.math.BigDecimal;
import java.util.List;

public class PrimaryAccount {
    private Long accountId;
    private int accountName;
    private BigDecimal accountBalance;

    private List<PrimaryTransaction> primaryTransactionList;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public int getAccountName() {
        return accountName;
    }

    public void setAccountName(int accountName) {
        this.accountName = accountName;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public List<PrimaryTransaction> getPrimaryTransactionList() {
        return primaryTransactionList;
    }

    public void setPrimaryTransactionList(List<PrimaryTransaction> primaryTransactionList) {
        this.primaryTransactionList = primaryTransactionList;
    }
}
