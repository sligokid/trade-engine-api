package com.magoo.currencyfair.api.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.magoo.currencyfair.api.model.Trade;

@RestController
public class TradeController {

	@RequestMapping(value = "/trade", method = RequestMethod.POST)
	// @RequestBody @Valid final User user
	public Trade trade(@RequestBody final Trade trade) {
		return trade;

	}
}