package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.base.LibGlobal;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BookHotelPageSetup extends LibGlobal {
	
	WebDriver driver;
	

	@Given("User is on Adactin page")
	public void user_is_on_Adactin_page() {
    driver = getDriver();
    loadUrl("https://adactin.com/HotelApp/");   
	}

	@When("User enters details")
	public void user_enters_details(io.cucumber.datatable.DataTable data) throws InterruptedException {
	Thread.sleep(2000);
	List<Map<String, String>> emp = data.asMaps();
	String s1 = emp.get(0).get("username");
	String s2 = emp.get(0).get("password");
		
	WebElement txtusername = driver.findElement(By.id("username"));
	type(txtusername,s1);
	WebElement txtpassword = driver.findElement(By.id("password"));
	type(txtpassword,s2);  
	}

	@When("User should click the login button")
	public void user_should_click_the_login_button() {
	WebElement btnLogin = driver.findElement(By.id("login"));
	btnClick(btnLogin);    
	}

	@When("User enters the hotel details")
	public void user_enters_the_hotel_details(io.cucumber.datatable.DataTable data) throws InterruptedException {
	Thread.sleep(2000);
	List<Map<String, String>> det = data.asMaps();
	String s3 = det.get(0).get("Location");
	String s4 = det.get(0).get("Hotels");
	String s5 = det.get(0).get("Room Type");
	String s6 = det.get(0).get("Check In Date");
	String s7 = det.get(0).get("Check Out Date");
			
			
	WebElement loc = driver.findElement(By.id("location"));
	SelectValueByText(loc,s3);
	WebElement hotel = driver.findElement(By.id("hotels"));
	SelectValueByText(hotel,s4);
	WebElement roomtype = driver.findElement(By.id("room_type"));
	SelectValueByText(roomtype,s5);
	WebElement numberofrooms = driver.findElement(By.xpath("//select[@name='room_nos']"));
	SelectTextByIndex(numberofrooms,1);
	WebElement datein = driver.findElement(By.id("datepick_in"));
	type(datein,s6);
	WebElement dateout = driver.findElement(By.id("datepick_out"));
	type(dateout,s7);
	WebElement adultsperroom = driver.findElement(By.xpath("//select[@name='adult_room']"));
	SelectTextByIndex(adultsperroom,2);
	}    
	
	@When("User should click the Search button")
	public void user_should_click_the_Search_button() {
	WebElement btnSearch = driver.findElement(By.id("Submit"));
	btnClick(btnSearch);   
	}

	@When("User should click the radio button and then click the Continue button")
	public void user_should_click_the_radio_button_and_then_click_the_Continue_button() {
	WebElement btnradio = driver.findElement(By.id("radiobutton_0"));
	btnClick(btnradio);
	WebElement btncontinue = driver.findElement(By.id("continue"));
	btnClick(btncontinue);    
	}

	@When("User enters the booking details")
	public void user_enters_the_booking_details(io.cucumber.datatable.DataTable data) throws Exception {
	Thread.sleep(2000);
	List<Map<String, String>> book = data.asMaps();
	String s10 = book.get(0).get("First Name");
	String s11 = book.get(0).get("Last Name");
	String s12= book.get(0).get("Billing Address");
	String s13= book.get(0).get("Credit Card No.");
	String s14 = book.get(0).get("Credit Card Type");
	String s15= book.get(0).get("Expiry Date");
	String s16= book.get(0).get("Expiry Datee");
	String s17= book.get(0).get("CVV Number");
			
			
	WebElement txtfrstnme = driver.findElement(By.id("first_name"));
	type(txtfrstnme,s10);
	WebElement txtlastnme = driver.findElement(By.id("last_name"));
	type(txtlastnme,s11);
	WebElement txtaddress = driver.findElement(By.id("address"));
	type(txtaddress,s12);
	WebElement txtccno = driver.findElement(By.id("cc_num"));
	type(txtccno,s13);
	WebElement creditcardtype = driver.findElement(By.id("cc_type"));
	SelectValueByText(creditcardtype,s14);
	WebElement expirydate = driver.findElement(By.id("cc_exp_month"));
	SelectValueByText(expirydate,s15);
	WebElement expirydatee = driver.findElement(By.id("cc_exp_year"));
	SelectValueByText(expirydatee,s16);
	WebElement txtcvv = driver.findElement(By.id("cc_cvv"));
	type(txtcvv,s17);
	}

	@When("User should click Book Now button")
	public void user_should_click_Book_Now_button() {
	WebElement btnbook = driver.findElement(By.id("book_now"));
	btnClick(btnbook);   
	}

	@When("User confirms the booking")
	public void user_confirms_the_booking() throws InterruptedException {
	Thread.sleep(3000);
	WebElement order = driver.findElement(By.id("order_no"));
	String orderno= order.getAttribute("value");
	System.out.println(orderno);
	
	Thread.sleep(2000);
	WebElement btnItinerary = driver.findElement(By.id("my_itinerary"));
	btnClick(btnItinerary);
	driver.findElement(By.xpath("//input[@value ='"+ orderno +"']/parent::td/preceding-sibling::td")).click();
	driver.findElement(By.xpath("(//input[@type='submit'])[2]")).click();
	
	}

	@When("User cancels the booked hotel")
	public void user_cancels_the_booked_hotel() throws InterruptedException {
	Thread.sleep(2000);
	
	Alert a = driver.switchTo().alert();
	a.accept();
	}
	
	@Then("User will close the browser")
	public void user_will_close_the_browser() throws Exception {
	Thread.sleep(3000);
	driver.quit();   
	}
	
	
}
