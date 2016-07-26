#!/bin/bash          

declare -a userIDArray=(67844 59222 45030 33411 68987 56733 12990)
declare -a currencyArray=(AED AUD CAD CHF CZK DKK EUR GBP HKD)
declare -a countryArray=(FR CA CN DK JP MX NO SK)

COUNTER=0
#while [  $COUNTER -lt 100 ]; do
while [  true ]; do
	temp=$((RANDOM % ${#userIDArray[@]}))
	userID=${userIDArray[temp]}
#	echo User ID is $userID

	temp=$((RANDOM % ${#currencyArray[@]}))
	currencyFrom=${currencyArray[temp]}
#	echo Currency from is $currencyFrom

	temp=$((RANDOM % ${#currencyArray[@]}))
	currencyTo=${currencyArray[temp]}
#	echo Currency to is $currencyFrom
	
	#Purposefully allowing currencyFrom and currencyTo to be the same in some cases to simulate errors in the message processor
	
	amountSell=$RANDOM
	amountSell=${amountSell:0:5}
	temp=$RANDOM
	amountSell=$amountSell.${temp:0:4}
#	echo Amount to Sell is $amountSell
	
	amountBuy=$RANDOM
	amountBuy=${amountBuy:0:5}
	temp=$RANDOM
	amountBuy=$amountBuy.${temp:0:4}
#	echo Amount to Buy is $amountBuy
	
	rate=$RANDOM
	rate=0.${rate:0:4}
#	echo Rate is $rate
	
	timePlaced=$(date +%F\ %T)
	datePlaced=$(date +%F)
	hoursPlaced=$(date +%H)
	minutesPlaced=$(date +%M)
	secondsPlaced=$(date +%S)
	echo Time placed is $datePlaced $hoursPlaced:$minutesPlaced:$secondsPlaced
	
	temp=$((RANDOM % ${#countryArray[@]}))
	originatingCountry=${countryArray[temp]}
#	echo Originating country is $originatingCountry
	
	json='{"userId":"'"$userID"'","currencyFrom":"'"$currencyFrom"'","currencyTo":"'"$currencyTo"'","amountSell":'"$amountSell"',"amountBuy":'"$amountBuy"',"rate":'"$rate"',"timePlaced":"'"$datePlaced"' '"$hoursPlaced"':'"$minutesPlaced"':'"$secondsPlaced"'","originatingCountry":"'"$originatingCountry"'"}'
#	echo JSON is $json
	
	#echo curl -i -H "Accept: application/json" -H "Content-Type:application/json" -X POST --data "$json" "http://localhost:8282/api/trade"
	curl --silent -i -H "Accept: application/json" -H "Content-Type:application/json" -X POST --data "$json" "http://localhost:8102/api/trade"
	
	#timeToWait=$((RANDOM % 3))
        timeToWait=1
	echo Sleeping $timeToWait
	sleep $timeToWait

	let COUNTER=COUNTER+1 
done
