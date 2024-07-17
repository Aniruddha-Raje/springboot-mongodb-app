package com.example.utils;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(prefix = "conditionalProperty", name = "key", havingValue = "yes")
public class ConditionalComponent {
}
