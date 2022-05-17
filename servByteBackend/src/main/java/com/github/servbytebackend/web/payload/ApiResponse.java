package com.github.servbytebackend.web.payload;


import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ApiResponse {
    private String status;
    private Map<String, Object> data = new HashMap<>();
}
