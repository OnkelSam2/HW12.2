package de.uni.koeln.bookstore.se.bookstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.uni.koeln.bookstore.se.bookstore.datamodel.Book;
import de.uni.koeln.bookstore.se.bookstore.repository.BookRepo;

@Service
public class BookService {

	@Autowired
	private BookRepo bookRepo;

	public List<Book> findBooks() {

		return bookRepo.findAll();
	}

	public Book getOldestBook() {

		List<Book> books = bookRepo.findAll();

		Book book = new Book();

		if (books.isEmpty()) {
			return book;
		} else {

			int runner = books.size() - 1;
			book = books.get(runner);

			for (int i = 0; i < books.size(); i++) {
				if (book.getPublishYear() > books.get(i).getPublishYear()) {
					book = books.get(i);
				}
			}
			return book;
		}
	}
	
	public Book getNewestBook() {
		
		List<Book> books = bookRepo.findAll();
		
		if(books.isEmpty()) {
			return null;
		}else {
			return books.get(books.size() -1 );
		}
	
	}

	public Optional<Book> fetchBook(int id) {

		return bookRepo.findById(id);
	}

	public Book addBook(Book book) {

		return bookRepo.save(book);
	}

	public boolean deleteBook(int id) {

		boolean status;
		try {
			bookRepo.deleteById(id);
			status = true;
		} catch (Exception e) {
			status = false;
		}
		return status;
	}
}
