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

import com.mtgdb.model.entity.Expansion;
import com.mtgdb.service.impl.PersistenceServiceImpl;

@RestController
@RequestMapping(path = "/mtgdb")
public class ExpansionController {


	@Autowired
	private PersistenceServiceImpl<Expansion, String> persistenceService;
	
	
	@GetMapping("/expansion/{id}")
	public ResponseEntity<?> getExpansion(@PathVariable String cardId) {
		Expansion expansion = persistenceService.getEntityById(cardId);
		HttpStatus status = HttpStatus.OK;
		return ResponseEntity.status(status).body(expansion);
	}
	
	@PostMapping("/expansion")
	public ResponseEntity<?> addExpansion(@RequestBody Expansion expansion) {
		String body = persistenceService.addEntity(expansion);
		HttpStatus status = HttpStatus.OK;
		return ResponseEntity.status(status).body(body);
	}
	
	@PutMapping("/expansion/{id}")
	public ResponseEntity<?> updateExpansion(@PathVariable String id, @RequestBody Expansion expansion) {
		String body = persistenceService.updateEntity(id, expansion);
		HttpStatus status = HttpStatus.OK;
		return ResponseEntity.status(status).body(body);
	}
	
	@DeleteMapping("/expansion/{id}")
	public ResponseEntity<?> deleteCards(@PathVariable String id) {
		String body = persistenceService.deleteEntity(id);
		HttpStatus status = HttpStatus.OK;		
		return ResponseEntity.status(status).body(body);
	}
}
