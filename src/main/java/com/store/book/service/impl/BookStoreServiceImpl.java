package com.store.book.service.impl;

import java.util.Arrays;
import java.util.List;

import com.store.book.service.BookStoreService;
import com.store.book.service.model.Book;

public class BookStoreServiceImpl implements BookStoreService {

	@Override
	public List<Book> getAvailableBooks() {
		return Arrays.asList(Book.values());
	}

}
