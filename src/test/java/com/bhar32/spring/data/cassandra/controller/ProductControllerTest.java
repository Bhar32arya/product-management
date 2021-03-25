package com.bhar32.spring.data.cassandra.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import com.bhar32.spring.data.cassandra.repository.ProductRepository;
import com.bhar32.spring.data.cassandra.service.ProductService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class)
class ProductControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	ProductService productService;
	
	@Test
	void testDeleteProduct() {
		fail("Not yet implemented");
	}

	@Test
	void testUpdateProduct() {
		fail("Not yet implemented");
	}

	/*
	 * @Test void testGetProductById() { UUID id = UUID.randomUUID(); String data =
	 * "{\r\n" + "    \"id\": \"b121e860-8c6f-11eb-9e88-c3a0a6c381c2\",\r\n" +
	 * "    \"title\": \"pen\",\r\n" +
	 * "    \"description\": \"write on paper\",\r\n" +
	 * "    \"published\": true\r\n" + "}";
	 * Mockito.when(productService.findById(id)).thenReturn(data); }
	 */

	@Test
	void testDeleteAllProducts() {
		fail("Not yet implemented");
	}

	@Test
	void testAddProduct() {
		
	}

}
