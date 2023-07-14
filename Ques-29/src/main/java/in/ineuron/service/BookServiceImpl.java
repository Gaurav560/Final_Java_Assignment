package in.ineuron.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import in.ineuron.dao.BookRepo;
import in.ineuron.model.Book;

@Service
public class BookServiceImpl implements IBookService {

	@Autowired
	private BookRepo repo;

	@Override
	public Iterable<Book> fetchDetails(boolean asc, String... properties) {

		System.out.println("Proxy class implementation name is :: " + repo.getClass().getName());
		Sort sort = Sort.by(asc ? Direction.ASC : Direction.DESC, properties);
		Iterable<Book> listEntities = repo.findAll(sort);
		return listEntities;
		
	}

	
	  @Override 
	  public Iterable<Book> fetchDetailsByPageNo(int pageNo, int pageSize, boolean asc, String... properties) {
	  
	  Pageable pageable = PageRequest.of(pageNo, pageSize, asc ? Direction.ASC :Direction.DESC, properties);
	  Page<Book> page = repo.findAll(pageable); return
	  page.getContent(); }
	 

	 
}
