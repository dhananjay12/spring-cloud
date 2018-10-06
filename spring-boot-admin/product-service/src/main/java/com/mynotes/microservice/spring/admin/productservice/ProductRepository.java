package com.mynotes.microservice.spring.admin.productservice;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
