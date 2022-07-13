package com.vtiger.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
	public List<Map<String, String>> Logindata;
	public List<Map<String, String>> Leaddata;
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
	public List<Map<String, String>> readTestData(String Sheet)  {
		 Connection connection=null;
		 Recordset recordset= null;
		 List<Map<String, String>> Allmap = null;
		try {
		Fillo fillo=new Fillo();
		 connection=fillo.getConnection(System.getProperty("user.dir") + "/src/TestData/Data.xlsx");
		String strQuery="Select *from " +Sheet;
		 recordset=connection.executeQuery(strQuery);
		 List<String> lst= recordset.getFieldNames();
		 Allmap= new  ArrayList<Map<String, String>>();
		 
		while(recordset.next()){
		//System.out.println(recordset.getField("Details"));
		Map<String, String> map= new HashMap<String, String>();
		for(int i=0; i<=lst.size()-1;i++) {
			System.out.println(lst.get(i));
			map.put(lst.get(i), recordset.getField(lst.get(i)));
		}
		Allmap.add(map);
		}
		return Allmap;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
		recordset.close();
		connection.close();
		}
		return Allmap;
	}
}
