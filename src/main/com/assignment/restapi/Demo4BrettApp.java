package com.assignment.restapi;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.restapi.domain.Product;
import com.assignment.restapi.repo.ProductRepository;
import com.assignment.restapi.web.view.ProductForm;
import com.assignment.restapi.web.view.ProductResponse;

@SpringBootApplication
@RestController
public class Demo4BrettApp {

	public static void main(String[] args) {
		SpringApplication.run(Demo4BrettApp.class, args);
	}

	@Autowired
	private ProductRepository productRepository;

	@PutMapping("products/{productId}")
	public ProductResponse updateProduct(
			@PathVariable("productId") Long productId,
			@Validated @RequestBody ProductForm productForm) throws Exception { 
		// @Validated will take care of incorporating validation rules on incoming ProductForm JSON request body
		Optional<Product> foundProductOpt = productRepository.findById(productId);
		Product foundProduct = foundProductOpt.orElseThrow(() -> new EntityNotFoundException("productId" + productId + "not found."));
		org.apache.commons.beanutils.BeanUtils.copyProperties(foundProduct, productForm);
		productRepository.save(foundProduct);

		return new ProductResponse(null, "product updated");
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ProductResponse> handleException(Exception ex) {
		ex.printStackTrace();
		return ResponseEntity.badRequest().body(new ProductResponse(null, "product validation failed!"));
	}
	
}
