package com.mtgdb.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mtgdb.model.entity.Card;
import com.mtgdb.service.ICrudService;

@Service
public class PersistenceServiceImpl<T, S> implements ICrudService<T, S>{
	
	private HttpStatus status = null;
	
	@Autowired
	private  Map<String, CrudRepository<T, S>> repositories;

	private CrudRepository<T, S> repository;
	private T entity;
	
	
	public List<T> getAllEntities() {
		repository = repositories.get(determineClass(entity));
		return repository.count() == 0 ? null: (List<T>) repository.findAll();
	}
	
	@Override
	public T getEntityById(S id) {
		repository = repositories.get(determineClass(entity));
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
		repository = repositories.get(determineClass(entity));
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
	public String updateEntity(S id, T entity) {
		repository = repositories.get(determineClass(entity));

		repository.delete(repository.findById(id).get());
		repository.save(entity);
		return "Se modifico una entidad";
	}

	@Override
	public String deleteEntity(S id) {
		repository = repositories.get(determineClass(entity));

		
		repository.delete(repository.findById(id).get());

		return "Se borro una entidad";
		
	}

	
	private String determineClass(T entity) {
		return entity.getClass().getSimpleName() + "Repository";
	}
	
	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
