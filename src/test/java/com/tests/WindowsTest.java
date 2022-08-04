package com.tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pages.WindowsPage;
import com.utility.LibraryFunctions;


public class WindowsTest extends WindowsPage{
	
	public static Iterator<String> itr ;

	@Test(priority = 0)

	public void GotoWindowsPage() {
		LibraryFunctions.driver.navigate().to(LibraryFunctions.ObjProperties.getProperty("WindowUrl"));
		//LibraryFunctions.WaitingForPageToLoad(Constants.PageLoadTimeOut90Sec);
		String pageTitle = LibraryFunctions.driver.getTitle();
		System.out.println("Page Title: "+pageTitle);
		Assert.assertEquals(pageTitle, LibraryFunctions.ObjProperties.getProperty("AlertsPageTitle"),"Page Title is not Validated");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,750)");
	}

	@Test(priority = 1)
	public void ValidateNewBrowserWindow() {
		String ParentWindowHandle = LibraryFunctions.driver.getWindowHandle();
		LibraryFunctions.clickOnWebElement(driver.findElement((WindowsPage.browserWindowButton)));
		//System.out.println(driver.getTitle());
		Set<String> AllWindows = LibraryFunctions.driver.getWindowHandles();
		System.out.println(AllWindows);
		for (String IndividualWindow : AllWindows) {
			System.out.println("Inside for loop"+ IndividualWindow);
			LibraryFunctions.driver.switchTo().window(IndividualWindow);
			String Title = LibraryFunctions.driver.getTitle();
			System.out.println("Title: " + Title);
			if (Title.equals(LibraryFunctions.ObjProperties.getProperty("BrowserWindowTitle"))) {
				LibraryFunctions.driver.close();

			}
		}

		LibraryFunctions.driver.switchTo().window(ParentWindowHandle);
	}	
	
	@Test(priority = 2)
	public void ValidateNewMessageWindow() throws InterruptedException {
		String ParentWindowHandle = LibraryFunctions.driver.getWindowHandle();
		LibraryFunctions.clickElement(driver.findElement((WindowsPage.browserMessageButton)));
		waitTillPageLoaded();
		//System.out.println(driver.getTitle());
		Set<String> Windows = driver.getWindowHandles();
		System.out.println(Windows);
		for (String IndividualWindow : Windows) {
			if(!IndividualWindow.equals(ParentWindowHandle)) {
			System.out.println(IndividualWindow);
			driver.switchTo().window(IndividualWindow);
			Thread.sleep(1000);
			driver.switchTo().window(IndividualWindow);
			//String Title = LibraryFunctions.driver.getTitle();
			//System.out.println("Title: " + Title);
			//String browserContent = LibraryFunctions.driver.findElement(WindowsPage.browserMessage).getText();
			//String browserContent = driver.getPageSource();
			//WebElement ele = driver.findElement(By.xpath("//html/head/following::body"));
			//String browserContent = driver.findElement(By.tagName("body")).getText();
			//System.out.println("Message in browser: " +ele.getText());
//		    Assert.assertEquals(browserContent, ObjProperties.getProperty("WindowMessage"));
//			if(ele.getText().equals(ObjProperties.getProperty("WindowMessage"))) {
//			LibraryFunctions.driver.close();
//			}
			}
		}

		LibraryFunctions.driver.switchTo().window(ParentWindowHandle);
	}	

	

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("inside beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("inside afterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("inside beforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("inside afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("inside beforeTest");
		LibraryFunctions.LaunchBrowser();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("inside afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("inside beforeSuite");
		try {
			LibraryFunctions.ReadPropertiesFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("inside afterSuite");
	}
}
