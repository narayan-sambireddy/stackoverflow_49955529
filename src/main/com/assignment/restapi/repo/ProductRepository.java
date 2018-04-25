package com.assignment.restapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.restapi.domain.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
