package com.magoo.currencyfair.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.magoo.currencyfair.api.model.RawTrade;
import com.magoo.currencyfair.api.service.RawTradeService;

@RestController
public class RequestForTradeController {

	@Autowired
	private RawTradeService tradeService;

	@RequestMapping(value = "/rft", method = RequestMethod.GET)
	public RawTrade trade() {
		return tradeService.pop();
	}
}