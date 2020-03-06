package com.base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LibGlobal {
public static WebDriver driver;
    
    public WebDriver getDriver() {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shatabdi\\eclipse-workspace\\Cucumberproject\\drivers\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    screenShot();
    return driver;
    }
    public void loadUrl(String url) {
    driver.get(url);
    screenShot();
    }
    public void type(WebElement element,String name) {
    element.sendKeys(name);
    screenShot();
    }
    public void btnClick(WebElement element) {
    element.click();
    screenShot();
    try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
    }
    public void SelectValueByText(WebElement element,String name) {
    new Select(element).selectByVisibleText(name);
    screenShot();
    }
    
    public void SelectTextByIndex(WebElement element,int index) {
    new Select(element).selectByIndex(index);
    screenShot();
    }
    public String getAttributeValue(WebElement element) {
    return element.getAttribute("value");
    	
    }
    public String generateDate() {
    return new SimpleDateFormat("dd_mm_yyyy_hhmmss").format(new Date());
    }
    
	public void screenShot() {
    File s = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    
    File destloc = new File("C:\\Users\\Shatabdi\\eclipse-workspace\\Cucumberpom\\Screenshots\\" + generateDate() + ".png");
    try {
    FileUtils.copyFile(s, destloc);
    }
    catch(IOException e) {
    e.printStackTrace();
    }
    }
    public void quitBrowser() throws Exception {
    	Thread.sleep(10000);
    driver.quit();
    }	
}
