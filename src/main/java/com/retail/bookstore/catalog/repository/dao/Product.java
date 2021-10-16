package com.retail.bookstore.catalog.repository.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author: Sagar Mane, Date : 14-10-2021
 */
@Entity
@Table(name = "PRODUCT")
public class Product {
	@Id
	@GeneratedValue
	@Column(name = "PRODUCT_ID")
	private Long productId;

	@Column(name = "PRODUCT_NAME", nullable = false)
	private String productName;

	@Column(name = "PRODUCT_DESCRIPTION")
	private String description;
	private double price;

	@Column(name = "available_item_count")
	private int availableItemCount;

	public Product() {
		super();
	}

	public Product(Long productId, String productName, String description, double price, int availableItemCount) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.availableItemCount = availableItemCount;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailableItemCount() {
		return availableItemCount;
	}

	public void setAvailableItemCount(int availableItemCount) {
		this.availableItemCount = availableItemCount;
	}

}
