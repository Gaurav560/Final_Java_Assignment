package in.ineuron.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.Book;

public interface BookRepo extends JpaRepository<Book, Long> {

	 

}
