package in.ineuron.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ineuron.dao.ProductRepo;
import in.ineuron.exception.ProductRecordNotFoundException;
import in.ineuron.model.Product;

@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private ProductRepo repo;

	 

	@Override
	public List<Product> fetchAllProduct() {

		return repo.findAll();
	}

	 
}
