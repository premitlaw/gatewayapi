package com.capgemini.demo.gateway;

import com.capgemini.demo.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/demo/gateway")
public class userGateway {

    @Value("${workerHost}")
    private String workerHost;

    private final String WORKER_ROOT = "/demo/customer/";

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/customer/all")
    public ResponseEntity<Customer[]> getAllUsers() {
        return restTemplate.getForEntity(workerHost + WORKER_ROOT + "all", Customer[].class);
    }

    @PostMapping("/customer")
    Customer newUser(@RequestBody Customer newCustomer) {
        return restTemplate.postForObject(workerHost + WORKER_ROOT, newCustomer, Customer.class);
    }

    @DeleteMapping("/customer/{id}")
    void deleteEmployee(@PathVariable Long id) {
        restTemplate.delete(workerHost + WORKER_ROOT + id);
    }

}
