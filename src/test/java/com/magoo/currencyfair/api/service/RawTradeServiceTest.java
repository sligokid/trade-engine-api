package com.magoo.currencyfair.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import com.magoo.currencyfair.api.model.RawTrade;

public class RawTradeServiceTest {

	@Test
	public void push_adds_trade_to_queue() {
		RawTradeService tradeService = new RawTradeService();

		tradeService.push(new RawTrade());

		assertEquals(1, tradeService.getTradeCount());
	}

	@Test
	public void pop_removes_trade_from_queue() {
		RawTradeService tradeService = new RawTradeService();
		tradeService.push(new RawTrade());
		tradeService.push(new RawTrade());

		assertEquals(2, tradeService.getTradeCount());
		tradeService.pop();

		assertEquals(1, tradeService.getTradeCount());
	}

	@Test
	public void pop_empty_queue_returns_null() {
		RawTradeService tradeService = new RawTradeService();

		assertNull(tradeService.pop());
	}

}
