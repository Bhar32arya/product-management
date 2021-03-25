package com.bhar32.spring.data.cassandra.service;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bhar32.spring.data.cassandra.model.ProductDTO;
import com.bhar32.spring.data.cassandra.repository.ProductRepository;
import com.datastax.driver.core.utils.UUIDs;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public ProductDTO addProduct(ProductDTO productDTO) {
		productRepository
				.save(new ProductDTO(UUIDs.timeBased(), productDTO.getTitle(), productDTO.getDescription(), productDTO.isPublished()));
		return productDTO;
	}

	public void deleteAllProducts() {
		productRepository.deleteAll();
	}

	public Optional<ProductDTO> findById(UUID id) {
		return productRepository.findById(id);
	}

	public Optional<ProductDTO> updateProductById(UUID id, ProductDTO productDTO) {
		Optional<ProductDTO> productData = productRepository.findById(id);
		if (productData.isPresent()) {
			ProductDTO _productData = productData.get();
			_productData.setTitle(productDTO.getTitle());
			_productData.setDescription(productDTO.getDescription());
			_productData.setPublished(productDTO.isPublished());
			productRepository.save(_productData);
			return Optional.ofNullable(_productData);
		}
		return null;
	}

	public void deleteProductById(UUID id) {
		productRepository.deleteById(id);
	}

}
