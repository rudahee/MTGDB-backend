package com.mtgdb.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mtgdb.model.entity.Document;


@Service
public interface IService<T> {
	public static final String NUMBER_REG = "[0-9]*";
	
	
	public void addDocument(MultipartFile mpf);
	
	public Document getDocument(Long id);
}
