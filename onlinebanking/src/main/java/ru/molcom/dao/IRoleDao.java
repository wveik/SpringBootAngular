package ru.molcom.dao;

import org.springframework.data.repository.CrudRepository;
import ru.molcom.domain.security.Role;


public interface IRoleDao extends CrudRepository<Role, Integer> {
    Role findByName(String name);
}
