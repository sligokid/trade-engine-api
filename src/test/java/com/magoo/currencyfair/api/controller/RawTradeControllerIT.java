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
	public void trade_endpoint_responds_with_204_no_content() throws Exception {
		URL url = new URL("http://localhost:" + port + RawTradeController.TRADE_URL);

		ResponseEntity<RawTrade> response = template.postForEntity(url.toString(), new RawTrade(), RawTrade.class,
				new HashMap<>());

		assertEquals("204", response.getStatusCode().toString());
	}

}
