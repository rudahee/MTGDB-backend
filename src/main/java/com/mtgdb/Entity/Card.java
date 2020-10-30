package com.mtgdb.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Card implements Comparable<Card> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(nullable = false)
	private String name;
	private String quote;
	private String image;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "card_set",
		joinColumns = @JoinColumn(name="card_id", referencedColumnName="id"),
		inverseJoinColumns = @JoinColumn(name="set_id", referencedColumnName="acronym"))
	@JsonIgnore
	private List<Set> sets;

	public Card(String name, String comentario, String image) {
		super();
		this.name = name;
		this.image = image;
		this.quote = comentario;
		this.sets = new ArrayList<Set>();
	}

	public Card(String name) {
		super();
		this.name = name;
		this.sets = new ArrayList<Set>();
	}
	
	public Card(String name, String image) {
		super();
		this.name = name;
		this.image = image;
		this.sets = new ArrayList<Set>();
	}

	public Card() {
		super();
		this.sets = new ArrayList<Set>();
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setSets(List<Set> sets) {
		this.sets = sets;
	}

	public List<Set> getSets() {
		return sets;
	}
	
	public void addSet (Set set) {
		this.sets.add(set);
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
		Card other = (Card) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", name=" + name + ", quote=" + quote + ", image=" + image + ", sets=" + sets + "]";
	}

	@Override
	public int compareTo(Card o) {
		if (this.id < o.getId()) {
			return -1;
		} else if (this.id.equals(o.getId())) {
			return 0;
		} else {
			return 1;
		}

	}

}
