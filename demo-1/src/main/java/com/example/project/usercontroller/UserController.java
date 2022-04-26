package com.example.project.usercontroller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.project.userdomain.User;
import com.example.project.userservice.UserService;
import com.example.project.userdomain.Book;
import com.example.project.userservice.BookService;

@Controller
public class UserController {
	
	//@Autowired
	//BCryptPasswordEncoder pwEncoder;
	
	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;
	
	@GetMapping(value="/")
	public String login(Model model) {
		model.addAttribute("newuser", new User());
		return "page";
	}
	
	@RequestMapping("/add/{id}")
	public String add(@PathVariable(name="id") int id,Model model) {
		User curruser = userService.findById(id);
		model.addAttribute("user",curruser);
		model.addAttribute("newbook", new Book());
		return "addbook";
	}
	
	@RequestMapping("/home/{id}")
	public String home(@PathVariable(name="id") int id,Model model) {
		User curruser = userService.findById(id);
		model.addAttribute("user",curruser);
		List<Book> books = bookService.findAll();
		model.addAttribute("books",books);
		return "homepg";
	}
	
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String register(@ModelAttribute("newuser") User user,Model model) {
		userService.save(user);
		model.addAttribute("user",user);
		return "info";
	}
	
	@RequestMapping(value="/saveBook/{id}", method=RequestMethod.POST)
	public String register(@ModelAttribute("newbook") Book book,@PathVariable(name="id") int id,Model model) {
		bookService.save(book);
		User curruser = userService.findById(id);
		model.addAttribute("user",curruser);
		bookService.add(book,curruser);
		model.addAttribute("newbook",new Book());
		return "addbook";
	}
	
	@RequestMapping(value="/borrowbk/{id}/{bookid}", method=RequestMethod.POST)
	public String borrow(@ModelAttribute("dummy") Book book,@PathVariable(name="id") int id,@PathVariable(name="bookid") int bookid,Model model) {
		User curruser = userService.findById(id);
		Book currbook =bookService.findById(bookid);
		bookService.saveBookOrder(currbook, book.start, book.end, curruser);
		model.addAttribute("user",curruser);
		return "info";
	}
	@RequestMapping("/books/{id}")
	public String mybooks(@PathVariable(name="id") int id,Model model) {
		User curruser = userService.findById(id);
		model.addAttribute("user",curruser);
		List<Book> books = bookService.findmybooks(curruser);
		model.addAttribute("books",books);
		return "bookspg";
	}
	
	@RequestMapping("/borrowed/{id}")
	public String borrowed(@PathVariable(name="id") int id,Model model) {
		User curruser = userService.findById(id);
		model.addAttribute("user",curruser);
		List<Book> books = bookService.findborrowedbooks(curruser);
		model.addAttribute("books",books);
		return "borrowed";
	}
	
	@RequestMapping(value="/delBook/{id}/{bookid}",method=RequestMethod.GET)
	public String delbook(@PathVariable(name="id") int id,@PathVariable(name="bookid") int bookid,Model model) {
		User curruser = userService.findById(id);
		model.addAttribute("user",curruser);
		bookService.deleteById(bookid);
		return "info";
	}
	
	@RequestMapping(value="/retBook/{id}/{bookid}",method=RequestMethod.GET)
	public String retbook(@PathVariable(name="id") int id,@PathVariable(name="bookid") int bookid,Model model) {
		User curruser = userService.findById(id);
		Book book = bookService.findById(bookid);
		model.addAttribute("user",curruser);
		bookService.retbook(book);
		return "info";
	}
	
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String enter(@ModelAttribute("newuser") User us,Model model) {
		User user = userService.getUser(us.getEmail(),us.getUserpassword());
		model.addAttribute("user",user);
		List<Book> books = bookService.findAll();
		model.addAttribute("books",books);
	     if(Objects.nonNull(user))
	     {
	  
	     return "homepg";
	    
	    
	     } else {
	     return "page";
	     }
		
	}
	@RequestMapping("/logout")
	public String back(Model model) {
		model.addAttribute("newuser", new User());
		return "page";
	}
	@RequestMapping("/request/{id}/{bookid}")
	public String req(@PathVariable(name="id") int id,@PathVariable(name="bookid") int bookid,Model model) {
		User curruser = userService.findById(id);
		Book currbook = bookService.findById(bookid);
		model.addAttribute("user",curruser);
		model.addAttribute("currbook", currbook);
		model.addAttribute("dummy",new Book());
		return "reqbook";
	}
	@RequestMapping("/profile/{id}")
	public String profile(@PathVariable(name="id") int id,Model model) {
		User curruser = userService.findById(id);
		model.addAttribute("user",curruser);
		if(Objects.nonNull(curruser))
	     {
	  
	        return "pr";
	    
	    
	     } else {
	     return "page";
	     }
	}
	
	/*@RequestMapping(value="/save", method=RequestMethod.POST)
	public String saveNewAccount(User user) {
		user.setUserPassword(user.getUserPassword());
		userService.save(user);
		return "info";
	}*/
}