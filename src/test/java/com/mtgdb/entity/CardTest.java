package com.mtgdb.entity;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.event.annotation.BeforeTestExecution;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.mtgdb.controller.CardController;
import com.mtgdb.model.entity.Card;
import com.mtgdb.model.respository.CardRepository;
import com.mtgdb.service.IService;
import java.util.stream.Stream;

@WebMvcTest(CardController.class)
public class CardTest {
	@Autowired
	private MockMvc mockMVC; 
	
	@MockBean
	private CardRepository cardRepo;

	@MockBean
	private IService service; 
	
	private final static String ROOT_PATH = "/customer";
	
	@BeforeTestExecution
	private void init() {
		
	}
	
	private static Stream<Arguments> postDataProvider(){
		return Stream.of(
						Arguments.of(null, status().isBadRequest()),
						Arguments.of(Integer.valueOf(3), status().is2xxSuccessful()),
						Arguments.of(Integer.valueOf(15), status().isCreated())
					);
	}
	
	@ParameterizedTest
	@MethodSource("postDataProvider")
	public void postNewCard(Integer id, ResultMatcher expectedResult) throws Exception {
		Card mockCard = Mockito.mock(Card.class);
		
		Mockito.when(mockCard.getId()).thenReturn(id);
		Mockito.when(cardRepo.save(Mockito.any())).thenReturn(mockCard);
		
		mockMVC.perform(MockMvcRequestBuilders.post(ROOT_PATH)
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(""))
			.andExpect(expectedResult);
		
	}
	
}
