package com.mtgdb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.mtgdb.model.entity.Expansion;

@Service
public class ValidationServiceImpl<T, ID> {
	
	private Boolean valid;
	
	@Autowired
	private CrudRepository<T, ID> repository;

		public String validateAcronym(Expansion expansion) {
		String response;
		valid = false;
		
		if (expansion.getId().length() != 3) {
			response = "El acronimo no tiene la longitud adecuada";
		} else {
			response = "L a carta es valida";
			valid = true;
		}
		return response;
	}


	public Boolean isValid() {
		return valid;
	}


	public void setStatus(Boolean status) {
		this.valid = status;
	}
}
