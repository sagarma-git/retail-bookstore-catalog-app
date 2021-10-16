package com.retail.bookstore.catalog.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.retail.bookstore.catalog.exception.ProductServiceException;
import com.retail.bookstore.catalog.exception.ResourceNotFoundException;
import com.retail.bookstore.catalog.repository.ProductRepository;
import com.retail.bookstore.catalog.repository.dao.Product;
import com.retail.bookstore.catalog.service.ProductService;

/**
 * @author: Sagar Mane, Date : 14-10-2021
 */
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public Product createProduct(Product createProductRequest)  {
		// Method added for adding product details
		Product savedProduct = productRepository.save(createProductRequest);
		return savedProduct;
	}

	@Override
	public Product getProduct(Long productId) {
		// Method added for fetching particular product detail
		Optional<Product> productOptional = productRepository.findById(productId);
		Product product = productOptional.orElseThrow(() -> new ResourceNotFoundException("Product Id doesn't exist!"));
		return product;
	}

	@Override
	public void deleteProduct(Long productId) {
		// Method added for deleting particular product
		productRepository.deleteById(productId);
	}

	@Override
	public Product updateProduct(Product updateProductRequest) {
		// Method added for updating product details
		Optional<Product> productOptional = productRepository.findById(updateProductRequest.getProductId());
		productOptional.orElseThrow(() -> new ResourceNotFoundException("Product Id doesn't exist!"));
		Product product = productRepository.save(updateProductRequest);
		return product;
	}
}
