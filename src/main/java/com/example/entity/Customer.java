package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document("demo")
public class Customer {
    @Id
    public String id;
    public String firstName;
    public String lastName;
}
