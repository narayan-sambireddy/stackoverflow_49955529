
// Import @Validated annotation from  org.springframework.validation.annotation.Validated
// @Validated will take care of incorporating validation rules on incoming ProductForm JSON request body

@PutMapping("products/{productId}")
public ProductResponse updateProduct(
		@PathVariable("productId") Long productId,
		@Validated @RequestBody ProductForm productForm) throws Exception { 
	Optional<Product> foundProductOpt = productRepository.findById(productId);
	Product foundProduct = foundProductOpt.orElseThrow(() -> new EntityNotFoundException("productId" + productId + "not found."));
	org.apache.commons.beanutils.BeanUtils.copyProperties(foundProduct, productForm);
	productRepository.save(foundProduct);
	return new ProductResponse(null, "product updated");
}
