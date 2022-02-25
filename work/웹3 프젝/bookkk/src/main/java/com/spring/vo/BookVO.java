package com.spring.vo;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
public class BookVO{

/*
CREATE TABLE book (
   bookNum int NOT NULL,
   subject VARCHAR2(30) NOT NULL,
   author VARCHAR2(30) NOT NULL,
   publishDate date NULL,
   publisher VARCHAR2(30) NULL,
   price int NOT NULL,
   intro clob NULL,
   stock int NOT NULL,
   img VARCHAR2(100) NULL,
   categoryNum int NOT NULL,
   FOREIGN KEY (categoryNum) REFERENCES category (categoryNum),
   primary key(bookNum)
);

	*/
	
	private int bookNum;
	private String subject;
	private String author;
	private Date publishDate;
	private String publisher;
	private int price;
	private String intro;
	private String img;
	private int stock;
	
	
	
	private int tier;
	private String cateName;
	private int categoryNum;
	private int cateParent;
	
	
	
	public int getTier() {
		return tier;
	}
	public void setTier(int tier) {
		this.tier = tier;
	}
	public int getBookNum() {
		return bookNum;
	}
	public void setBookNum(int bookNum) {
		this.bookNum = bookNum;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getCateName() {
		return cateName;
	}
	public void setCateName(String cateName) {
		this.cateName = cateName;
	}
	public int getCategoryNum() {
		return categoryNum;
	}
	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}
	public int getCateParent() {
		return cateParent;
	}
	public void setCateParent(int cateParent) {
		this.cateParent = cateParent;
	}

	
	
	
	
	
	
	
	
	
	
}
