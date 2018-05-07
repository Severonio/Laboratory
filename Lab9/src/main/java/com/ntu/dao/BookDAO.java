package com.ntu.dao;

import java.util.List;

import com.ntu.domain.Book;

public interface BookDAO {	
	
    Book getBookById(long id);
    List<Book> getBookByTitleAndAuthor(String title, String author);
    List<Book> getAllBooks();
    boolean insertBook(Book book);
    boolean updateBook(Book book);
    boolean deleteBook(long id);

}
