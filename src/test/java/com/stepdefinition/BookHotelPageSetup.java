package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import com.base.LibGlobal;
import com.pom.BookHotel;
import com.pom.BookedItinerary;
import com.pom.BookingConfirmation;
import com.pom.LoginPage;
import com.pom.SearchHotel;
import com.pom.SelectHotel;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookHotelPageSetup extends LibGlobal {
	
	LoginPage login;
	SearchHotel sh;
	SelectHotel sel;
	BookHotel bh;
	BookingConfirmation bc;
	String testOrder;
	BookedItinerary bi;
	
	@Given("User is on Adactin page")
	public void user_is_on_Adactin_page() {
    getDriver();
    loadUrl("https://adactin.com/HotelApp/");   
	}

	@When("User enters details")
	public void user_enters_details(io.cucumber.datatable.DataTable data) throws InterruptedException {
	Thread.sleep(2000);
	login = new LoginPage();
	Map<String, String> map = data.asMap(String.class, String.class);
	type(login.getTxtusername(), map.get("Username"));
	type(login.getTxtpassword(),map.get("password"));
	
	
	}
	@When("User should click the login button")
	public void user_should_click_the_login_button() {
	btnClick(login.getBtnLogin());
	}

	@When("User enters the hotel details")
	public void user_enters_the_hotel_details(io.cucumber.datatable.DataTable data) throws InterruptedException {
	Thread.sleep(2000);
	sh = new SearchHotel();
	List<Map<String,String>> li = data.asMaps();
	SelectValueByText(sh.getLoc(),li.get(0).get("Location"));
	SelectValueByText(sh.getHotel(),li.get(0).get("Hotels"));
	SelectValueByText(sh.getRoomtype(),li.get(0).get("Room Type"));
	SelectValueByText(sh.getNumberofrooms(),li.get(0).get("Number of Rooms"));
	type(sh.getDatein(),li.get(0).get("Check In Date"));
	type(sh.getDateout(),li.get(0).get("Check Out Date"));
	SelectValueByText(sh.getAdultsperroom(),li.get(0).get("Adults per Room"));
	}
	
	@When("User should click the Search button")
	public void user_should_click_the_Search_button() {
	btnClick(sh.getBtnSearch());   
	}

	@When("User should click the radio button and then click the Continue button")
	public void user_should_click_the_radio_button_and_then_click_the_Continue_button() {
	sel = new SelectHotel();
	btnClick(sel.getBtnradio());
	btnClick(sel.getBtncontinue());   
	}

	@When("User enters the booking details")
	public void user_enters_the_booking_details(io.cucumber.datatable.DataTable data) throws Exception {
	Thread.sleep(2000);
	bh = new BookHotel();
	List<Map<String, String>> book = data.asMaps();
	type(bh.getTxtfrstnme(),book.get(0).get("First Name"));
	type(bh.getTxtlastnme(),book.get(0).get("Last Name"));
	type(bh.getTxtaddress(),book.get(0).get("Billing Address"));
	type(bh.getTxtccno(),book.get(0).get("Credit Card No."));
	SelectValueByText(bh.getCreditcardtype(),book.get(0).get("Credit Card Type"));
	SelectValueByText(bh.getExpirydate(),book.get(0).get("Expiry Date"));
	SelectValueByText(bh.getExpirydatee(),book.get(0).get("Expiry Datee"));
	type(bh.getTxtcvv(),book.get(0).get("CVV Number"));
	}		
	
	@When("User should click Book Now button")
	public void user_should_click_Book_Now_button() {
	btnClick(bh.getBtnbook()); 
	}

	@When("User confirms the booking")
	public void user_confirms_the_booking() throws InterruptedException {
	Thread.sleep(8000);
	bc = new BookingConfirmation();
	testOrder = getAttributeValue(bc.getOrderno());
	System.out.println("\n\n"+ testOrder);
	
	btnClick(bc.getBtnItinerary());
	Thread.sleep(3000);
	
	}
    @When("User cancels the booked hotel")
	public void user_cancels_the_booked_hotel() throws InterruptedException {
	Thread.sleep(2000);	
	bi = new BookedItinerary();
	driver.findElement(By.xpath("//input[@value='"+testOrder+"']/parent::td/preceding-sibling::td")).click();
    driver.findElement(By.xpath("//input[@name='cancelall']")).click();
	
	Alert a = driver.switchTo().alert();
	a.accept();
	}
	
	@Then("User will close the browser")
	public void user_will_close_the_browser() throws Exception {
    Thread.sleep(3000);
	driver.quit();   
	}
	
	}

