package com.mtgdb.Model.Respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mtgdb.Model.Entity.Format;

@Repository(value = "formatRepository")
public interface FormatRepository extends CrudRepository<Format, Integer> {
	
}
