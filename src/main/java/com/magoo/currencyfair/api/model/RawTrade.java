package com.magoo.currencyfair.api.model;

public class RawTrade {

	// FIXME TimeZone conversion
	// private static final AtomicLong counter = new AtomicLong();
	// this.setId(counter.incrementAndGet());
	// private SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy
	// HH:mm:ss");
	// this.timePlaced = formatter.parse(timePlaced);

	private String userId;

	private String currencyFrom;

	private String currencyTo;

	private String amountSell;

	private String amountBuy;

	private String rate;

	private String timePlaced;

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