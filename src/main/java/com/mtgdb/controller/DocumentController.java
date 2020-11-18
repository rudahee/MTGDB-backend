package com.mtgdb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mtgdb.model.entity.Card;
import com.mtgdb.service.IService;
import com.mtgdb.service.impl.FileHandlerServiceImpl;



@RestController
@RequestMapping(path="/document")
public class DocumentController {
	
	@Autowired
	private IService<Card> service;

	@Autowired
	private FileHandlerServiceImpl fileService;
	
	@PutMapping("/doc/{id}")
	public ResponseEntity<?> uploadPicture(@RequestParam(name = "pic", required = false) MultipartFile pic, 
								@PathVariable(required = false) Integer id){
		
		service.addDocument(id, pic);
		return ResponseEntity.ok("File "+ pic.getOriginalFilename()+ " successfully uploaded");
	}
}
