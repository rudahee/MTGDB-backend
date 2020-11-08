package com.mtgdb.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mtgdb.Model.Respository.FormatRepository;

@Service
public class FormatService {
	private HttpStatus status = null;
	private Object responseObject;
	private List<Object> responseList;
	
	@Autowired
	private FormatRepository formatRepository;
	
}
