package in.ineuron.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ineuron.model.Product;

public interface ProductRepo extends JpaRepository <Product, Integer> {

}
