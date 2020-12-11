package com.mtgdb.model.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mtgdb.model.entity.Document;

@Repository
public interface DocumentRepository extends CrudRepository<Document, Long> {

}
