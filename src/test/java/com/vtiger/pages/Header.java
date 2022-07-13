package com.vtiger.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vtiger.common.GenericMethods;

public class Header {
  

	public WebDriver driver;
	public WebDriverWait wait; 
	public GenericMethods gm;
	
	public Header(WebDriver driver) {
		this.driver=driver;
    	PageFactory.initElements(driver, this);
    	gm=new GenericMethods(driver);
	     
}
	@FindBy(linkText ="Logout")
	WebElement lnk_Logout;
	@FindBy(linkText ="New Lead")
	WebElement lnk_NewLead;
	
	@FindBy(linkText ="My Account")
	WebElement lnk_MyAccount;
	
	@FindBy(linkText ="New Account")
	WebElement lnk_NewAccount;
	
	@FindBy(linkText ="Home")
	WebElement lnk_Home;
	
	public void clickLogout() {
		gm.clickelement( lnk_Logout);
	}
	public void clickNewLead() {
		gm.clickelement(lnk_NewLead);
	}
	
	public void clickMyAccount() {
		gm.clickelement( lnk_MyAccount);
	}
	
	public void clickNewAccount() {
		gm.clickelement(lnk_NewAccount);
	}
	
	public void clickHome() {
		gm.clickelement(lnk_Home);
	}
	
	
}