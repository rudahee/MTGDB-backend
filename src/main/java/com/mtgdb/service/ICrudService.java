package com.mtgdb.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ICrudService<T, S> {

	public T getEntityById(S id);
	
	public String addEntity (T entity);
	
	public String addEntities(List<T> entities);
	
	public String updateEntity (S id, T entity);
	
	public String deleteEntity(S id);

	
}