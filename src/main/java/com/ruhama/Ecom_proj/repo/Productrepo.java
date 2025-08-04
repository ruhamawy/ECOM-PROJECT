package com.ruhama.Ecom_proj.repo;

import com.ruhama.Ecom_proj.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Productrepo extends JpaRepository <Product,Integer> {

}
