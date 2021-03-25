package com.bhar32.spring.data.cassandra.controller;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bhar32.spring.data.cassandra.exception.ResourceNotFoundException;
import com.bhar32.spring.data.cassandra.model.ProductDTO;
import com.bhar32.spring.data.cassandra.service.ProductService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@DeleteMapping("/product/{id}")
	  public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") UUID id) {
	    try {
	    	productService.deleteProductById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }

	@PutMapping("/product/{id}")
	public ResponseEntity<ProductDTO> updateProduct(@PathVariable("id") UUID id, @RequestBody ProductDTO product) {
		Optional<ProductDTO> _productData = productService.updateProductById(id, product);
		if (_productData.isPresent()) {
			return new ResponseEntity<>(_productData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/product/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable("id") UUID id) {
		Optional<ProductDTO> productData = productService.findById(id);

		if (productData.isPresent()) {
			return new ResponseEntity<>(productData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/deleteProducts")
	public ResponseEntity<HttpStatus> deleteAllProducts() {
		try {
			productService.deleteAllProducts();
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			throw new ResourceNotFoundException("encounter exception while deleting the product deleteAllProducts()");
		}
	}

	@PostMapping("/product")
	public ResponseEntity<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {
		try {
			ProductDTO _productDTO = productService.addProduct(productDTO);
			return new ResponseEntity<>(_productDTO, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
