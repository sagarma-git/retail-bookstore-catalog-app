package com.retail.bookstore.catalog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retail.bookstore.catalog.repository.dao.Product;

/**
 * @author: Sagar Mane, Date : 14-10-2021
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
