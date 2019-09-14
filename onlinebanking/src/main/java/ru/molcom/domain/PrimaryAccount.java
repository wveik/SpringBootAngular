package ru.molcom.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class PrimaryAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    private int accountName;
    private BigDecimal accountBalance;


    private int accountNumber;

    @OneToMany(targetEntity=PrimaryTransaction.class, fetch=FetchType.EAGER)
    private Set<PrimaryTransaction> primaryTransactionList;

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

    public Set<PrimaryTransaction> getPrimaryTransactionList() {
        return primaryTransactionList;
    }

    public void setPrimaryTransactionList(Set<PrimaryTransaction> primaryTransactionList) {
        this.primaryTransactionList = primaryTransactionList;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
}
