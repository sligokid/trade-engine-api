package com.magoo.currencyfair.api.controller;

import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.magoo.currencyfair.api.model.Trade;

@RestController
public class TradeController {

	private final AtomicLong counter = new AtomicLong();

	private SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy HH:mm:ss");

	@RequestMapping(value = "/trade", method = RequestMethod.POST)
	// @RequestBody @Valid final User user
	public Trade trade(@RequestBody final Trade trade) {
		trade.setId(counter.incrementAndGet());
		return trade;

	}
}