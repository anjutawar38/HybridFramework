package com.vtiger.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vtiger.pages.LoginPage;

import org.testng.annotations.Test;

public class LeadTest extends BaseTest {

	

	
	@BeforeClass
	public void launchApp() {
      LaunchBrowser();

	}
	@AfterClass
	public void tearDown() {
		CloseApp();
	}
	
	@Test
	public void creatLead() {
		LoginPage lp= new LoginPage(driver);
		lp.login("admin", "admin", "blue");
		System.out.println("creatLead");
	}

}
