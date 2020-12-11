package com.mtgdb.model.entity;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Blob image;
	
	private String name;
	
	private Integer size;
	
	public Document() {
		super();
	}
	
	public Document(Blob image, String name, Integer size) {
		this.image = image;
		this.name = name;
		this.size = size;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}

	public String getFileName() {
		return name;
	}

	public void setFileName(String fileName) {
		this.name = fileName;
	}

	public Integer getFileSize() {
		return size;
	}

	public void setFileSize(Integer fileSize) {
		this.size = fileSize;
	}
	
}
