package com.alexanderfisher.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.NativeWebRequest;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-06-09T16:13:05.166664-04:00[America/New_York]")

@Controller
@RequestMapping("${openapi.portfolio.base-path:}")
public class CategoriesApiController implements CategoriesApi {

    private final NativeWebRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CategoriesApiController(NativeWebRequest request) {
        this.request = request;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return Optional.ofNullable(request);
    }

}
