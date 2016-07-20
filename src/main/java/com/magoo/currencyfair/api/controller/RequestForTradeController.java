package com.magoo.currencyfair.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.magoo.currencyfair.api.model.RawTrade;
import com.magoo.currencyfair.api.service.RawTradeService;

/**
 * The Class RequestForTradeController REST API implementation.
 */
@RestController
public class RequestForTradeController {

	private static final Logger LOG = LoggerFactory.getLogger(RequestForTradeController.class);

	static final String API_RFT_URL = "/api/rft";

	@Autowired
	private RawTradeService tradeService;

	@RequestMapping(value = API_RFT_URL, method = RequestMethod.GET)
	public RawTrade trade() {
		RawTrade trade = tradeService.pop();
		if (trade != null) {
			LOG.info("GET:" + trade.toString());
		}
		return trade;
	}

}