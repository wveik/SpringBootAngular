package ru.molcom.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import ru.molcom.domain.Recipient;


public interface IRecipientDao extends CrudRepository<Recipient, Long> {
    List<Recipient> findAll();

    Recipient findByName(String recipientName);

    void deleteByName(String recipientName);
}
