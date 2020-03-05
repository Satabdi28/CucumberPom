package com.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.LibGlobal;

public class BookedItinerary extends LibGlobal {
public BookedItinerary() {
PageFactory.initElements(driver, this);
}
@FindBy(xpath = "(//input[@type='submit'])[2]")
private List< WebElement> btncancelselected;

public List<WebElement> getBtncancelselected() {
	return btncancelselected;
}



}



