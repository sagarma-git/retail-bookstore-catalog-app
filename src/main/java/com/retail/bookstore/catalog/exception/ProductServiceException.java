package com.retail.bookstore.catalog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author: Sagar Mane, Date : 14-10-2021
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ProductServiceException extends Exception {
	public ProductServiceException(String message) {
		super(message);
	}
}