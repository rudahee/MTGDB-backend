package com.mtgdb.service.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;

import com.mtgdb.model.entity.Card;
import com.mtgdb.model.respository.CardRepository;

public class PersistenceServiceTest {

	private PersistenceServiceImpl<Card, Integer> sut;
	
	private ValidationServiceImpl mockValidService;
	private CardRepository mockCardRepository;
	
	/*
	@BeforeEach
	private void init() {
		mockValidService = Mockito.mock(ValidationServiceImpl.class);
		mockCardRepository = Mockito.mock(CardRepository.class);
		sut = new PersistenceServiceImpl<Card, Integer>();
		//sut.setValidationService(mockValidService);
		//sut.setRepository(mockCardRepository);
	}
	
	
	@Test
	public void addValidCardTest() {
		//Mockito.when(mockValidService.validateCard(Mockito.any(Card.class))).thenReturn("true");	
		Mockito.when(mockValidService.isValid()).thenReturn(true);
		
		
		//assert(sut.addCard(new Card("Carta de prueba 1")) == "true");
		assert(sut.getStatus() == HttpStatus.CREATED);
	}
	*/

}
