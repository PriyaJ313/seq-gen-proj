package com.random.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
@Configuration
public class RandomIdGenerator {

	private final long epoch = 1672531200000L;
	private final long nodeIdBits = 10L;
	private final long sequenceBits = 12L;
	private final long maxSequence = (1L << sequenceBits) - 1;
	private long lastTimestamp = -1L;
	private long sequence = 0L;

	public synchronized Map<String,Object> generateId() {
		long timestamp = System.currentTimeMillis();

		if (timestamp == lastTimestamp) {
			sequence = (sequence + 1) & maxSequence;
			if (sequence == 0) {
				timestamp = waitForNextMillis(lastTimestamp);
			}
		} else {
			sequence = 0;
		}

		lastTimestamp = timestamp;
		
		Map<String,Object>response = new HashMap<>();
		response.put("generatedID", ((timestamp - epoch) << (nodeIdBits + sequenceBits)) | sequence);
		response.put("timestamp", timestamp);

		return response;
	}

	private long waitForNextMillis(long lastTimestamp) {
		long timestamp = System.currentTimeMillis();
		while (timestamp <= lastTimestamp) {
			timestamp = System.currentTimeMillis();
		}
		return timestamp;
	}
}
