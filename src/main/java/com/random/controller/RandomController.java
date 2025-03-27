package com.random.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.random.dto.RequestDTO;
import com.random.dto.ResponseDTO;
import com.random.service.RandomService;

@Controller
@RequestMapping("api")
public class RandomController {
	@Autowired
	RandomService randomService;

	@GetMapping("/next-tracking-number")
	public ResponseEntity<ResponseDTO> trackingNumber(@RequestBody RequestDTO requestDTO) {
		return new ResponseEntity<>(randomService.generateTrackingNumber(requestDTO), HttpStatus.OK);
	}
}
