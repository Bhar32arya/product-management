package com.bhar32.spring.data.cassandra.repository;

import java.util.List;
import java.util.UUID;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import com.bhar32.spring.data.cassandra.model.ProductDTO;

public interface ProductRepository extends CassandraRepository<ProductDTO, UUID> {
	
		  @AllowFiltering
		  List<ProductDTO> findByPublished(boolean published);
		  
		  List<ProductDTO> findByTitleContaining(String title);

}
