package com.mtgdb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mtgdb.model.entity.Card;
import com.mtgdb.model.entity.Document;
import com.mtgdb.model.respository.DocumentRepository;
import com.mtgdb.service.IService;

@Service
public class DocumentUtilsServiceImpl implements IService<Card> {

	@Autowired
	private DocumentRepository docReposiroty;
	@Autowired
	private FileHandlerServiceImpl fhService;
		
	@Override
	public Card addDocument(Integer id, MultipartFile mpf) {
		Card c = null;
		
		try {
			Document doc = docReposiroty.save(new Document(fhService.createBlob(mpf), 
									 mpf.getName(), Integer.valueOf((int) mpf.getSize())));
			
			
		} catch (Exception e) {
			System.out.println("Error!!");
		}
		return null;
	}


}
