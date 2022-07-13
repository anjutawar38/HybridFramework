package com.vtiger.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;


public class LoginTest extends BaseTest {

	
	
	@BeforeClass
	public void launchApp() {
		Logindata= readTestData("Login");
		Leaddata=  readTestData("Leads");
      LaunchBrowser();

	}
	@AfterClass
	public void tearDown() {
		CloseApp();
	}
//	@Test
//	public void validLogin() {
//		LoginPage lp= new LoginPage(driver);
//		System.out.println(lp.usernameEditable());
//		System.out.println(lp.logoDisplayed());
//		lp.login("admin", "admin", "nature");
//		LeadPage leadp= new LeadPage(driver);
//		leadp.clickNewLead();
//		leadp.creatmandatoryField("Tomm", "Harry", "Infoys");
//		leadp.clickLogout();
//	}	
	@Test
	public void validLogin() {
		LoginPage lp= new LoginPage(driver);
		
		lp.login(Logindata.get(0).get("Userid"), Logindata.get(0).get("Password"));
		
		
		
}
}
