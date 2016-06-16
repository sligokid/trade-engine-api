package com.magoo.currencyfair.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.magoo.currencyfair.api.model.RawTrade;
import com.magoo.currencyfair.api.service.RawTradeService;

@RestController
public class RawTradeController {

	private static final Logger LOG = LoggerFactory.getLogger(RawTrade.class);

	@Autowired
	private RawTradeService tradeService;

	@RequestMapping(value = "/trade", method = RequestMethod.POST)
	// @RequestBody @Valid final User user
	public RawTrade trade(@RequestBody final RawTrade trade) {
		LOG.info(trade.toString());
		tradeService.push(trade);
		return trade;
	}
}