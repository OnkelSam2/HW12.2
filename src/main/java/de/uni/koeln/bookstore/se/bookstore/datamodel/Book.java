package de.uni.koeln.bookstore.se.bookstore.datamodel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Book")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String name;
	@Column
	private String author;
	@Column
	private Integer publishYear;

	public Book() {
	}

	public Book(String name, String author, Integer publishYear) {

		this.name = name;
		this.author = author;
		this.publishYear = publishYear;
	}

	public synchronized Integer getId() {
		return id;
	}

	public synchronized void setId(Integer id) {
		this.id = id;
	}

	public synchronized String getName() {
		return name;
	}

	public synchronized void setName(String name) {
		this.name = name;
	}

	public synchronized String getAuthor() {
		return author;
	}

	public synchronized void setAuthor(String author) {
		this.author = author;
	}

	public synchronized Integer getPublishYear() {
		return publishYear;
	}

	public synchronized void setPublishYear(Integer publishYear) {
		this.publishYear = publishYear;
	}

}
