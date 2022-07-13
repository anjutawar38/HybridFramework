package com.vtiger.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;

import org.testng.annotations.Test;

public class LeadTest extends BaseTest {

	

	
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
	
	@Test
	public void creatLead() {
		LoginPage lp= new LoginPage(driver);
		lp.login(Logindata.get(0).get("Userid"), Logindata.get(0).get("Password"));
		LeadPage leadp= new LeadPage(driver);
		leadp.clickNewLead();
		leadp.creatmandatoryField( Leaddata.get(0).get("LastName"), Leaddata.get(0).get("Company"));
		leadp.clickLogout();
	}
	@Test
	public void creatLead2() {
		LoginPage lp= new LoginPage(driver);
		lp.login(Logindata.get(0).get("Userid"), Logindata.get(0).get("Password"));
		LeadPage leadp= new LeadPage(driver);
		leadp.clickNewLead();
		leadp.creatmandatoryField( Leaddata.get(1).get("LastName"), Leaddata.get(1).get("Company"));
		leadp.clickLogout();
	}

}
