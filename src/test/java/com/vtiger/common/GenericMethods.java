package com.vtiger.common;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericMethods {

	
	public WebDriver driver;
	public WebDriverWait wait; 
	
	
	public GenericMethods(WebDriver driver) {
		this.driver=driver;
	     wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
	}
	public void enterElement(WebElement elm, String valu) {
		
		wait.until(ExpectedConditions.visibilityOf(elm));
		elm.isEnabled();
		elm.clear();
		elm.sendKeys(valu);
		
	
	}
public void clickelement(WebElement elm) {
		
		wait.until(ExpectedConditions.elementToBeClickable(elm));
		elm.click();
}
public boolean displayElemet(WebElement elm) {
	
	try {
		wait.until(ExpectedConditions.visibilityOf(elm));
		return elm.isDisplayed();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}
public boolean enableElement(WebElement elm) {
	
	try {
		wait.until(ExpectedConditions.visibilityOf(elm));
		return elm.isEnabled();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return false;
	}
}
}