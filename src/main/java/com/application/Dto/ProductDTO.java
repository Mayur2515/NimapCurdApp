package com.application.Dto;

public class ProductDTO {
	private String BookName;
	private String ReleaseDate;
	private long Price;
	private String AuthorName;
	private long CategoriesId;
	
	public long getCategoriesId() {
		return CategoriesId;
	}
	public void setCategoriesId(long categoriesId) {
		CategoriesId = categoriesId;
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
		return "ProductDTO [BookName=" + BookName + ", ReleaseDate=" + ReleaseDate + ", Price=" + Price
				+ ", AuthorName=" + AuthorName + ", CategoriesId=" + CategoriesId + "]";
	}
}
