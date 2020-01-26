package ru.spring.hell.http.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonResponse {
    private final String description;
}
