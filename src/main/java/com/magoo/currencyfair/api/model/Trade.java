package com.magoo.currencyfair.api.model;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

public class Trade {

	private static final AtomicLong counter = new AtomicLong();

	// FIXME TimeZone conversion
	private SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy HH:mm:ss");

	private long id;

	private long userId;

	private String currencyFrom;

	private String currencyTo;

	private BigDecimal amountSell;

	private BigDecimal amountBuy;

	private BigDecimal rate;

	private Date timePlaced;

	private String originatingCountry;

	public Trade() {
		super();
		this.setId(counter.incrementAndGet());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getCurrencyFrom() {
		return currencyFrom;
	}

	public void setCurrencyFrom(String currencyFrom) {
		this.currencyFrom = currencyFrom;
	}

	public String getCurrencyTo() {
		return currencyTo;
	}

	public void setCurrencyTo(String currencyTo) {
		this.currencyTo = currencyTo;
	}

	public BigDecimal getAmountSell() {
		return amountSell;
	}

	public void setAmountSell(BigDecimal amountSell) {
		this.amountSell = amountSell;
	}

	public BigDecimal getAmountBuy() {
		return amountBuy;
	}

	public void setAmountBuy(BigDecimal amountBuy) {
		this.amountBuy = amountBuy;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Date getTimePlaced() {
		return timePlaced;
	}

	// FIXME UT
	public void setTimePlaced(String timePlaced) throws ParseException {
		this.timePlaced = formatter.parse(timePlaced);
	}

	public String getOriginatingCountry() {
		return originatingCountry;
	}

	public void setOriginatingCountry(String originatingCountry) {
		this.originatingCountry = originatingCountry;
	}

	// FIXME use Java 7 Objects method

}