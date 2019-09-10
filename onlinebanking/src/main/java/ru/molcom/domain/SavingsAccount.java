package ru.molcom.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
public class SavingsAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long savingId;
    private int accountNumber;
    private BigDecimal accountBalance;

    @OneToMany(targetEntity=SavingsTransaction.class, fetch=FetchType.EAGER)
    private Set<SavingsTransaction> savingsTransactions;

    public Long getSavingId() {
        return savingId;
    }

    public void setSavingId(Long savingId) {
        this.savingId = savingId;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(BigDecimal accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Set<SavingsTransaction> getSavingsTransactions() {
        return savingsTransactions;
    }

    public void setSavingsTransactions(Set<SavingsTransaction> savingsTransactions) {
        this.savingsTransactions = savingsTransactions;
    }
}
