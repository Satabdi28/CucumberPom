package com.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.LibGlobal;

public class SearchHotel extends LibGlobal {
public SearchHotel() {
PageFactory.initElements(driver, this);
}
@FindBy(id = "location")
private WebElement loc;

@FindBy(id = "hotels")
private WebElement hotel;

@FindBy(id = "room_type")
private WebElement roomtype;

@FindBy(xpath = "//select[@name='room_nos']")
private WebElement numberofrooms;

@FindBy(id = "datepick_in")
private WebElement datein;

@FindBy(id = "datepick_out")
private WebElement dateout;

@FindBy(xpath = "//select[@name='adult_room']")
private WebElement adultsperroom;

@FindBy(id = "Submit")
private WebElement btnSearch;

public WebElement getLoc() {
	return loc;
}

public WebElement getHotel() {
	return hotel;
}

public WebElement getRoomtype() {
	return roomtype;
}

public WebElement getNumberofrooms() {
	return numberofrooms;
}

public WebElement getDatein() {
	return datein;
}

public WebElement getDateout() {
	return dateout;
}

public WebElement getAdultsperroom() {
	return adultsperroom;
}

public WebElement getBtnSearch() {
	return btnSearch;
}
}
