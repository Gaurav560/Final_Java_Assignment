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
	public String saveDetails(Product product) {

		Product msg = repo.save(product);

		return "Products details are saved successfully with id " + msg.getId();
	}

	@Override
	public List<Product> fetchAllProduct() {

		return repo.findAll();
	}

	@Override
	public Product fetchProductById(Integer id) {

		Product product = repo.findById(id)
				.orElseThrow(() -> new ProductRecordNotFoundException("Product information not found"));
		return product;
	}

	@Override
	public String updateProductByDetails(Product product) {

		Optional<Product> optional = repo.findById(product.getId());
		if (optional.isPresent()) {
			repo.save(product); // save() performs both insert and update depends on id value
			return "Product with the id :: " + product.getId() + " updated";
		} else {
			throw new ProductRecordNotFoundException(
					"product with the id:: " + product.getId() + " not available for updation");
		}
	}

	@Override
	public String deleteProductById(Integer id) {
		Optional<Product> optional = repo.findById(id);
		if (optional.isPresent()) {
			repo.delete(optional.get());
			return "Product with the id :: " + id + " deleted...";
		} else {
			throw new ProductRecordNotFoundException("Product not found for the id " + id);
		}
	}

}
