package com.mtgdb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mtgdb.Entity.Card;
import com.mtgdb.Entity.Set;
import com.mtgdb.Respository.CardRepository;
import com.mtgdb.Respository.SetRepository;

@RestController
@RequestMapping(path = "/mtgdb")
public class CardController {

	@Autowired
	private CardRepository cardRepository;
	@Autowired
	private SetRepository setRepository;
	
	
	@GetMapping("/card")
	public ResponseEntity<?> getCards() {
		return ResponseEntity.ok(cardRepository.findAll());
	}
	
	@GetMapping("/card/{cardId}")
	public ResponseEntity<?> getCards(@PathVariable Integer cardId) {
		return ResponseEntity.ok(cardRepository.findById(cardId));
	}
	
	@DeleteMapping("/card/{cardId}")
	public void deleteCards(@PathVariable Integer cardId) {
		cardRepository.deleteById(cardId);
	}
	
	@PostMapping("/card")
	public Card addCard(@RequestBody Card card) {
		return cardRepository.save(card);
	}
	
	@PostMapping("/cards")
	public Iterable<Card> addAllCards(@RequestBody List<Card> cards) {
		return cardRepository.saveAll(cards);
	}
	
	@PutMapping("/card/{id}")
	public ResponseEntity<?> updateCard(@PathVariable Integer id, @RequestBody Card newCard) {
		cardRepository.findById(id).get().setName(newCard.getName());
		cardRepository.findById(id).get().setImage(newCard.getImage());
		cardRepository.findById(id).get().setQuote(newCard.getQuote());
		cardRepository.save(cardRepository.findById(id).get());
		return ResponseEntity.ok(cardRepository.findById(id).get());
	}
	
	
	@PutMapping("/cards/{cardId}")
	public void addCardsToSets(@PathVariable Integer cardId, @RequestBody List<String> setsId) {

		Card c = cardRepository.findById(cardId).get();
		for (String setId: setsId) {
			c.addSet(setRepository.findById(setId).get());
			cardRepository.save(c);
		}
	}
	
	@PostMapping("/set")
	public Set addSet(@RequestBody Set set) {
		return setRepository.save(set);
	}

	@PostMapping("/sets")
	public Iterable<Set> addAllSets(@RequestBody List<Set> sets) {
		return setRepository.saveAll(sets);
	}
	
	@GetMapping("/set")
	public ResponseEntity<?> getSets() {
		return ResponseEntity.ok(setRepository.findAll());
	}
}
