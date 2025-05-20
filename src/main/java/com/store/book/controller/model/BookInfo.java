package com.store.book.controller.model;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "Book information model")
public class BookInfo {

	@Schema(example = "12345", description = "Unique Serial number of the book")
	private String serialNumber;

	@Schema(example = "Book Title", description = "Title of the book")
	private String title;

	@Schema(example = "Author Name", description = "Name of the author")
	private String authorName;

	@Schema(example = "1789", description = "Year of publication")
	private String yearOfPublish;

	@Schema(example = "150.00", description = "Price of the book")
	private BigDecimal price;

}
