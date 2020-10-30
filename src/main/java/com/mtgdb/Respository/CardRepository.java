package com.mtgdb.Respository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mtgdb.Entity.Card;

@Repository(value = "cardRepository")
public interface CardRepository extends CrudRepository<Card, Integer>{

	
}
