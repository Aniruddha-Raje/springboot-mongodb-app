package com.example.serverless;

import java.util.Map;

public class ApiGatewayRequest {
    private String body;
    private Map<String, String> headers;
    private Map<String, String> queryStringParameters;
    private Map<String, String> pathParameters;
    private boolean isBase64Encoded;
}
