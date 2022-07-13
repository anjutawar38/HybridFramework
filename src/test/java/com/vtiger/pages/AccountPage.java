package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends Header {

	
	public AccountPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(name="firstname")
	WebElement tb_firstname;
}
