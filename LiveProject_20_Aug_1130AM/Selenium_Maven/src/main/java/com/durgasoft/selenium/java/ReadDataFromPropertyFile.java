package com.durgasoft.selenium.java;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ReadDataFromPropertyFile {

	public static final String path = "./hms.properties";
	
	public static String getData(String key) throws Exception {
		File f = new File(path);
		Properties p = new Properties();
		FileInputStream fi = new FileInputStream(f);
		p.load(fi);
		return p.getProperty(key);
	}
	public static void main(String[] args) throws Exception {
		System.out.println(getData("browser"));
		WebDriver driver = new FirefoxDriver();
		driver.get(getData("prodURL"));
		driver.manage().window().maximize();
		driver.findElement(By.name(getData("usernameLoc"))).sendKeys(getData("userName"));
		driver.findElement(By.name(getData("passwordLoc"))).sendKeys(getData("password"));
		//driver.findElement(By.name(getData("loginLoc"))).click();
		driver.findElement(By.name(getData("passwordLoc"))).sendKeys(Keys.ENTER);
		
	}
}


