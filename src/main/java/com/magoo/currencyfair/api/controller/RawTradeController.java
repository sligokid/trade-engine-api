package com.magoo.currencyfair.api.controller;

import javax.servlet.http.HttpServletResponse;

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

	static final String TRADE_URL = "/api/trade";

	@Autowired
	private RawTradeService tradeService;

	@RequestMapping(value = TRADE_URL, method = RequestMethod.POST)
	public RawTrade trade(@RequestBody final RawTrade trade, HttpServletResponse response) {
		LOG.info("Parsing:" + trade.toString());
		tradeService.push(trade);
		response.setStatus(HttpServletResponse.SC_NO_CONTENT);
		return trade;
	}
}