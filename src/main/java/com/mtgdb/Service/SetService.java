package com.mtgdb.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mtgdb.Model.Entity.Set;
import com.mtgdb.Model.Respository.SetRepository;

@Service
public class SetService {
	private HttpStatus status = null;
	private Object responseObject;
	private List<Object> responseList;
	
	@Autowired
	private SetRepository setRepository;
	
	public List<Set> getAllsets() {
		status = HttpStatus.OK;
		
		return setRepository.count() == 0 ? null: (List<Set>) setRepository.findAll();
	}
	
	public Set getSetById(String id) {
		if (setRepository.existsById(id)) {
			status = HttpStatus.OK;
			responseObject = setRepository.findById(id).get();
		} else {
			status = HttpStatus.CONFLICT;
		}
		return (Set) responseObject;
	}
	
	public String addSet(Set set) {
		status = HttpStatus.OK;
		responseObject = "La ampliacion se ha agregado correctamente";
		setRepository.save(set);
		
		return (String) responseObject;
	}
	
	public String addListSet(List<Set> sets) {
		status = HttpStatus.OK;
		responseObject = "La lista de ampliaciones se agregado correctamente";
		setRepository.saveAll(sets);
		
		return (String) responseObject;
	}
	
	public String updateSet(String id, Set set) {
		if (setRepository.existsById(id)) {
			status = HttpStatus.OK;
			setRepository.findById(id).get().setName(set.getName());
			setRepository.save(setRepository.findById(id).get());
			
			responseObject = "Se ha editado la ampliacion correctamente";
		} else {
			status = HttpStatus.CONFLICT;
			responseObject = "No se encuentra la ampliacion";
		}
		
	
		return (String) responseObject;
	}
	public String deleteSet(String id) {
		if (setRepository.existsById(id)) {
			setRepository.deleteById(id);
			status = HttpStatus.OK;
			responseObject = "La ampliacion se ha eliminado satisfactoriamente";
		} else {
			responseObject = "No existe una ampliacion con ese ID";
			status = HttpStatus.CONFLICT;
		}
		return (String) responseObject;
	}

	

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
