package com.retail.bookstore.catalog;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.retail.bookstore.catalog.repository.ProductRepository;
import com.retail.bookstore.catalog.repository.dao.Product;
import com.retail.bookstore.catalog.service.impl.ProductServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductRepositoryTests {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	ProductServiceImpl productServiceImpl;

	// JUnit test for saveProduct
	@Test
	@Order(1)
	@Transactional
	public void saveProductTest() {
		// Test case written for save product
		Product product = new Product();
		product.setProductName("Hibernate");
		product.setDescription("Hibernate 3.2 Version");
		product.setPrice(800);
		product.setAvailableItemCount(10);
		// Product productRes = productServiceImpl.createProduct(product);
		productServiceImpl.createProduct(product);
		Assertions.assertThat(product.getProductId()).isGreaterThan(0);
	}

	// JUnit test for getProduct
	@Test
	@Order(2)
	public void getProductTest() {
		// Test case written for fetch product
		Product product = productServiceImpl.getProduct(1L);
		Assertions.assertThat(product.getProductId()).isEqualTo(1L);
	}

	@Test
	@Order(3)
	@Transactional
	public void updateProductTest() {
		// Test case written for update product
		Product productResponse = productServiceImpl
				.updateProduct(new Product(3L, "Hibernate 2", "Hibernate 3.2.1", 900.50, 10));
		Assertions.assertThat(productResponse.getProductName()).isEqualTo("Hibernate 2");
	}

	@Test
	@Order(4)
	@Transactional
	public void deleteProductTest() {
		// Test case written for delete product
		productServiceImpl.deleteProduct(2L);
		Product product = null;
		Optional<Product> productOptional = productRepository.findById(2L);
		if (productOptional.isPresent()) {
			product = productOptional.get();
		}
		Assertions.assertThat(product).isNull();
	}
}
