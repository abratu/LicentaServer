package com.abratu.repositories;

import com.abratu.entities.ProductType;
import com.abratu.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface ProductTypeRepository extends CrudRepository<ProductType, Long> {

    public ProductType findByName(String name);
}
