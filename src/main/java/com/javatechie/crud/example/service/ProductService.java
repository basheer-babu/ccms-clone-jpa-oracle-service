package com.javatechie.crud.example.service;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
    	System.out.println(products);
    	
        return repository.saveAll(products);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product getProductByName(String case_ref_no) {
        return repository.findBycase_ref_no(case_ref_no);
    }

    public String deleteProduct(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        existingProduct.setCase_ref_no(product.getCase_ref_no());
        existingProduct.setCourt_order_id(product.getCourt_order_id());
        existingProduct.setRequest_type(product.getRequest_type());
        existingProduct.setCourt_name(product.getCourt_name());
        existingProduct.setCourt_order_date(product.getCourt_order_date());
        existingProduct.setMaker_name(product.getMaker_name());
        existingProduct.setChecker_name(product.getChecker_name());
        existingProduct.setDefendant_type(product.getDefendant_type());
        return repository.save(existingProduct);
    }


}
