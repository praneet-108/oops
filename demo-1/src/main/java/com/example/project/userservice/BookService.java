package com.example.project.userservice;


import java.sql.Date;
import java.time.LocalDate; 
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.userrepository.BookRepository;
import com.example.project.userrepository.UserRepository;
import com.example.project.userdomain.Book;
import com.example.project.userdomain.User;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	UserRepository usRepo;
	
	public void save(Book book) {
		bookRepo.save(book);
	}
	
	public void saveById(Long bookid) {
		bookRepo.save(bookRepo.findById(bookid).get());
	}
	
	public List<Book> findAll(){
		return (List<Book>) bookRepo.findAll();
	}
	
	public Book findById(long bookid) {
		Book book = bookRepo.findById(bookid).get();
		return book;
	}
	
	public List<Book> searchBooks(String title, String author){
		
		List<Book> searchedBooks = new ArrayList<Book>();
		
		if (title != null && author == null) {
			searchedBooks = getByTitle(title);
		} else if (title == null && author != null) {
			searchedBooks = getByAuthor(author);
		} else if (title != null && author != null) {
			searchedBooks = getByTitleAndAuthor(title, author);
		} 
		
		return searchedBooks;
	}
	
	public List<Book> getByTitle(String title){
		List<Book> books = new ArrayList<>();
		for (Book book : bookRepo.findAll()) {
			if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
				books.add(book);
			}
		}
		return books;
	}
	
	public List<Book> getByAuthor(String author){
		List<Book> books = new ArrayList<>();
		for (Book book : bookRepo.findAll()) {
			if (book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
				books.add(book);
			}
		}	
		return books;
	}
	
	public List<Book> getByTitleAndAuthor(String title, String author){
		List<Book> books = new ArrayList<>();
		for (Book book : bookRepo.findAll()) {
			if (book.getTitle().toLowerCase().contains(title.toLowerCase()) &&
				book.getAuthor().toLowerCase().contains(author.toLowerCase())) {
				books.add(book);
			}
		}
		return books;
	}
	
	public void deleteById(long bookId) {
		bookRepo.deleteById(bookId);
	}
	
	/*public List<Book> getUnprocessedBookReservations(){
		List<Book> unprocessedBookReservations = new ArrayList<Book>();
		for (Book book : bookRepo.findAll()) {
			if (book.getReservedbyuser() != null && book.getReadyForPickUp() == false) {
				unprocessedBookReservations.add(book);
			}
		}
		return unprocessedBookReservations;
	}
	
	public List<Book> getProcessedBookReservations(){
		List<Book> processedBookReservations = new ArrayList<Book>();
		for (Book book : bookRepo.findAll()) {
			if (book.getReservedbyuser() != null && book.getReadyForPickUp() == true) { 
				processedBookReservations.add(book);
			}
		}
		return processedBookReservations;
	}
	*/
	public List<Book> convertIdsCollectionToBooksList(Collection<Long> bookIds){
		List<Book> books = new ArrayList<Book>();
		for (Long bookId : bookIds) books.add(bookRepo.findById(bookId).get());
		return books;
	}
	
	/*public void removeCurrentUserOfMultipleBooks(List<Book> books) {
		for (Book book : books) removeCurrentUserOfBook(book);
	}*/
	
	/*public void removeCurrentUserOfBook(Book book) {
		User currentUser = book.getTheUser();
		for (int i = 0; i < currentUser.getBooks().size(); i++) {
			if (currentUser.getBooks().get(i).getBookId() == book.getBookId()) {
				currentUser.getBooks().remove(i);
				break;
			}
		}
		usRepo.save(currentUser);
		book.setTheUser(null);
		book.setTimesExtended(0);
		bookRepo.save(book);
	}
	
	public void removeReservation(Book book) {
		User reservedbyuser = book.getReservedByUser();
		for (int i = 0; i < reservedbyuser.getReservedBooks().size(); i++) {
			if (reservedbyuser.getReservedBooks().get(i).getBookId() == book.getBookId()) {
				reservedbyuser.getReservedBooks().remove(i);
				break;
			}
		}
		usRepo.save(reservedbyuser);
		book.setStartReservationDate(null);
		book.setEndReservationDate(null);
		book.setReadyForPickup(false);
		bookRepo.save(book);
	}*/
	 public void saveBookOrder(Book book,String s,String e,User user)
	 {
		 book.setStart(s);
		 book.setEnd(e);
		 book.setCurrentuser(user.name);
		 bookRepo.save(book);
	 }
	

	public void add(Book book, User curruser) {
		// TODO Auto-generated method stub
		book.setAddedby(curruser.name);
		bookRepo.save(book);
	}

	public List<Book> findmybooks(User curruser) {
		// TODO Auto-generated method stub
		List<Book> books = new ArrayList<>();
		for (Book book : bookRepo.findAll()) {
			if (book.getAddedby().toLowerCase().contains(curruser.getName().toLowerCase())) {
				books.add(book);
			}
		}
		return books;
	}

	public List<Book> findborrowedbooks(User curruser) {
		// TODO Auto-generated method stub
		List<Book> books = new ArrayList<>();
		for (Book book : bookRepo.findAll()) {
			if (book.getCurrentuser().toLowerCase().contains(curruser.getName().toLowerCase())) {
				books.add(book);
			}
		}
		return books;
	}

	public void retbook(Book book) {
		
		book.setCurrentuser(null);
		book.setEnd(null);
		book.setStart(null);
		bookRepo.save(book);
		// TODO Auto-generated method stub
		
	}
}
