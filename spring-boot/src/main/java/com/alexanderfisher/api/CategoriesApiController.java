package com.alexanderfisher.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2020-06-10T14:42:01.209035-04:00[America/New_York]")

@Controller
@RequestMapping("${openapi.portfolio.base-path:}")
public class CategoriesApiController implements CategoriesApi {

    private final CategoriesApiDelegate delegate;

    public CategoriesApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) CategoriesApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new CategoriesApiDelegate() {});
    }

    @Override
    public CategoriesApiDelegate getDelegate() {
        return delegate;
    }

}
