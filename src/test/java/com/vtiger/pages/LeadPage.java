package com.vtiger.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LeadPage extends Header {

	public LeadPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(name="firstname")
	WebElement tb_firstname;
	
	@FindBy(name="lastname")
	WebElement tb_lastname;
	
	@FindBy(name="company")
	WebElement tb_company;
	
	@FindBy(name="button")
	WebElement tb_save;
	
	
	public void creatmandatoryField(String LastName, String Company){
		//gm.enterElement(tb_firstname, firstname);
		gm.enterElement(tb_lastname, LastName);
		gm.enterElement(tb_company, Company);
		gm.clickelement(tb_save);
	}
	
	
}
