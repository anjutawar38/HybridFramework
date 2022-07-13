package com.vtiger.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public Properties prop;
	public void LaunchBrowser() {
		
		readProperties();
		if(prop.getProperty("browser").equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		}
		else if(prop.getProperty("browser").equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			}
		else if(prop.getProperty("browser").equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			}
		
		
		driver.get(prop.getProperty("AppUrl"));
		driver.manage().window().maximize();
		
		
		
	}
	public void CloseApp() {
		driver.quit();
		
	}
	public void readProperties() {
	try {	
	prop =new Properties();
	FileInputStream fis= new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config/settings.properties");
	prop.load(fis);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}
	public void readTestData() throws Exception {
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection(System.getProperty("user.dir") + "/src/TestData/Data.xlsx");
		String strQuery="Select * from Sheet1 where ID=100 and name='John'";
		Recordset recordset=connection.executeQuery(strQuery);
		 
		while(recordset.next()){
		System.out.println(recordset.getField("Details"));
		}
		 
		recordset.close();
		connection.close();
	}
}
