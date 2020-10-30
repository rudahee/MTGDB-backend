package com.mtgdb.Respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mtgdb.Entity.Set;

@Repository(value = "setRepository")
public interface SetRepository extends CrudRepository<Set, String>{

}
