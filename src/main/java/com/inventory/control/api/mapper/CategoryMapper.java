package com.inventory.control.api.mapper;

import com.inventory.control.api.request.CategoryPostRequest;
import com.inventory.control.api.response.CategoryPostResponse;
import com.inventory.control.infrastructure.model.Category;
import com.inventory.control.infrastructure.model.enumeration.Status;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

    public CategoryPostResponse toDto(Category entity) {
        return new CategoryPostResponse(
                entity.getName(),
                entity.getStatus().toString()
        );
    }

    public Category toEntity(CategoryPostRequest dto) {
        return Category.builder()
                .name(dto.name())
                .status(Status.valueOf(dto.status()))
                .enterprise(dto.enterprise())
                .build();
    }
}
