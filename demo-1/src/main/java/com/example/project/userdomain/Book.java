package com.example.project.userdomain;
import java.time.LocalDate; 
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Book {
@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public long bookid;

	public String title;
	public String author;
	public int releaseyear;
	public int edition;
	public String publisher;
	public String addedby=null;
	public String currentuser;
	public String start;
	public String end;
	public int timesextended = 0;
	public boolean readyforpickup = false;
public Book() {
		
	}

	public Book(String title, String author, int edition,int releaseyear,String publisher) {
		super();
		this.title = title;
		this.author = author;
		this.releaseyear = releaseyear;
		this.edition = edition;
		this.publisher = publisher;
	}

	public long getBookid() {
		return bookid;
	}

	public void setBookid(long bookid) {
		this.bookid = bookid;
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

	public int getReleaseyear() {
		return releaseyear;
	}

	public void setReleaseyear(int releaseyear) {
		this.releaseyear = releaseyear;
	}

	public int getEdition() {
		return edition;
	}

	public void setEdition(int edition) {
		this.edition = edition;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getAddedby() {
		return addedby;
	}

	public void setAddedby(String addedby) {
		this.addedby = addedby;
	}

	public String getCurrentuser() {
		return currentuser;
	}

	public void setCurrentuser(String currentuser) {
		this.currentuser = currentuser;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public int getTimesextended() {
		return timesextended;
	}

	public void setTimesextended(int timesextended) {
		this.timesextended = timesextended;
	}

	public boolean isReadyforpickup() {
		return readyforpickup;
	}

	public void setReadyforpickup(boolean readyforpickup) {
		this.readyforpickup = readyforpickup;
	}
	
}
