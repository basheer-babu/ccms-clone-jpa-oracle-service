package com.javatechie.crud.example.service;

import com.javatechie.crud.example.bo.TaskDetailsReq;
import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.entity.TaskCreationResponseEntity;
import com.javatechie.crud.example.entity.TaskDetailsEntity;
import com.javatechie.crud.example.entity.TaskDetailsEntityList;
import com.javatechie.crud.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;
    private final RestTemplate restTemplate = new RestTemplate();
    public Product saveProduct(Product product) {
    	Product p=new Product();
    	HttpHeaders headers = new HttpHeaders();

    	headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, headers);

		TaskCreationResponseEntity responseToken = restTemplate.postForObject("http://localhost:8085/engine-rest/process-definition/key/Process_16aocrb/start", entity, TaskCreationResponseEntity.class);
		product.setProcessId(responseToken.getId());
		product.setDefinition_Id(responseToken.getDefinitionId());
		System.out.println("product"+product);
		System.out.println("case creation Response."+responseToken);
        return repository.save(product);
//		return p;
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

	public String ccmsClaimTask(String id, String username) {
		
		String taskId=getTaskId(id);
		System.out.println("taskId"+taskId);
		HttpHeaders headers = new HttpHeaders();
		TaskDetailsReq detailsReq=new TaskDetailsReq();
		detailsReq.setUserId(username);
    	headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		//MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		HttpEntity<TaskDetailsReq> entity = new HttpEntity<TaskDetailsReq>(detailsReq, headers);
		
		String res = restTemplate.postForObject("http://localhost:8085/engine-rest/task/"+taskId+"/claim", entity, String.class);
	System.out.println("res : "+res);
		
		return "";
	}
	public String getTaskId(String id) {
		
		String url = "http://localhost:8085/engine-rest/task?processInstanceId="+id;
		
		System.out.println("url"+url);
		// fetch response in a string object
		
		TaskDetailsEntity[] response = restTemplate.getForObject(url, TaskDetailsEntity[].class);
		System.out.println("response"+response[0]);
		return response[0].getId();
	}

	public Product ccmsGetbyProcessId(String id) {
		
		Product product=repository.findByProcessId(id);
		System.out.println(product);
		return product;
	}

	public Product ccmsCaseComplete(Product product) {
		
		
		return null;
	}

}
