#!/bin/bash
for n in {1..10};
do
#{"userId": "134256", "currencyFrom": "EUR", "currencyTo": "GBP", "amountSell": 1000, "amountBuy": 747.10, "rate": 0.7471, "timePlaced" : "24-JAN-15 10:27:44", "originatingCountry" : "FR"}
	curl -d '{
			"userId":"'"$n"'",
			"currencyFrom": "EUR", 
			"currencyTo": "GBP", 
			"amountSell": 1000, 
			"amountBuy": 747.10, 
			"rate": 0.7471, 
			"timePlaced" : "14-JAN-15 10:27:44", 
			"originatingCountry" : "FR"
		}' -H 'Content-Type: application/json' 'http://localhost:8282/trade'
echo ""

done  
