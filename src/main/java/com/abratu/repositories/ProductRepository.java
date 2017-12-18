package com.abratu.repositories;

import com.abratu.entities.Product;
import com.abratu.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

    public Product findByCode(String code);
}
