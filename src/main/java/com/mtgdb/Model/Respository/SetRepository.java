package com.mtgdb.Model.Respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mtgdb.Model.Entity.Set;

@Repository(value = "setRepository")
public interface SetRepository extends CrudRepository<Set, String>{

	@Query(value = "select s from Set s order by name asc")
	public List<Set> getSetsOrderByNameAsc();
}
