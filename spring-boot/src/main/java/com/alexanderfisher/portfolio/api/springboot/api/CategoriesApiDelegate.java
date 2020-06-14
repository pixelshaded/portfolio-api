package com.alexanderfisher.portfolio.api.springboot.api;

import com.alexanderfisher.portfolio.api.models.Category;
import com.alexanderfisher.portfolio.api.models.Project;
import io.swagger.annotations.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * A delegate to be called by the {@link CategoriesApiController}}.
 * Implement this interface with a {@link org.springframework.stereotype.Service} annotated class.
 */

public interface CategoriesApiDelegate {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * @see CategoriesApi#getCategories
     */
    default ResponseEntity<List<Category>> getCategories() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"subtitle\" : \"subtitle\",  \"description\" : \"description\",  \"id\" : 0,  \"title\" : \"title\",  \"slug\" : \"slug\"}");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

    /**
     * @see CategoriesApi#getCategoryProjects
     */
    default ResponseEntity<List<Project>> getCategoryProjects(Integer categoryId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    ApiUtil.setExampleResponse(request, "application/json", "{  \"subtitle\" : \"subtitle\",  \"intro\" : \"intro\",  \"subcontent\" : \"subcontent\",  \"tagline\" : \"tagline\",  \"id\" : 0,  \"title\" : \"title\",  \"categoryId\" : 6,  \"slug\" : \"slug\",  \"content\" : \"content\"}");
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
