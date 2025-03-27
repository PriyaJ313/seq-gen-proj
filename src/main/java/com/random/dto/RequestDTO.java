package com.random.dto;

import java.time.OffsetDateTime;

import lombok.Data;

@Data
public class RequestDTO {
	private String origin_country_id;
	private String destination_country_id;
	private Double weight;
	private OffsetDateTime created_at;
	private String customer_id;
	private String customer_name;
	private String customer_slug;
}
