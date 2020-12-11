package com.mtgdb.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import com.mtgdb.model.entity.Card;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class CustomerCardControllerTest {

	 @LocalServerPort
	 private int port;
	 
	 @Autowired 
	 CardController sut;
	
	 @Autowired
	 TestRestTemplate template;
	 
	 private final String URL = "http://localhost:%s/mtgdb/card";
	 
	 @Test
	 public void getCard() {
		 assert(template.getForEntity(getURL(), Card.class).getBody() != null);
	 }
	 

	 @Test
	 public void setCard() {
		Integer id;
		Card card = new Card();
		card.setName("name"); 
		card.setImage("image"); 
		card.setQuote("quote");
		 
		id = template.postForObject(getURL(), card, Integer.class);
		 
		assert(template.getForEntity(getURL()+"/"+id, Card.class).getClass() != null);
	 }
	 
	 private String getURL() {
		 return String.format(URL, port);
	 }
	 
}
