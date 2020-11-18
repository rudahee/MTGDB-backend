package com.mtgdb.model.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mtgdb.model.entity.Card;
import com.mtgdb.model.entity.Format;

@Repository(value = "formatRepository")
public interface FormatRepository extends CrudRepository<Format, Integer> {
	
}
