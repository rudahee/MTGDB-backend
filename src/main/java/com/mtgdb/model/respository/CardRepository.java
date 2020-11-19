package com.mtgdb.model.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mtgdb.model.entity.Card;

@Repository(value = "cardRepository")
public interface CardRepository extends CrudRepository<Card, Integer>{
	
	@Query(value="SELECT distinct(f.name)\n" + 
			" FROM card c, expansion e, format f, card_expansion ce, format_expansion fe\n" + 
			" WHERE c.id = ce.card_id\n" + 
			" AND ce.expansion_id = e.acronym\n" + 
			" AND e.acronym = fe.expansion_id\n" + 
			" AND fe.format_id = f.id\n" + 
			" AND c.id = ?1", nativeQuery=true)
	public List<String> FormatsAvailableForCard(Integer formatId);
	
	@Query(value = "select * from card c where c.name LIKE %?1%", nativeQuery=true)
	public List<Card> getAllCardsContainsStringInName(String name);
	
	public Card getCardByName(String name);
	
}
