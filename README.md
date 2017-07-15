# trade-engine-api [![Build Status](https://travis-ci.org/sligokid/trade-engine-api.svg?branch=develop)](https://travis-ci.org/sligokid/trade-engine-api)

Spring Boot microservice API exposing trade processing endpoint (2016)

## Table of Contents

- [Introduction](#introduction)
  - [Overview](#overview)
  - [Architecture](#architecture)
  - [Verbs](#verbs)
  - [URI](#uri)
  - [Demo](#demo)
  - [Install](#install)
  
## Introduction

This Document outlines the web service interface provided to enable the submission of trades to the trade-engine.
The trade engine is a fiticious implementation of a currency exchange platform.
Trades submitted via this API are processed and made available via a RESTFUL endpoint.
No Authentication is requred by the client to access to this service.
This service is intended to be public and function as the entry point in a microservice architecture

## Overview

This API uses the "Representational state transfer" (REST) architectural style. 

## Architecture

![api-diagram 1](https://cloud.githubusercontent.com/assets/6519496/17114491/1221077a-52a7-11e6-9e60-bc8515a12aad.png)

## Verbs

*HTTP Methods* or *Verbs* are the actions which can be used on each resource. There are 2 verbs supported by this API:

- **POST** - Create a new resource (Public).
- **GET** - Retrieve the current representation of a resource (Internal).

#### [Curl Client](src/test/shell/currency-fair-post.sh)

A sample curl based script that can be used to build and send requests to this service.

#### [REST Client](https://resttesttest.com/)
A REST client ie. Cocoa Rest Client can be used to POST / GET resources to / from this service. 

<img width="1039" alt="preview-api" src="https://cloud.githubusercontent.com/assets/6519496/17109918/faf2c83c-5291-11e6-938b-ba80fcc7bf3a.png">


#### <a name="trade-permissible-fields"></a>Permissible Fields

| Element / Attribute     | POST      |
| ----------------------- | --------- | 
| `userId`                | Required  |
| `currencyFrom`          | Required  |
| `currencyTo`            | Required  |
| `amountSell`            | Required  |
| `amountBuy`             | Required  |
| `rate`                  | Required  |
| `timePlaced`            | Required  |
| `originatingCountry`    | Required  |

##### POST

A **POST** request creates a new trade. The request body must contain the JSON representation of a trade with the required fields as detailed in [Permissible Fields](#trade-permissible-fields).

A successful **POST** will result in a **204 No Content** response with an empty body. 

An example trade formatted in JSON ready for POSTING to this API is shown here:

``` json
{
    "userId": "134256", 
    "currencyFrom": "EUR", 
    "currencyTo": "GBP", 
    "amountSell": 1000, 
    "amountBuy": 747.10, 
    "rate": 0.7471, 
    "timePlaced" : "24-JAN-15 10:27:44", 
    "originatingCountry" : "FR"
}

```
##### GET

A **GET** request returns the JSON representation of the next avaiable trade.
This resource is intended for internal consumption via the https://github.com/sligokid/trade-engine-pub component

## URI

The following table summarises all the available resource URIs, and the effect of each verb on them. Each of them is relative to the base URI for this API: `http://ec2-52-16-13-114.eu-west-1.compute.amazonaws.com:8102`.

| Resource                                              | GET                                                 | POST                                  | PUT                               | DELETE                                      |
| ----------------------------------------------------- | --------------------------------------------------- | ------------------------------------- | --------------------------------- | ------------------------------------------- |
| [/api/trade]                                          | N/A                                                 | Creates a new trade                   | N/A                               | N/A                                         |
| [/api/rft]                                            | Returns the next available trade                    | N/A                                   | N/A                               | N/A                                         |


## Demo

http://ec2-52-16-13-114.eu-west-1.compute.amazonaws.com:8102/api/trade

http://ec2-52-16-13-114.eu-west-1.compute.amazonaws.com:8102/api/rft

### Install

``` bash
   $ git clone https://github.com/sligokid/trade-engine-api.git
   $ cd trade-engine-api
   $ mvn clean package
   $ mvn spring-boot:run
```

### Demo

To demo there is a script here that executes random trades against the api.

``` bash
   $ cd trade-engine-api/src/test/shell
   $ mvn spring-boot:run
   $ bash currency-fair-post.sh
```

#### Logs:

``` bash
2017-07-15 13:35:25.205  INFO 38041 --- [nio-8102-exec-1] c.magoo.currencyfair.api.model.RawTrade  : POST:RawTrade [userId=68987, currencyFrom=AUD, currencyTo=DKK, amountSell=22270.3987, amountBuy=22224.2973, rate=0.5789, timePlaced=2017-07-15 13:35:25, originatingCountry=FR]
2017-07-15 13:35:26.238  INFO 38041 --- [nio-8102-exec-3] c.magoo.currencyfair.api.model.RawTrade  : POST:RawTrade [userId=12990, currencyFrom=EUR, currencyTo=CZK, amountSell=16366.2104, amountBuy=131.2839, rate=0.7727, timePlaced=2017-07-15 13:35:26, originatingCountry=CA]
2017-07-15 13:35:27.269  INFO 38041 --- [nio-8102-exec-5] c.magoo.currencyfair.api.model.RawTrade  : POST:RawTrade [userId=67844, currencyFrom=HKD, currencyTo=HKD, amountSell=1211.3233, amountBuy=20860.1019, rate=0.9811, timePlaced=2017-07-15 13:35:27, originatingCountry=CN]
``` 



