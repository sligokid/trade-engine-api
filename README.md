# trade-engine-api

Spring Boot microservice API exposing trade processing endpoint (2016)

## Table of Contents

- [Introduction](#introduction)
  - [Overview](#overview)
  - [Verbs](#verbs)
  - [URI](#uri)
  - [Demo](#demo)

## Introduction

This Document outlines the web service interface provided to enable the submission of trades to the trade-engine.
The trade engine is a fiticious implementation of a currency exchange platform.
Trades submitted via this API are processed and made available via a RESTFUL endpoint.
No Authentication is requred by the client to access to this service.

### Overview

This API uses the "Representational state transfer" (REST) architectural style. 

### Verbs

*HTTP Methods* or *Verbs* are the actions which can be used on each resource. There are 2 verbs supported by this API:

- **POST** - Create a new resource (Public).
- **GET** - Retrieve the current representation of a resource (Internal).

#### [Curl Client](src/test/shell/currency-fair-post.sh)

A sample curl based script that can be used to build and send requests to this service.

#### [REST Client](https://resttesttest.com/)
A REST client ie. Cocoa Rest Client can be used to POST / GET resources to / from this service. 



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

A **GET** request returns the JSON representation of the next avaiable quote.
This resource is intended for internal consumption via the https://github.com/sligokid/trade-engine-pub component

### URI

The following table summarises all the available resource URIs, and the effect of each verb on them. Each of them is relative to the base URI for this API: `http://ec2-52-16-13-114.eu-west-1.compute.amazonaws.com:8102`.

| Resource                                              | GET                                                 | POST                                  | PUT                               | DELETE                                      |
| ----------------------------------------------------- | --------------------------------------------------- | ------------------------------------- | --------------------------------- | ------------------------------------------- |
| [/api/trade]                                          | N/A                                                 | Creates a new trade                   | N/A                               | N/A                                         |
| [/api/rft]                                            | Returns the next available trade                    | N/A                                   | N/A                               | N/A                                         |


##Demo

http://ec2-52-16-13-114.eu-west-1.compute.amazonaws.com:8102/api/trade

http://ec2-52-16-13-114.eu-west-1.compute.amazonaws.com:8102/api/rft
