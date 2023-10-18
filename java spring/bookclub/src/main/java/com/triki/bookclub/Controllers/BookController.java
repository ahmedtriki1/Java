package com.triki.bookclub.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.souha.bookclub.Models.Book;
import com.souha.bookclub.Models.User;
import com.souha.bookclub.Services.BookService;
import com.souha.bookclub.Services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookServ;
	
	@Autowired
	private UserService UserServ;
	
	// DISPLAY ROUTE - READ ALL
	@GetMapping("/books")
	public String home(Model m, HttpSession session) {
		// grab the user id from session
		 Long userId = (Long) session.getAttribute("user_id");
		 // ROUTE GUARD
		 if(userId == null) {
			 return "redirect:/login";
		 }else {
			// save the book
				//1. grab the current user's ID from Session
				Long userID = (Long) session.getAttribute("user_id");
				//2. fetch the user from the DB
				User currentUser  = UserServ.findOne(userID);
			   m.addAttribute("user" ,currentUser);
		 
		List<Book> allTheBooks = bookServ.allBooks();
		
		m.addAttribute("booksList", allTheBooks);
		return "home.jsp";
		}
	}
	
	// DISPLAY ROUTE - FORM
	@GetMapping("/books/new")
	public String create(@ModelAttribute("book") Book book) {
		
		return "create.jsp";
	}
	
	// ACTION ROUTE - Process Form
	@PostMapping("/books")
	public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result
						,HttpSession session) {
		
		if (result.hasErrors()) {
	
			return "create.jsp";
		} else {
		
			// save the book
			//1. grab the current user's ID from Session
			Long userID = (Long) session.getAttribute("user_id");
			//2. fetch the user from the DB
			User currentUser  = UserServ.findOne(userID);
			System.out.println(currentUser);
			//3. setAuthor to be the the current user
			book.setBooklover(currentUser);
			Book newBook = bookServ.createBook(book);

		return "redirect:/books";
		}
		
	}
	
	
	
//	
	// Display Route - show
	@GetMapping("book/{id}")
	public String ShowPage(@PathVariable("id") Long id, Model model, HttpSession session) {
		
		// save the book
		//1. grab the current user's ID from Session
		Long userID = (Long) session.getAttribute("user_id");
		//2. fetch the user from the DB
		User currentUser  = UserServ.findOne(userID);
		model.addAttribute("user",currentUser);
	

		// find that book with provided id
		Book thisBook = bookServ.findBook(id);
		model.addAttribute("book",thisBook)	;
		return "show.jsp";
		
	}
	
	
	
	
	// Display Route - Edit form
		@GetMapping("books/{id}/edit")
		public String editPage(@PathVariable("id") Long id, Model model, HttpSession session) {
			
			// Grab current user's id and compare it to the book's author id
			Long userID = (Long) session.getAttribute("user_id");
			// find that book with provided id
			Book thisBook = bookServ.findBook(id);
			// grab the the author's id from thisBook
			Long authorID = thisBook.getBooklover().getId();
	
	
			if(userID.equals(authorID)) {
				model.addAttribute("book",thisBook);
				return "edit.jsp";
			}else {
	
			return "redirect:/books";
			
			
			}
		}
		
		// ACTION ROUTE - EDIT
		@PutMapping("/books/{id}/edit")
		public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult result,
								HttpSession session,
								@PathVariable("id") Long bookID) {
			if (result.hasErrors()) {
				return "edit.jsp";
			} else {
				
				// ======== Fetch the old Author =========
				//1. grab the current user's ID from Session
				Long userID = (Long) session.getAttribute("user_id");
				//2. fetch the user from the DB
				User currentUser  = UserServ.findOne(userID);
				//3. setAuthor to be the the current user
				book.setBooklover(currentUser);
				
				// grab the book from DB
				Book thisBook = bookServ.findBook(bookID);
			
			
				// // if there are no errors update book
				bookServ.updateBook(book);
				return "redirect:/books";
			}
		}
	// DELETE
	
	@DeleteMapping("/books/{id}")
	public String delete(@PathVariable("id") Long id) {
		bookServ.deleteBook(id);
		return "redirect:/books";
	}
	
	


	
	
}
