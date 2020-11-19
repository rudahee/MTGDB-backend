package com.mtgdb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mtgdb.model.entity.Document;
import com.mtgdb.model.respository.DocumentRepository;
import com.mtgdb.service.IService;

@Service
public class DocumentUtilsServiceImpl implements IService<Document> {

	@Autowired
	private DocumentRepository docRepository;
	@Autowired
	private FileHandlerServiceImpl fhService;
		
	@Override
	public void addDocument(MultipartFile mpf) {		
		try {
			docRepository.save(new Document(fhService.createBlob(mpf), 
									 mpf.getName(), Integer.valueOf((int) mpf.getSize())));
					
		} catch (Exception e) {
			System.out.println("Error!!");
		}
	}

	@Override
	public Document getDocument(Long id) {
		Document doc = docRepository.findById(id).get();
				
		return doc;
	}

}
