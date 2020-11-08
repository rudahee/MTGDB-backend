package com.mtgdb.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.mtgdb.Model.Entity.Card;
import com.mtgdb.Model.Entity.Format;
import com.mtgdb.Model.Respository.CardRepository;
import com.mtgdb.Model.Respository.SetRepository;

@Service
public class CardService {
	private HttpStatus status = null;
	private Object responseObject;
	private List<Object> responseList;
	
	@Autowired
	private CardRepository cardRepository;
	@Autowired
	private SetRepository setRepository;
	
	public List<Card> getAllCards() {
		status = HttpStatus.OK;
		
		return cardRepository.count() == 0 ? null: (List<Card>) cardRepository.findAll();
	}
	
	public Card getCardByName(String name) {
		status = HttpStatus.OK;
		
		return cardRepository.getCardByName(name);
	}
	
	public Card getCardById(Integer id) {
		if (cardRepository.existsById(id)) {
			status = HttpStatus.OK;
			responseObject = cardRepository.findById(id).get();
		} else {
			status = HttpStatus.CONFLICT;
		}
		return (Card) responseObject;
	}
	
	public String addCard(Card card) {
		status = HttpStatus.OK;
		responseObject = "La carta se ha agregado correctamente";
		cardRepository.save(card);
		
		return (String) responseObject;
	}
	
	public String addListCard(List<Card> cards) {
		status = HttpStatus.OK;
		responseObject = "La lista de cartas se agregado correctamente";
		cardRepository.saveAll(cards);
		
		return (String) responseObject;
	}
	
	public String updateCard(Integer id, Card card) {
		if (cardRepository.existsById(id)) {
			status = HttpStatus.OK;
			
			cardRepository.findById(id).get().setName(card.getName());
			cardRepository.findById(id).get().setImage(card.getImage());
			cardRepository.findById(id).get().setQuote(card.getQuote());
			cardRepository.save(cardRepository.findById(id).get());
			
			responseObject = "Se ha editado la carta correctamente";
		} else {
			status = HttpStatus.CONFLICT;
			responseObject = "No se encuentra la carta";
		}
		
	
		return (String) responseObject;
	}
	public String deleteCard(Integer id) {
		if (cardRepository.existsById(id)) {
			cardRepository.deleteById(id);
			status = HttpStatus.OK;
			responseObject = "La carta se ha eliminado satisfactoriamente";
		} else {
			responseObject = "No existe una carta con ese ID";
			status = HttpStatus.CONFLICT;
		}
		return (String) responseObject;
	}

	public String addCardsToSets(Integer cardId, List<String> setsId) {
		this.status = HttpStatus.OK;
		this.responseObject = "La relacion se ha establecido correctamente";
		if (cardRepository.existsById(cardId)) {
			Card c = cardRepository.findById(cardId).get();
			
			setsId.forEach((String setId) -> {
				c.addSet(setRepository.findById(setId).get());
				cardRepository.save(c);
			});
		} else {
			status = HttpStatus.CONFLICT;
			this.responseObject = "No se ha podido realizar la relacion";
		}
		
		return (String) responseObject;
	}
	
	public List<String> FormatsAvailableForCard(Integer cardId) {
		status = HttpStatus.OK;
		return cardRepository.FormatsAvailableForCard(cardId);
	}
	 
	public List<Card> getCardsContaisStringInName(String string) {
		status = HttpStatus.OK;
		
		return cardRepository.getAllCardsContainsStringInName(string);
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	
		
		/*
		for (String setId: setsId) {
			c.addSet(setRepository.findById(setId).get());
			cardRepository.save(c);
		}
	*/
	
}
