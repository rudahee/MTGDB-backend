package com.mtgdb.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.mtgdb.model.entity.Card;
import com.mtgdb.service.impl.PersistenceServiceImpl;

@RestController
@RequestMapping(path = "/mtgdb")
public class CardController {

	@Autowired
	private PersistenceServiceImpl<Card, Integer> persistenceService;
	
	
	@GetMapping("/card/{cardId}")
	public ResponseEntity<?> getCards(@PathVariable Integer cardId) {
		Card card = persistenceService.getEntityById(cardId);
		HttpStatus status = HttpStatus.OK;
		return ResponseEntity.status(status).body(card);
	}
	
	@PostMapping("/card")
	public ResponseEntity<?> addCard(@RequestBody Card card) {
		String body = persistenceService.addEntity(card);
		HttpStatus status = HttpStatus.OK;
		return ResponseEntity.status(status).body(body);
	}
	
	@PutMapping("/card/{id}")
	public ResponseEntity<?> updateCard(@PathVariable Integer id, @RequestBody Card newCard) {
		String body = persistenceService.updateEntity(id, newCard);
		HttpStatus status = HttpStatus.OK;
		return ResponseEntity.status(status).body(body);
	}
	
	
	@DeleteMapping("/card/{cardId}")
	public ResponseEntity<?> deleteCards(@PathVariable Integer cardId) {
		String body = persistenceService.deleteEntity(cardId);
		HttpStatus status = HttpStatus.OK;		
		return ResponseEntity.status(status).body(body);
	}
	
	/*
	 * 
	 * 
	 * 
	 *  RECUERDA MODIFICAR LOS HTTP STATUS!!
	 * 
	 * 
	 */

}
