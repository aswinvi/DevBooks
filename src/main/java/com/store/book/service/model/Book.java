package com.store.book.service.model;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.store.book.exception.SNNotFoundException;

public enum Book {

	CLEAN_CODE("10001", "Clean Code", "Robert Martin", "2008", new BigDecimal("50")),
	CLEAN_CODER("10002", "The Clean Coder", "Robert Martin", "2011", new BigDecimal("50")),
	CLEAN_ARCHITECTURE("10032", "Clean Architecture", "Robert Martin", "2017", new BigDecimal("50")),
	TEST_DRIVEN_DEVELOPMENT("200007", "Test Driven Development by Example", "Kent Beck", "2003", new BigDecimal("50")),
	LEGACY_CODE("321234", "Working Effectively With Legacy Code", "Michael C. Feathers", "2004", new BigDecimal("50"));

	final String serialNumber;
	final String title;
	final String authorName;
	final String yearOfPublish;
	final BigDecimal price;

	Book(String serialNumber, String title, String authorName, String yearOfPublish, BigDecimal price) {
		this.serialNumber = serialNumber;
		this.title = title;
		this.authorName = authorName;
		this.yearOfPublish = yearOfPublish;
		this.price = price;
	}

	public String getSerialNumber() {
		return serialNumber;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthorName() {
		return authorName;
	}

	public String getYearOfPublish() {
		return yearOfPublish;
	}

	public BigDecimal getPrice() {
		return price;
	}

	private static final Map<String, Book> bookMap = Collections
			.unmodifiableMap(Stream.of(Book.values()).collect(Collectors.toMap(Book::getSerialNumber, book -> book)));

	public static Book searchBySerialNo(String serialNumber) {
		Book book = bookMap.get(serialNumber);
		if (null == book)
			throw new SNNotFoundException("There is no book present with Serial number: " + serialNumber);
		return book;
	}
}
