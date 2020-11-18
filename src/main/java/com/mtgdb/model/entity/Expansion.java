package com.mtgdb.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Expansion implements Comparable<Expansion> {
	
	@Id
	@Column(length = 3)
	private String acronym;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToMany(mappedBy = "expansions")
	@JsonIgnore
	private List<Card> cards;

	@ManyToMany(mappedBy = "expansions")
	@JsonIgnore
	private List<Format> formats;
	
	public Expansion(String name, String acronym) {
		super();
		this.name = name;
		this.acronym = acronym;
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

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
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
		result = prime * result + ((acronym == null) ? 0 : acronym.hashCode());
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
		if (acronym == null) {
			if (other.acronym != null)
				return false;
		} else if (!acronym.equals(other.acronym))
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
		return "Set [acronym=" + acronym + ", name=" + name + ", cards=" + cards + ", formats=" + formats + "]";
	}

	@Override
	public int compareTo(Expansion o) {
		 if (this.acronym.equals(o.getAcronym())) {
			return 1;
		} else {
			return -1;
		}

	}
	
	
}
