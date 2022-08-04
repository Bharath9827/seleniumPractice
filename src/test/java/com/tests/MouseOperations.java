package com.tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

import com.pages.MouseOpsPage;
import com.utility.LibraryFunctions;


public class MouseOperations extends MouseOpsPage{

	@Test(priority = 0)

	public void GoToPage() {
		driver.navigate().to(LibraryFunctions.ObjProperties.getProperty("MouseOpsUrl"));
		WaitingForPageToLoad(60);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,300)");
		String pageTitle = LibraryFunctions.driver.getTitle();
		Assert.assertEquals(pageTitle, LibraryFunctions.ObjProperties.getProperty("MouseOpsPageTitle"), "page title is not Validated");

	}

	@Test(priority = 1)
	public void ValidateDoubleClick() {
		doubleClick();
		
		Assert.assertEquals(DoubleClickValidation(), ObjProperties.getProperty("doubleClickText"));
	}
	
	@Test(priority = 3)
	public void ValidateRightClick() {
		rightClick();
		Assert.assertEquals(rightClickValidation(), ObjProperties.getProperty("rightClickMsg"));
	}
	
	@Test(priority = 2)
	public void validateNormalClick() {
		normalClick();
		Assert.assertEquals(normalClickValidation(), ObjProperties.getProperty("normalClickMsg"));
	}
	
	@Test(priority = 4)
	public void DragAndDrop() {
		driver.navigate().to(LibraryFunctions.ObjProperties.getProperty("DragAndDropURL"));
		DragAndDrop(driver.findElement(dragid), driver.findElement(dropid));
		//WebElement drag1 = driver.findElement(dragid);
		//WebElement drop1 = driver.findElement(dropid);
		//Objaction.dragAndDrop(drag1, drop1).build().perform();
		 //Actions builder = new Actions(driver);

//		 builder.dragAndDrop(drag1, drop1).perform();
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
