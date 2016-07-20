package com.magoo.currencyfair.api.model;

import javax.validation.constraints.NotNull;

/**
 * The Class RawTrade map a JSON POST trade request to an entity.
 * 
 * Minimal Validation(Spring Bean Validation API) is performed.
 */
public class RawTrade {

	@NotNull
	private String userId;

	@NotNull
	private String currencyFrom;

	@NotNull
	private String currencyTo;

	@NotNull
	private String amountSell;

	@NotNull
	private String amountBuy;

	@NotNull
	private String rate;

	@NotNull
	private String timePlaced;

	@NotNull
	private String originatingCountry;

	public RawTrade() {
		super();
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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

	public String getAmountSell() {
		return amountSell;
	}

	public void setAmountSell(String amountSell) {
		this.amountSell = amountSell;
	}

	public String getAmountBuy() {
		return amountBuy;
	}

	public void setAmountBuy(String amountBuy) {
		this.amountBuy = amountBuy;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getTimePlaced() {
		return timePlaced;
	}

	public void setTimePlaced(String timePlaced) {
		this.timePlaced = timePlaced;
	}

	public String getOriginatingCountry() {
		return originatingCountry;
	}

	public void setOriginatingCountry(String originatingCountry) {
		this.originatingCountry = originatingCountry;
	}

	@Override
	public String toString() {
		return "RawTrade [userId=" + userId + ", currencyFrom=" + currencyFrom + ", currencyTo=" + currencyTo
				+ ", amountSell=" + amountSell + ", amountBuy=" + amountBuy + ", rate=" + rate + ", timePlaced="
				+ timePlaced + ", originatingCountry=" + originatingCountry + "]";
	}

}