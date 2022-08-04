package com.tests;

import org.testng.annotations.Test;

import com.pages.AlertsPage;
import com.utility.LibraryFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class AlertsTests extends AlertsPage{
  @Test(priority= -1)
  public void GoToAlertsPage() {
	  driver.navigate().to(ObjProperties.getProperty("AlertURL"));
	  driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	  String pageTitle = driver.getTitle();
	  System.out.println("Page Title: "+pageTitle);
	  Assert.assertEquals(pageTitle,ObjProperties.getProperty("AlertsPageTitle"));
	 
  }
  
  @Test(priority=0)
  public void AlertsValidation() throws InterruptedException {
	  JavascriptExecutor js = (JavascriptExecutor) driver;
	  js.executeScript("window.scrollBy(0,500)");
	 
	  clickOnAlertBox();
	  ClickElement();
	  Alert ObjAlert1 = driver.switchTo().alert();
	  String Alert1 = ObjAlert1.getText();
	  Assert.assertEquals(Alert1, ObjProperties.getProperty("Alert1Test"), "Confirm alert is not handled properly");
	  ObjAlert1.accept();
	  String confirmMsg1 = getConfirmMsg1();
	  Assert.assertEquals(confirmMsg1, ObjProperties.getProperty("Alert1confirm"));
	  
	//dismiss alert
	  clickOnAlertBox();
	  Alert ObjAlert2 = driver.switchTo().alert();
	  String Alert2 = ObjAlert2.getText();
	  Assert.assertEquals(Alert2, ObjProperties.getProperty("Alert1Test"), "Dismiss alert is not handled properly");
	  ObjAlert2.dismiss();	  
	  String alertDismiss = getConfirmMsg1();
	  Assert.assertEquals(alertDismiss, ObjProperties.getProperty("DismissAlert"));
	  
	  //PromptBox Alert
	  clickOnAlertBox2();
	  Alert ObjAlert3 = driver.switchTo().alert();
	  ObjAlert3.sendKeys(ObjProperties.getProperty("PromptMsg"));
	  ObjAlert3.accept();
	  String PromptResultText = getConfirmMsg2();
	  Assert.assertEquals(PromptResultText, "You entered: "+ObjProperties.getProperty("PromptMsg"), "Prompt alert is not handled properly");
	  
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
  
	/*
	 * execution order : 
	 * 1. Priority (negative to 0 to positive) 
	 * 2. UpeerCase and Ascending order 
	 * 3. LowerCase and Ascending order
	 * 
	 * Note : if priority is not assigned to individual test case then testNg by
	 * default will assign 0 priority to the respective test case
	 * 
	 * 
	 */
}
