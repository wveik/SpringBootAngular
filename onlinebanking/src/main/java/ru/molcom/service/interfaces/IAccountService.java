package ru.molcom.service.interfaces;

import ru.molcom.domain.PrimaryAccount;
import ru.molcom.domain.SavingsAccount;

import java.security.Principal;

public interface IAccountService {
    PrimaryAccount createPrimaryAccount();

    SavingsAccount createSavingsAccount();

    void deposit(String accountType, double amount, Principal principal);

    void withdraw(String accountType, double amount, Principal principal);
}
