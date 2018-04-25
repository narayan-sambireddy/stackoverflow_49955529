package com.assignment.restapi.web.view;

import com.assignment.restapi.domain.Product;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProductForm {

    String productImage;

    @NotBlank(message = "Product title is necessary")
    @Size(max = 100, message = "Product title has to be less than 100 letters")
    String productTitle;

    @Size(max = 500, message = "Product title has to be less than 500 letters")
    String productDescription;

    @Min(value = 1, message = "price has to have a value larger than 1")
    Integer productPrice;

    public ProductForm() {

    }

    public ProductForm(String productImage, String productTitle, String productDescription, Integer productPrice) {
        this.productImage = productImage;
        this.productTitle = productTitle;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }

    //turns productForm into Product object.
    public Product convertToProduct() {
        //step by step debug mode, new object constructor function in Product.java gets called.
        //setter methods get called and values of the ProductForm object gets passed and becomes the new value of the Product object.
        Product product = new Product();
        product.setProductTitle(this.productTitle);
        product.setProductImage(this.productImage);
        product.setProductDescription(this.productDescription);
        product.setProductPrice(this.productPrice);
        return product;
    }
}
