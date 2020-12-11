package com.mtgdb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mtgdb.model.entity.Expansion;
import com.mtgdb.service.ICrudService;


@Service
public class PersistenceServiceImpl<T, ID> implements ICrudService<T, ID>{
	
	private HttpStatus status = null;

	@Autowired
	private CrudRepository<T, ID> repository;
	
	@Autowired
	private ValidationServiceImpl<T, ID> validService;
	

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public List<T> getAllEntities() {
		return repository.count() == 0 ? null: (List<T>) repository.findAll();
	}
	
	@Override
	public T getEntityById(ID id) {
		T response = null;
		
		if (repository.existsById(id)) {
			status = HttpStatus.OK;
			response =  repository.findById(id).get();
		} else {
			status = HttpStatus.CONFLICT;
		}
		return response;
	}

	@Override
	public String addEntity(T entity) {
		String response = "Se ha producido un error al crear la entidad";
		
		try {
			repository.save(entity);
			status = HttpStatus.CREATED;
			response = "Se ha agregado una entidad";
		} catch (Exception e) {
			status = HttpStatus.CONFLICT;
		}
		return response;
	}

	@Override
	public String addEntities(List<T> entities) {
		String response = "Se ha producido un error al crear las entidades";
		repository.saveAll(entities);

		try {
			status = HttpStatus.CREATED;
			response = "Se han agregado las entidades";
		} catch (Exception e) {
			status = HttpStatus.CONFLICT;
		}
		return response;
	}
	
	@Override
	public String updateEntity(ID id, T entity) {
		repository.delete(repository.findById(id).get());
		repository.save(entity);
		return "Se modifico una entidad";
	}

	@Override
	public String deleteEntity(ID id) {		
		repository.delete(repository.findById(id).get());

		return "Se borro una entidad";
		
	}
	
	public String addExpansion(T entity) {
		String response = "Se ha producido un error al crear la entidad";
		
		
		response = validService.validateAcronym((Expansion) entity);
		
		if (validService.isValid()) {
			repository.save(entity);
			status = HttpStatus.CREATED;
			response = "Se ha agregado una entidad";
		} else {
			status = HttpStatus.CONFLICT;
		}
		return response;
	}
	

}
