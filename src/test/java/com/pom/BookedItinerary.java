package com.pom;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.LibGlobal;

public class BookedItinerary extends LibGlobal {
public BookedItinerary() {
PageFactory.initElements(driver, this);
}
@FindBy(xpath = "//input[@name='cancelall']")
private WebElement btncancelselected;

public WebElement getBtncancelselected() {
	return btncancelselected;
}


}







