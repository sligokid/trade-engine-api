package com.magoo.currencyfair.api.controller;

import static org.junit.Assert.assertEquals;

import java.net.URL;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import com.magoo.currencyfair.api.CurrencyFairApiApplication;
import com.magoo.currencyfair.api.model.RawTrade;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CurrencyFairApiApplication.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class RawTradeControllerIT {

	@Value("${local.server.port}")
	private int port;

	private RestTemplate template;

	@Before
	public void before() throws Exception {
		template = new TestRestTemplate();
	}

	@Test
	public void trade_endpoint_validation_fails_with_400() throws Exception {
		URL url = new URL("http://localhost:" + port + RawTradeController.API_TRADE_URL);

		RawTrade rawTrade = new RawTrade();

		ResponseEntity<RawTrade> response = template.postForEntity(url.toString(), rawTrade, RawTrade.class,
				new HashMap<>());

		assertEquals("400", response.getStatusCode().toString());
	}

	@Test
	public void trade_endpoint_responds_with_204() throws Exception {
		URL url = new URL("http://localhost:" + port + RawTradeController.API_TRADE_URL);

		RawTrade rawTrade = buildValidatedTrade();
		ResponseEntity<RawTrade> response = template.postForEntity(url.toString(), rawTrade, RawTrade.class,
				new HashMap<>());

		assertEquals("204", response.getStatusCode().toString());
	}

	private RawTrade buildValidatedTrade() {
		RawTrade rawTrade = new RawTrade();
		rawTrade.setUserId("123456");
		rawTrade.setCurrencyFrom("EUR");
		rawTrade.setCurrencyTo("GBP");
		rawTrade.setAmountSell("1000");
		rawTrade.setAmountBuy("747.10");
		rawTrade.setRate("0.741");
		rawTrade.setTimePlaced("24-JAN-15 10:27:44");
		rawTrade.setOriginatingCountry("FR");
		return rawTrade;
	}

}
