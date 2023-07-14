package in.ineuron.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Book;
import in.ineuron.service.BookServiceImpl;

@RestController
@RequestMapping("/book")
public class bookController {

	@Autowired
	private BookServiceImpl service;

	@GetMapping("/sorting") // SORTING AND FILTERING
	public ResponseEntity<Iterable<Book>> displaySortedDetails() {

		Iterable<Book> books = service.fetchDetails(true, "year", "title", "Author");

		return new ResponseEntity<Iterable<Book>>(books, HttpStatus.OK);

	}

	@GetMapping("/paging") // PAGINATION
	public ResponseEntity<Iterable<Book>> displayPagingDetails() {

		Iterable<Book> books = service.fetchDetailsByPageNo(0, 3, true, "year", "title");

		return new ResponseEntity<Iterable<Book>>(books, HttpStatus.OK);

	}

}
