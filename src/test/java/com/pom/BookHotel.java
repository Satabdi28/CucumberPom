package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.LibGlobal;

public class BookHotel extends LibGlobal {
public BookHotel() {
PageFactory.initElements(driver, this);
}

@FindBy(id = "first_name")
private WebElement txtfrstnme;

@FindBy(id = "last_name")
private WebElement txtlastnme;

@FindBy(id = "address")
private WebElement txtaddress;

@FindBy(id = "cc_num")
private WebElement txtccno;

@FindBy(id = "cc_type")
private WebElement creditcardtype;

@FindBy(id = "cc_exp_month")
private WebElement expirydate;

@FindBy(id = "cc_exp_year")
private WebElement expirydatee;

@FindBy(id = "cc_cvv")
private WebElement txtcvv;

@FindBy(id = "book_now")
private WebElement btnbook;

public WebElement getTxtfrstnme() {
	return txtfrstnme;
}

public WebElement getTxtlastnme() {
	return txtlastnme;
}

public WebElement getTxtaddress() {
	return txtaddress;
}

public WebElement getTxtccno() {
	return txtccno;
}

public WebElement getCreditcardtype() {
	return creditcardtype;
}

public WebElement getExpirydate() {
	return expirydate;
}

public WebElement getExpirydatee() {
	return expirydatee;
}

public WebElement getTxtcvv() {
	return txtcvv;
}

public WebElement getBtnbook() {
	return btnbook;
}
}


