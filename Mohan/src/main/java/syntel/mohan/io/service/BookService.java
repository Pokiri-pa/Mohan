package syntel.mohan.io.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import syntel.mohan.io.model.Book;

@Service
public class BookService {
	private List<Book> books=new ArrayList<>(Arrays.asList(new Book("first","Anna Karenina", "Written by Russian novelist Leo Tolstoy"),
			new Book("second","To Kill a Mockingbird", "Written by Harper Lee"),
			new Book("third","The Great Gatsby", "Written by F. Scott Fitzgerald")));

	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return books;
	}

	public Book getOneBook(String id) {
		// TODO Auto-generated method stub
		/*
		 * for(int i=0;i<=books.size();i++) { Book b=books.get(i);
		 * if(b.getBookId().equals(id)) { return b; } }
		 */
		return books.stream().filter(b->b.getBookId().equals(id)).findFirst().get();
	}

	public void addBook(Book book) {
		// TODO Auto-generated method stub
		books.add(book);
	}

	public void updateBook(Book book, String id) {
		// TODO Auto-generated method stub
		for(int i=0;i<=books.size();i++) { Book b=books.get(i);
		  if(b.getBookId().equals(id)) {
			  books.set(i, book);
			  return; } }
	}

	public void deleteBook(String id) {
		// TODO Auto-generated method stub
		books.removeIf(b->b.getBookId().equals(id));
	}

}
