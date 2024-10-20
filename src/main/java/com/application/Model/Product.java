package com.application.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long BookId;
	private String BookName;
	private String ReleaseDate;
	private long Price;
	private String AuthorName;
	@ManyToOne()
	@JoinColumn(name = "categories_id", nullable = false)
	private Categories categories;
	
	public Product(String bookName, String releaseDate, long price, String authorName, Categories categories) {
		BookName = bookName;
		ReleaseDate = releaseDate;
		Price = price;
		AuthorName = authorName;
		this.categories = categories;
	}
	public Product() {

	}

	public long getBookId() {
		return BookId;
	}
	public void setBookId(long bookId) {
		BookId = bookId;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		BookName = bookName;
	}
	public String getReleaseDate() {
		return ReleaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		ReleaseDate = releaseDate;
	}
	public long getPrice() {
		return Price;
	}
	public void setPrice(long price) {
		Price = price;
	}
	public String getAuthorName() {
		return AuthorName;
	}
	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}

	@Override
	public String toString() {
		return "Product [BookId=" + BookId + ", BookName=" + BookName + ", ReleaseDate=" + ReleaseDate + ", Price="
				+ Price + ", AuthorName=" + AuthorName + ", categories=" + categories + "]";
	}
}
