package com.mtgdb.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Expansion implements Comparable<Expansion> {
	
	@Id
	private String id;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToMany(mappedBy = "expansions")
	@JsonIgnore
	private List<Card> cards;

	@ManyToMany(mappedBy = "expansions")
	@JsonIgnore
	private List<Format> formats;
	
	public Expansion(String name, String id) {
		super();
		this.name = name;
		this.id = id;
		this.cards = new ArrayList<Card>();
		this.formats = new ArrayList<Format>();
	}

	public Expansion() {
		super();
		this.cards = new ArrayList<Card>();
		this.formats = new ArrayList<Format>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public List<Card> getCards() {
		return cards;
	}
	
	public List<Format> getFormat() {
		return formats;
	}

	public void setFormat(List<Format> formats) {
		this.formats = formats;
	}

	public void addFormat(Format format) {
		this.formats.add(format);
	}
	
	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Expansion other = (Expansion) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Set [acronym=" + id + ", name=" + name + ", cards=" + cards + ", formats=" + formats + "]";
	}

	@Override
	public int compareTo(Expansion o) {
		 if (this.id.equals(o.getId())) {
			return 1;
		} else {
			return -1;
		}

	}
	
	
}
