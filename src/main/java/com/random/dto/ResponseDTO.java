package com.random.dto;

import java.time.Instant;

import lombok.Data;

@Data
public class ResponseDTO {
	private String trackingNumber;
	private Instant createdAt;

}
