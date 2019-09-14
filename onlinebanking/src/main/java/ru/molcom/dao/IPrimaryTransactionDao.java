package ru.molcom.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import ru.molcom.domain.PrimaryTransaction;

public interface IPrimaryTransactionDao extends CrudRepository<PrimaryTransaction, Long> {

    List<PrimaryTransaction> findAll();
}
