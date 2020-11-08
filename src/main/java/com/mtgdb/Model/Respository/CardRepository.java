package com.mtgdb.Model.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mtgdb.Model.Entity.Card;
import com.mtgdb.Model.Entity.Format;

@Repository(value = "cardRepository")
public interface CardRepository extends CrudRepository<Card, Integer>{
	
	@Query(value="SELECT distinct(f.name)\n" + 
			" FROM card c, `set` s, format f, card_set cs, format_set fs\n" + 
			" WHERE c.id = cs.card_id\n" + 
			" AND cs.set_id = s.acronym\n" + 
			" AND s.acronym = fs.set_id\n" + 
			" AND fs.format_id = f.id\n" + 
			" AND c.id = ?1", nativeQuery=true)
	public List<String> FormatsAvailableForCard(Integer formatId);
	
	
	
	@Query(value = "select * from card c where c.name LIKE %?1%", nativeQuery=true)
	public List<Card> getAllCardsContainsStringInName(String name);
	
	public Card getCardByName(String name);
	
}
