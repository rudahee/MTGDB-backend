package com.mtgdb.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Format implements Comparable<Format> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false)
	private String name;

	@ManyToMany
	@JoinTable(name = "format_expansion",
	joinColumns = @JoinColumn(name="format_id", referencedColumnName="id"),
	inverseJoinColumns = @JoinColumn(name="expansion_id", referencedColumnName="acronym"))
	@JsonIgnore
	private List<Expansion> expansions;

	public Format(String name) {
		super();
		this.name = name;
		expansions = new ArrayList<Expansion>();
	}

	public Format() {
		super();
		expansions = new ArrayList<Expansion>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Expansion> getExpansions() {
		return expansions;
	}

	public void setExpansions(List<Expansion> expansions) {
		this.expansions = expansions;
	}
	
	public void addExpansion (Expansion expansion) {
		this.expansions.add(expansion);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Format other = (Format) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Format [id=" + id + ", name=" + name + ", sets=" + expansions + "]";
	}

	@Override
	public int compareTo(Format f) {
		 if (this.id.equals(f.getId())) {
			return 1;
		} else {
			return -1;
		}
	}
	
}