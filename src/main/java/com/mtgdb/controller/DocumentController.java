package com.mtgdb.controller;

import java.sql.Blob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mtgdb.model.entity.Document;
import com.mtgdb.service.IService;
import com.mtgdb.service.impl.FileHandlerServiceImpl;



@RestController
@RequestMapping(path="/document")
public class DocumentController {
	
	@Autowired
	private IService<Document> service;

	@Autowired
	private FileHandlerServiceImpl fileService;
	
	@PutMapping("")
	public ResponseEntity<?> uploadPicture(@RequestParam(name = "pic", required = false) MultipartFile pic){
		
		service.addDocument(pic);
		return ResponseEntity.ok("File "+ pic.getOriginalFilename()+ " successfully uploaded");
	}
	@GetMapping("{id}")
	public ResponseEntity<?> downloadPicture(@PathVariable Long id){
		HttpHeaders headers = new HttpHeaders();
		Document pic = service.getDocument(id);
		Blob blob = pic.getImage();
		byte[] bytes = fileService.createInputStream(blob);
		headers.set("Content-Disposition", String.format("attachment; filename="+pic.getFileName()));
		
        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(bytes.length)
                .body(bytes);	
        }
}
