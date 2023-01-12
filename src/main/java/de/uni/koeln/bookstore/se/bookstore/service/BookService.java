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

	public List<Book> getOldestNewestBook() {

		List<Book> books = new ArrayList<Book>();
		books = bookRepo.findAll();

		if (books.size() == 0) {
			return books;
		} else {

			int runner = books.size() - 1;
			Book OldestBook = books.get(runner);

			for (int i = 0; i < books.size(); i++) {
				if (OldestBook.getPublishYear() > books.get(i).getPublishYear()) {
					OldestBook = books.get(i);
				}
			}

			List<Book> bookss = new ArrayList<>();
			bookss.add(OldestBook);
			bookss.add(books.get(runner));

			return bookss;
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
