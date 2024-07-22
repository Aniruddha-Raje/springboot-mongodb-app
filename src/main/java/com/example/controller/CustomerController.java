package com.example.controller;

import com.example.dto.FakeAPIResponse;
import com.example.dto.Greeting;
import com.example.entity.Customer;
import com.example.exception.BadRequestException;
import com.example.service.CustomerService;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        System.out.println("getAllCustomers called");
        System.out.println(eurekaClient.getApplication(appName).getName());
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/hello-world")
    public ResponseEntity<Greeting> sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return new ResponseEntity<>(new Greeting(counter.incrementAndGet(), String.format(template, name)), HttpStatus.OK);
    }

    @GetMapping("/rest-template")
    public ResponseEntity<FakeAPIResponse> callApi() {
        return new ResponseEntity<>(customerService.callApi().get(), HttpStatus.OK);
    }

    @GetMapping("/throw-exception")
    public ResponseEntity<String> globalExceptionTest() {
        throw new BadRequestException("Missing required parameter: id");
    }
}
