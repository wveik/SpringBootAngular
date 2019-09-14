package ru.molcom.dao;

import org.springframework.data.repository.CrudRepository;
import ru.molcom.domain.SavingsAccount;

/**
 * Created by z00382545 on 10/21/16.
 */
public interface ISavingsAccountDao extends CrudRepository<SavingsAccount, Long> {

    SavingsAccount findByAccountNumber(int accountNumber);
}
