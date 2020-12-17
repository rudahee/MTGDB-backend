package com.mtgdb.model.respository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mtgdb.model.entity.Expansion;

@Repository
public interface ExpansionRepository extends CrudRepository<Expansion, String>{

}
