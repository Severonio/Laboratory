package com.ntu.domain;

import java.io.Serializable;
import java.sql.Date;
/*������ ��������� ������-���������� ����*/
@SuppressWarnings("LossyEncoding")
public class BookRegister implements Serializable {
	private static final long serialVersionUID = 1L;
	//����
		 private long id;
		 //����� ���� ���������� � ������� ������� ������� personReader � dbntu
		 private Book book;  
		 private Date vydanoDt; //yyyy-mm-dd
		 private PersonReader personReader;  
		 private Date povernenoDt; //yyyy-mm-dd
		
		 
		//����������� 1   
		public BookRegister() {
			super();		
		}

		//����������� 2
		public BookRegister(Book book, Date vydanoDt, PersonReader personReader, Date povernenoDt) {
			super();
			this.book = book;
			this.vydanoDt = vydanoDt;
			this.personReader = personReader;
			this.povernenoDt = povernenoDt;
		}
		//����������� 3
		public BookRegister(long id, Book book, Date vydanoDt, PersonReader personReader, Date povernenoDt) {
			super();
			this.id = id;
			this.book = book;
			this.vydanoDt = vydanoDt;
			this.personReader = personReader;
			this.povernenoDt = povernenoDt;
		}
		
		//����������� 4
	public BookRegister(Book book, Date vydanoDt, PersonReader personReader) {
					super();
					this.book = book;
					this.vydanoDt = vydanoDt;
					this.personReader = personReader;
				}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public Book getBook() {
			return book;
		}

		public void setBook(Book book) {
			this.book = book;
		}

		public Date getVydanoDt() {
			return vydanoDt;
		}

		public void setVydanoDt(Date vydanoDt) {
			this.vydanoDt = vydanoDt;
		}

		public PersonReader getPersonReader() {
			return personReader;
		}

		public void setPersonReader(PersonReader personReader) {
			this.personReader = personReader;
		}

		public Date getPovernenoDt() {
			return povernenoDt;
		}

		public void setPovernenoDt(Date povernenoDt) {
			this.povernenoDt = povernenoDt;
		}

		@Override
		public String toString() {
			return "BookRegister [id=" + id + ", book=" + book.getId() + " - " + book.getTitle()+ " - " + book.getAuthor() + ", vydanoDt=" + vydanoDt + ", personReader="
					+ personReader.getId() + " - " + personReader.getFirstName() + " - " + personReader.getLastName()+ " - " + personReader.getPhone() + ", povernenoDt=" + povernenoDt + "]";
		}
		
		
		

}
