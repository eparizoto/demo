package com.example.demo.core.model.token;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Token{
	@JsonProperty("access_token")
	private String accessToken;
}