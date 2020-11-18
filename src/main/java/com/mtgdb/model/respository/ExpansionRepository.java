package com.mtgdb.model.respository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mtgdb.model.entity.Expansion;

@Repository(value = "expansionRepository")
public interface ExpansionRepository extends CrudRepository<Expansion, String> {

	@Query(value = "select e from Expansion e order by name asc")
	public List<Expansion> getExpansionOrderByNameAsc();
}
