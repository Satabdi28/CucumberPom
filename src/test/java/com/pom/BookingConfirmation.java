package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.LibGlobal;

public class BookingConfirmation extends LibGlobal{
public BookingConfirmation() {
PageFactory.initElements(driver, this);
}

@FindBy(id = "order_no")
private WebElement testOrder;

@FindBy(id ="my_itinerary")
private WebElement btnItinerary;


public WebElement getOrderno() {
	return testOrder;
}

public WebElement getBtnItinerary() {
	return btnItinerary;
}

}


