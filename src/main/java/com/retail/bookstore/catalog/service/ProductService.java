package com.retail.bookstore.catalog.service;


import com.retail.bookstore.catalog.repository.dao.Product;

/**
 * @author: Sagar Mane, Date : 14-10-2021
 */
public interface ProductService {

	Product createProduct(Product createProductRequest);

	Product getProduct(Long productId);

	void deleteProduct(Long productId);

	Product updateProduct(Product updateProductRequest);

}
