package com.magoo.currencyfair.api.service;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Service;

import com.magoo.currencyfair.api.model.RawTrade;

/**
 * The Class RawTradeService providing trade queue functionality.
 */
@Service
public class RawTradeService {

	private ConcurrentLinkedQueue<RawTrade> queue = new ConcurrentLinkedQueue<>();

	public void push(RawTrade trade) {
		queue.add(trade);
	}

	public RawTrade pop() {
		return queue.poll();
	}

	int getTradeCount() {
		return queue.size();
	}

}
