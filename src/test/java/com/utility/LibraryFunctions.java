package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibraryFunctions {

	public static Properties ObjProperties;
	public static WebDriver driver;
	public static Actions Objaction;
	public static WebDriverWait Wait;

	public static void ReadPropertiesFile() throws IOException {
		try {
			System.out.println(System.getProperty("user.dir"));
			File objFile = new File(System.getProperty("user.dir") + "//src//test//resources//config.properties");
			FileInputStream objFileInput = new FileInputStream(objFile);
			ObjProperties = new Properties();
			ObjProperties.load(objFileInput);
			System.out.println(ObjProperties.getProperty("GmoOnlineUrl"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void LaunchBrowser() {
		String browser =ObjProperties.getProperty("browser");
		switch(browser) {
		case "ie":
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			break;
		case "chrome":
			WebDriverManager.chromedriver().setup();;
			driver=new ChromeDriver();
			break;
		case "edge":
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			break;
		case "opeara":
			WebDriverManager.operadriver();
			driver=new OperaDriver();
			break;
		default :
			System.out.println("default case");
		}
		Objaction = new Actions(driver);
		driver.get(ObjProperties.getProperty("GmoOnlineUrl"));
		driver.manage().window().maximize();
	}
	
	public static void WaitingForPageToLoad(int time){
		LibraryFunctions.driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}
	
	public static void waitForClickablility(WebElement element) {
		Wait = new WebDriverWait(driver,60); 
		Wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void clickOnWebElement(WebElement element) {
		Objaction = new Actions(driver);
		waitForClickablility(element);
		Objaction.click(element).build().perform();
		element.click();
	}
	public static void clickElement(WebElement element) {
		element.click();
	}
	public static void ExplicitWaitUntilElementToBeClickable(WebElement element){
		Wait = new WebDriverWait(driver,60); 
		Wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitTillPageLoaded() {
		JavascriptExecutor j = (JavascriptExecutor)driver;
		if (j.executeScript("return document.readyState").toString().equals("complete")){
		   System.out.println("Page has loaded");
		}
	}

}
