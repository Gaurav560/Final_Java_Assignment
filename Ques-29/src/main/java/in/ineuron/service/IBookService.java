package in.ineuron.service;


import in.ineuron.model.Book;

public interface IBookService {


	public Iterable<Book> fetchDetails(boolean asc, String... properties);

	public Iterable<Book> fetchDetailsByPageNo(int pageNo, int pageSize, boolean asc, String... properties);

	//public void fetchDetailsByPagination(int pageSize);
 
}
