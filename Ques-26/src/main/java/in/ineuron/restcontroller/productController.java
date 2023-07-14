package in.ineuron.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ineuron.model.Product;
import in.ineuron.service.ProductServiceImpl;

@RestController
@RequestMapping("/product")
public class productController {

	@Autowired
	private ProductServiceImpl service;

	@PostMapping("/save")
	public ResponseEntity<String> registerDetails(@RequestBody Product product) {
		String body = service.saveDetails(product);
		return new ResponseEntity<String>(body, HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> displayProductDetails() {

		List<Product> products  = service.fetchAllProduct();
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<?> displayProductById(@PathVariable("id") Integer id) {
		Product product= service.fetchProductById(id);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@PutMapping("/modify")
	public ResponseEntity<String> modifyStudent(@RequestBody Product product) {
		String msg = service.updateProductByDetails(product);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> removeStudentById(@PathVariable("id") Integer id) {

		String msg =service.deleteProductById(id);
		return new ResponseEntity<String>(msg, HttpStatus.OK);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
