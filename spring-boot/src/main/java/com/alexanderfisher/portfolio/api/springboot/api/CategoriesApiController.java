package com.alexanderfisher.portfolio.api.springboot.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

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
