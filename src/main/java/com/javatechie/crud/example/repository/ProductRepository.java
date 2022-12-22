package com.javatechie.crud.example.repository;

import com.javatechie.crud.example.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
	@Query(value = "select * from CCMS_DEMO_TASK_DATA where case_ref_no=:?",nativeQuery = true)
    Product findBycase_ref_no(String case_ref_no);
}

