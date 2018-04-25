package com.assignment.restapi.web.view;

import com.assignment.restapi.domain.Product;

public class ProductResponse {

	private Product product;
	private String message;

	public ProductResponse(Product product, String message) {
		this.product = product;
		this.message = message;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
