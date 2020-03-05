Feature: Verifying Adactin details

Scenario: Verifying hotel booking details

Given User is on Adactin page
When User enters details
|username |password|
|Satabdi28|123456  |
And User should click the login button
And User enters the hotel details
|Location|    Hotels    |Room Type|Number of Rooms|Check In Date|Check Out Date|Adults per Room|
| Paris  |Hotel Sunshine|  Double |   1-One       |  04/03/2020 |  05/03/2020  |     2-Two     |
And User should click the Search button
And User should click the radio button and then click the Continue button
And User enters the booking details
|First Name|Last Name |Billing Address|Credit Card No. |Credit Card Type| Expiry Date|Expiry Datee|CVV Number|
| Satabdi  |Chatterjee|  Aminjikarai  |2865330178511255|       VISA     |   October  |    2022    |    280   |
And User should click Book Now button
And User confirms the booking
And User cancels the booked hotel
Then User will close the browser