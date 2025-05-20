package com.store.book.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.store.book.controller.model.BookInfo;
import com.store.book.service.model.Book;

@Mapper(componentModel = "spring")
public interface ResponseObjectMapper {

	@Mapping(source = "serialNumber", target = "serialNumber")
	@Mapping(source = "title", target = "title")
	@Mapping(source = "authorName", target = "authorName")
	@Mapping(source = "yearOfPublish", target = "yearOfPublish")
	@Mapping(source = "price", target = "price")
	BookInfo toBookInfo(Book book);

	List<BookInfo> toBookInfoResponse(List<Book> books);

}
