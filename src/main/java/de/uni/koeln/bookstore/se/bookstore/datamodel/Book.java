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
	@Column
	private Integer price;

	public Book() {
	}

	public Book(String name, String author, Integer publishYear, Integer price) {

		this.name = name;
		this.author = author;
		this.publishYear = publishYear;
		this.price = price;
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

	public synchronized Integer getPrice() {
		return price;
	}

	public synchronized void setPrice(Integer price) {
		this.price = price;
	}

}
