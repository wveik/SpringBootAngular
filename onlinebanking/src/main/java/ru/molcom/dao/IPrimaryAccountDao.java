package ru.molcom.dao;

import org.springframework.data.repository.CrudRepository;
import ru.molcom.domain.PrimaryAccount;

/**
 * Created by z00382545 on 10/21/16.
 */
public interface IPrimaryAccountDao extends CrudRepository<PrimaryAccount,Long> {

    PrimaryAccount findByAccountNumber(int accountNumber);
}
