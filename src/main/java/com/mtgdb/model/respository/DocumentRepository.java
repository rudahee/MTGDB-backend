package com.mtgdb.model.respository;

import org.springframework.data.repository.CrudRepository;

import com.mtgdb.model.entity.Document;

public interface DocumentRepository extends CrudRepository<Document, Long> {

}
