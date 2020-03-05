package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.LibGlobal;

public class SelectHotel extends LibGlobal {
public SelectHotel() {
PageFactory.initElements(driver, this);
}

@FindBy(id = "radiobutton_0")
private WebElement btnradio;

@FindBy(id = "continue")
private WebElement btncontinue;

public WebElement getBtnradio() {
	return btnradio;
}

public WebElement getBtncontinue() {
	return btncontinue;
}











}
