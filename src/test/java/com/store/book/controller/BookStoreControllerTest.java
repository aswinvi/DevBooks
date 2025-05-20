package com.store.book.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.store.book.mapper.ResponseObjectMapper;
import com.store.book.service.impl.BookStoreServiceImpl;
import com.store.book.service.model.Book;

@SpringBootTest
@AutoConfigureMockMvc
class BookStoreControllerTest {

	public static final String ALL_BOOK_DETAILS_JSON = "[{\"title\":\"Clean Code\",\"isbn\":\"12345\",\"yearOfPublish\":\"2008\",\"price\":\"50\",\"authorName\":\"Robert Martin\"},{\"title\":\"The Clean Coder\",\"isbn\":\"23451\",\"yearOfPublish\":\"2011\",\"price\":\"50\",\"authorName\":\"Robert Martin\"},{\"title\":\"Clean Architecture\",\"isbn\":\"34512\",\"yearOfPublish\":\"2017\",\"price\":\"50\",\"authorName\":\"Robert Martin\"},{\"title\":\"Test Driven Development by Example\",\"isbn\":\"45123\",\"yearOfPublish\":\"2003\",\"price\":\"50\",\"authorName\":\"Kent Beck\"},{\"title\":\"Working Effectively With Legacy Code\",\"isbn\":\"51234\",\"yearOfPublish\":\"2004\",\"price\":\"50\",\"authorName\":\"Michael C. Feathers\"}]> but was:<[{\"title\":\"Clean Code\",\"isbn\":\"12345\",\"yearOfPublish\":\"2008\",\"price\":\"50\",\"authorName\":\"Robert Martin\"},{\"title\":\"The Clean Coder\",\"isbn\":\"23451\",\"yearOfPublish\":\"2011\",\"price\":\"50\",\"authorName\":\"Robert Martin\"},{\"title\":\"Clean Architecture\",\"isbn\":\"34512\",\"yearOfPublish\":\"2017\",\"price\":\"50\",\"authorName\":\"Robert Martin\"},{\"title\":\"Test Driven Development by Example\",\"isbn\":\"45123\",\"yearOfPublish\":\"2003\",\"price\":\"50\",\"authorName\":\"Kent Beck\"},{\"title\":\"Working Effectively With Legacy Code\",\"isbn\":\"51234\",\"yearOfPublish\":\"2004\",\"price\":\"50\",\"authorName\":\"Michael C. Feathers\"}]";

	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private ResponseObjectMapper responseMapper;

	@MockitoBean
	private BookStoreServiceImpl bookStoreService;

	@Test
	void shouldReturn200WhenListingAllBooks() throws Exception {
		mockMvc.perform(get("/store/books").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
	}

	@Test
	void shouldGetAllBooksAvailableWhenInvokeBooksAPI() throws Exception {

		List<Book> mockBooks = List.of(Book.values());

		when(bookStoreService.getAvailableBooks()).thenReturn(mockBooks);

		mockMvc.perform(get("/store/books").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		verify(bookStoreService, times(1)).getAvailableBooks();
		verify(responseMapper, times(1)).toBookInfoResponse(mockBooks);
	}
}
