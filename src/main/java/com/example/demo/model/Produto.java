package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;

@Builder
public class Produto {
    @JsonProperty("id")
    @ApiModelProperty(value = "1")
    private Integer id;

    @JsonProperty("descrição")
    @ApiModelProperty(value = "Sabão")
    private String descricao;
}
