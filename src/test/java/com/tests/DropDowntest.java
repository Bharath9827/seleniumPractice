package com.tests;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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

import com.pages.DropDownPage;
import com.utility.LibraryFunctions;


public class DropDowntest extends DropDownPage {
	
	public static Iterator<String> itr ;

	@Test(priority = 0)

	public void ValidateLoadingTutorialsHut() {
		driver.navigate().to(ObjProperties.getProperty("DropDownUrl"));
		LibraryFunctions.WaitingForPageToLoad(60);
		String PageTitle = LibraryFunctions.driver.getTitle();
		System.out.println("Page Title: "+PageTitle);
		Assert.assertEquals(PageTitle, LibraryFunctions.ObjProperties.getProperty("DropDownPageTitle"),"Page title is not Validated");
	}

	@Test(priority = 1)
	public void ValidateDropDownAvailable() {
		WebElement element = LibraryFunctions.driver.findElement(DropDown);	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		element.click();
		Select objSelect = new Select(element);
		objSelect.selectByValue("Argentina");
		List<WebElement>AllDropDownItems = objSelect.getOptions();
		System.out.println("number of drop down values:"+AllDropDownItems.size());
		for(int i=0;i<AllDropDownItems.size();i++) {
			System.out.println(AllDropDownItems.get(i).getText());
		}
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
