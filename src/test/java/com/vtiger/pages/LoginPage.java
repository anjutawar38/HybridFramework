package com.vtiger.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.vtiger.common.GenericMethods;

public class LoginPage {
	public WebDriver driver;
	public GenericMethods gm;
    public LoginPage(WebDriver driver) {
    	
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    	gm=new GenericMethods(driver);
    }
	
	@FindBy(name ="user_name")
	WebElement txt_username;
	@FindBy(name ="user_password")
	WebElement txt_password ;
	@FindBy(name ="login_theme")
	WebElement  Login_theme;
	@FindBy(name ="Login")
	WebElement btn_login;
	@FindBy(xpath="//img[@src='include/images/vtiger-crm.gif']") 
	WebElement Logo;
	
	
	//By txt_username= By.name("user_name");
	//By txt_password = By.name("user_password");
	//By Login_theme = By.name("login_theme");
	//By btn_login= By.name("Login");
	
	public void login(String userid, String pwd, String theme) {
		usernameEditable();
		logoDisplayed();
		setusername(userid);
		setpassword(pwd);
		clickLogin(theme);		
		 
	}
	public boolean usernameEditable() {
		
		return gm.enableElement( txt_username);
		
		
	}
	public void setusername(String userid) {
		gm.enterElement(txt_username, userid);
	}
	
	public void setpassword(String pwd) {
		gm.enterElement(txt_password, pwd);
	}
	public void clickLogin(String theme) {
		 Login_theme .sendKeys(theme);
		 gm.clickelement(btn_login);
		
	}
	public boolean logoDisplayed() {
		return gm.displayElemet(Logo);
		
	}
}
