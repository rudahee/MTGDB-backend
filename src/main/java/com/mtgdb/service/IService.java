package com.mtgdb.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public interface IService<T> {
	public static final String NUMBER_REG = "[0-9]*";
	
	
	public T addDocument(Integer id, MultipartFile mpf);
	
}
