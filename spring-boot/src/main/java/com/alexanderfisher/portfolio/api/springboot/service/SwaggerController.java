package com.alexanderfisher.portfolio.api.springboot.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@RestController
public class SwaggerController {

    private final Object swagger;

    public SwaggerController() throws IOException {
        try (InputStream stream = new ClassPathResource("openapi.yml").getInputStream()) {
            String yaml = IOUtils.toString(stream, StandardCharsets.UTF_8);
            ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());
            swagger = yamlMapper.readValue(yaml, Object.class);
        }
    }

    @GetMapping("/swagger.json")
    public Object getSwagger() {
        return swagger;
    }
}
