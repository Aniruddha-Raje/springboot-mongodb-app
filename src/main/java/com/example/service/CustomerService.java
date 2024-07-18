package com.example.service;

import com.example.dto.FakeAPIResponse;
import com.example.entity.Customer;
import com.example.entity.Person;
import com.example.repository.CustomerRepository;
import com.example.utils.Config;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Config config;

    @PostConstruct
    private void postConstructExample(){
        System.out.println("postConstructExample called");
    }

    @PreDestroy
    private void preDestroyExample(){
        System.out.println("preDestroyExample called");
    }

    @Cacheable("customers")
    public List<Customer> getAllCustomers(){
        System.out.println("inside getAllCustomers");

        System.out.println("from config => "+ config.getJsonPlaceholderUrl() + config.getBaseUrl() + config.getPath());

        var customers = customerRepository.findAll();
        var multiLineMessage = """
                customers => { customers }
            """;
        System.out.println(multiLineMessage);
        return customers;
    }

    public Optional<FakeAPIResponse> callApi() {

        Person person = new Person("Aniruddha", "Pune", 30);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        HttpEntity<Person> requestEntity = new HttpEntity<>(person, headers);

        try{
            ResponseEntity<FakeAPIResponse> fakeAPIResponse = restTemplate.exchange(
                    config.getJsonPlaceholderUrl(),
                    HttpMethod.POST,
                    requestEntity,
                    FakeAPIResponse.class
            );

            return Optional.ofNullable(fakeAPIResponse.getBody());
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    @Async
    public CompletableFuture<String> asyncTest() {
        return CompletableFuture.completedFuture("");
    }
}
