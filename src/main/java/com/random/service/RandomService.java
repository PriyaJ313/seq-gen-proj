package com.random.service;

import java.time.Instant;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.random.dto.RequestDTO;
import com.random.dto.ResponseDTO;
import com.random.util.RandomIdGenerator;

@Component
public class RandomService {
	@Autowired RandomIdGenerator idGenerator;

	public ResponseDTO generateTrackingNumber(RequestDTO requestDTO) {
		Map<String,Object> response = idGenerator.generateId();
		ResponseDTO responseDTO =new ResponseDTO(); 
		String trackingNumber ="CUST" + requestDTO.getCustomer_id().substring(2)+ "-" + 
		requestDTO.getOrigin_country_id() + requestDTO.getDestination_country_id() + "-" + (response.get("generatedID")).toString();
		Instant timestamp = Instant.ofEpochMilli(Long.valueOf(response.get("timestamp").toString()));
		responseDTO.setCreatedAt(timestamp);
		responseDTO.setTrackingNumber(trackingNumber);
        return responseDTO;
	}
}
