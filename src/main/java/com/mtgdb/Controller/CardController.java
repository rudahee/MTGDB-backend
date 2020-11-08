package com.mtgdb.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mtgdb.Model.Entity.Card;
import com.mtgdb.Model.Entity.Format;
import com.mtgdb.Model.Entity.Set;
import com.mtgdb.Service.CardService;
import com.mtgdb.Service.SetService;

@RestController
@RequestMapping(path = "/mtgdb")
public class CardController {

	@Autowired
	private SetService setService;
	
	@Autowired CardService cardService;
		
	@GetMapping("/card")
	public ResponseEntity<?> getCards() {	
		List<Card> cards = cardService.getAllCards();
		HttpStatus status = cardService.getStatus();
		
		return ResponseEntity.status(status).body(cards);
	}
	
	@GetMapping("/formatsavailableforcard/{cardId}")
	public ResponseEntity<?> getCardsInFormat(@PathVariable Integer cardId) {
		List<String> cards = cardService.FormatsAvailableForCard(cardId);
		HttpStatus status = cardService.getStatus();
		
		return ResponseEntity.status(status).body(cards);
	}
	
	@GetMapping("/all-card-string")
	public ResponseEntity<?> getAllCardsContainsStringInName(@RequestParam String string) {
		List<Card> cards = cardService.getCardsContaisStringInName(string);
		HttpStatus status = cardService.getStatus();
		
		return ResponseEntity.status(status).body(cards);
	}
	@GetMapping("/all-card-name/{name}")
	public ResponseEntity<?> getCardByName(@PathVariable String name) {
		Card card = cardService.getCardByName(name);
		HttpStatus status = cardService.getStatus();
		
		return ResponseEntity.status(status).body(card);
	}
	
	@GetMapping("/card/{cardId}")
	public ResponseEntity<?> getCards(@PathVariable Integer cardId) {
		Card card = cardService.getCardById(cardId);
		HttpStatus status = cardService.getStatus();
		
		return ResponseEntity.status(status).body(card);
	}
	
	@PostMapping("/card")
	public ResponseEntity<?> addCard(@RequestBody Card card) {
		String body = cardService.addCard(card);
		HttpStatus status = cardService.getStatus();
		
		return ResponseEntity.status(status).body(body);
	}
	
	@PostMapping("/cards")
	public ResponseEntity<?> addAllCards(@RequestBody List<Card> cards) {
		String body = cardService.addListCard(cards);
		HttpStatus status = cardService.getStatus();
		
		return ResponseEntity.status(status).body(body);
	}

	@PutMapping("/card/{id}")
	public ResponseEntity<?> updateCard(@PathVariable Integer id, @RequestBody Card newCard) {
		String body = cardService.updateCard(id, newCard);
		HttpStatus status = cardService.getStatus();
		
		return ResponseEntity.status(status).body(body);
	}
	
	
	@PutMapping("/cards/{cardId}")
	public ResponseEntity<?> addCardsToSets(@PathVariable Integer cardId, @RequestBody List<String> setsId) {
		String body = cardService.addCardsToSets(cardId, setsId);
		HttpStatus status = cardService.getStatus();
		
		return ResponseEntity.status(status).body(body);
		
	}
	
	@DeleteMapping("/card/{cardId}")
	public ResponseEntity<?> deleteCards(@PathVariable Integer cardId) {
		String body = cardService.deleteCard(cardId);
		HttpStatus status = cardService.getStatus();
		
		return ResponseEntity.status(status).body(body);
	}
	
	
	@GetMapping("/set")
	public ResponseEntity<?> getSets() {
		List<Set> sets = setService.getAllsets();
		HttpStatus status = setService.getStatus();
		
		return ResponseEntity.status(status).body(sets);	
	}
	
	@PostMapping("/set")
	public ResponseEntity<?> addSet(@RequestBody Set set) {
		String body = setService.addSet(set);
		HttpStatus status = setService.getStatus();
		
		return ResponseEntity.status(status).body(body);
	}

	@PostMapping("/sets")
	public ResponseEntity<?> addAllSets(@RequestBody List<Set> sets) {
		String body = setService.addListSet(sets);
		HttpStatus status = setService.getStatus();
		
		return ResponseEntity.status(status).body(body);
	}

	@PutMapping("/set/{id}")
	public ResponseEntity<?> updateSet(@PathVariable String id, @RequestBody Set newSet) {
		String body = setService.updateSet(id, newSet);
		HttpStatus status = setService.getStatus();
		
		return ResponseEntity.status(status).body(body);
	}
	
	@DeleteMapping("/set/{setId}")
	public ResponseEntity<?> deleteCards(@PathVariable String setId) {
		String body = setService.deleteSet(setId);
		HttpStatus status = setService.getStatus();
		
		return ResponseEntity.status(status).body(body);
	}
	
}
