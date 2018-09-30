package com.es.demo.es.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QueryDTO {

    private String origin;

    private String category;

    private Float minScore;

    private String orderBy;

}
