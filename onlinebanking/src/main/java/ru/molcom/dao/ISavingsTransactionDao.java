package ru.molcom.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import ru.molcom.domain.SavingsTransaction;


public interface ISavingsTransactionDao extends CrudRepository<SavingsTransaction, Long> {

    List<SavingsTransaction> findAll();
}

