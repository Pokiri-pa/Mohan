package syntel.mohan.io.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import syntel.mohan.io.model.Book;
import syntel.mohan.io.service.BookService;

@RestController
public class BookController {
	@SuppressWarnings({ "unused" })
	@Autowired
	private BookService bookService;
	@RequestMapping("/books")
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	@RequestMapping("/books/{id}")
	public Book getOneBook(@PathVariable String id) {
		return bookService.getOneBook(id);
			}
	@RequestMapping(method = RequestMethod.POST, value="/books")
	public void addBook(@RequestBody Book book) {
		bookService.addBook(book);
	}
	@RequestMapping(method = RequestMethod.PUT, value="/books/{id}")
	public void updateBook(@RequestBody Book book,@PathVariable String id) {
		bookService.updateBook(book,id);
	}
	@RequestMapping(method = RequestMethod.DELETE, value="/books/{id}")
	public void deleteBook(@PathVariable String id) {
		bookService.deleteBook(id);
	}

}
