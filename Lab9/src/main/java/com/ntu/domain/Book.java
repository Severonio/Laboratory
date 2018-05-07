package com.ntu.domain;

public class Book  {
	
	//����
	 private long id;
	 //����� ���� ���������� � ������� ������� ������� book � dbntu
	 private String title;// ����� �����   
	 private String author;// ����� ��� ������� ������ 
	 private int printYear;// �� �������     
	 private int countOfPages;//������� �������  
	 
	//����������� 1  
	public Book() {
		super();
	}
	//����������� 2
	public Book(String title, String author, int printYear, int countOfPages) {
		super();
		this.title = title;
		this.author = author;
		this.printYear = printYear;
		this.countOfPages = countOfPages;
	}
	//����������� 3  
	public Book(long id, String title, String author, int printYear, int countOfPages) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.printYear = printYear;
		this.countOfPages = countOfPages;
	}
	
	//������� �� �������	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrintYear() {
		return printYear;
	}
	public void setPrintYear(int printYear) {
		this.printYear = printYear;
	}
	public int getCountOfPages() {
		return countOfPages;
	}
	public void setCountOfPages(int countOfPages) {
		this.countOfPages = countOfPages;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", printYear=" + printYear
				+ ", countOfPages=" + countOfPages + "]";
	}
	

	
	

	
}
