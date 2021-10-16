package com.retail.bookstore.catalog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.retail.bookstore.catalog.exception.ProductServiceException;
import com.retail.bookstore.catalog.repository.dao.Product;
import com.retail.bookstore.catalog.service.ProductService;

/**
 * @author: Sagar Mane, Date : 14-10-2021
 */
@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping(value="/product", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> createProduct(@RequestBody Product createProductRequest)
	{
		Product product = productService.createProduct(createProductRequest);
		return new ResponseEntity<Product>(product, HttpStatus.OK);
	}

	@GetMapping(value="/product/{productId}", produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Product> getProduct(@PathVariable long productId) {
		Product product = productService.getProduct(productId);
		return ResponseEntity.ok(product);
	}

	@DeleteMapping("/product/{productId}")
	public ResponseEntity<?> deleteProductCategory(@PathVariable long productId) {
		productService.deleteProduct(productId);
		return ResponseEntity.noContent().build();
	}

	@PutMapping(value="/product", consumes= MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> updateProductCategory(@RequestBody Product updateProductRequest) {
		Product product =productService.updateProduct(updateProductRequest);
		return ResponseEntity.ok(product);
	}
}
