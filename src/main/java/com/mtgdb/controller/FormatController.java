package com.mtgdb.controller;

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
import org.springframework.web.bind.annotation.RestController;

import com.mtgdb.model.entity.Format;
import com.mtgdb.service.impl.PersistenceServiceImpl;

@RestController
@RequestMapping(path = "/mtgdb")
public class FormatController {

	
	@Autowired
	private PersistenceServiceImpl<Format, Integer> persistenceService;
	
	
	@GetMapping("/format/{id}")
	public ResponseEntity<?> getFormat(@PathVariable Integer id) {
		Format format = persistenceService.getEntityById(id);
		HttpStatus status = HttpStatus.OK;
		return ResponseEntity.status(status).body(format);
	}
	
	@PostMapping("/format")
	public ResponseEntity<?> addFormat(@RequestBody Format format) {
		String body = persistenceService.addEntity(format);
		HttpStatus status = HttpStatus.OK;
		return ResponseEntity.status(status).body(body);
	}
	@PostMapping("/formats")
	public ResponseEntity<?> addFormats(@RequestBody List<Format> formats) {
		String body = persistenceService.addEntities(formats);
		HttpStatus status = HttpStatus.OK;
		return ResponseEntity.status(status).body(body);
	}
	
	@PutMapping("/format/{id}")
	public ResponseEntity<?> updateFormat(@PathVariable Integer id, @RequestBody Format format) {
		String body = persistenceService.updateEntity(id, format);
		HttpStatus status = HttpStatus.OK;
		return ResponseEntity.status(status).body(body);
	}
	
	
	@DeleteMapping("/format/{id}")
	public ResponseEntity<?> deleteCards(@PathVariable Integer id) {
		String body = persistenceService.deleteEntity(id);
		HttpStatus status = HttpStatus.OK;		
		return ResponseEntity.status(status).body(body);
	}
}
