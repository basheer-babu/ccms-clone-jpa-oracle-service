package com.javatechie.crud.example.controller;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/product/{case_ref_no}")
    public Product findProductByName(@PathVariable String case_ref_no) {
        return service.getProductByName(case_ref_no);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }
    
    @GetMapping("/ccmsclaimtask/{id}/{userName}")
    public String ccmsClaimTask(@PathVariable String id, @PathVariable String userName) {
        return service.ccmsClaimTask(id, userName);
    }
    
    @GetMapping("/ccmsgetbyprocessid/{id}")
    public Product ccmsGetbyProcessId(@PathVariable String id) {
        return service.ccmsGetbyProcessId(id);
    }
    
    @PostMapping("/ccmscasecomplete")
    public Product ccmsCaseComplete(@RequestBody Product product) {
        return service.ccmsCaseComplete(product);
    }
    @GetMapping("/gettaskid/{id}")
    public String getTaskId(@PathVariable String id) {
    	System.out.println(id);
        return service.getTaskId(id);
    }
}
