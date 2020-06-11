package com.alexanderfisher.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Optional;

@Controller
@RequestMapping("${openapi.portfolio.base-path:}")
public class ProjectsApiController implements ProjectsApi {

    private final ProjectsApiDelegate delegate;

    public ProjectsApiController(@org.springframework.beans.factory.annotation.Autowired(required = false) ProjectsApiDelegate delegate) {
        this.delegate = Optional.ofNullable(delegate).orElse(new ProjectsApiDelegate() {});
    }

    @Override
    public ProjectsApiDelegate getDelegate() {
        return delegate;
    }

}
