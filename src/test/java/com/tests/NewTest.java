package com.tests;

import org.testng.annotations.Test;

import com.utility.LibraryFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest extends LibraryFunctions{


@Test(priority= -1)
  public void EnterGMOonline() {
	  driver.findElement(By.xpath("//input[@value=\"Enter GMO OnLine\"]")).click();
	  String pageTilte = driver.getTitle();
	  System.out.println("EnterGMOonline Test: "+pageTilte);
	  Assert.assertEquals(pageTilte, "OnLine Catalog");
  }
  
  @Test(priority= 0)
  public void addOrderQuantity() {
	  driver.findElement(By.xpath("//input[@name=\"QTY_SOCKS\"]")).clear();
	  driver.findElement(By.xpath("//input[@name=\"QTY_SOCKS\"]")).sendKeys("2");
	  driver.findElement(By.xpath("//input[@name=\"QTY_BOOTS\"]")).clear();
	  driver.findElement(By.xpath("//input[@name=\"QTY_BOOTS\"]")).sendKeys("2");
	  System.out.println("Order Quantity Added");
  }
  
  @Test(priority= 1)
  public void placeOrder() {
	  driver.findElement(By.xpath("//input[@name=\"bSubmit\"]")).click();
	  Assert.assertEquals(driver.getTitle(), "Place Order");
	  System.out.println("Order Placed");
  }
  
  @Test(priority= 2)
  public void validatePrices() {
	  String item1Value = driver.findElement(By.xpath("//table[@cellpadding=\"4\" and @border=\"1\"]/tbody/tr[2]/td[5]")).getText();
      float item1 = Float.parseFloat(item1Value.substring(2));
      System.out.println("Item1 value: "+item1);
      
      String item2Value = driver.findElement(By.xpath("//table[@cellpadding=\"4\" and @border=\"1\"]/tbody/tr[3]/td[5]")).getText();
      float item2 = Float.parseFloat(item2Value.substring(2));
      System.out.println("Item2 value: "+item2);
      
      String taxValue = driver.findElement(By.xpath("//table[@cellpadding=\"4\" and @border=\"1\"]/tbody/tr[5]/td[2]")).getText();
      float tax = Float.parseFloat(taxValue.substring(2));
      System.out.println("Tax value: "+tax);
      
      String shippingValue = driver.findElement(By.xpath("//table[@cellpadding=\"4\" and @border=\"1\"]/tbody/tr[6]/td[2]")).getText();
      float shipping = Float.parseFloat(shippingValue.substring(2));
      System.out.println("Shipping & Handling: "+shipping);
      
      String totalValue = driver.findElement(By.xpath("//table[@cellpadding=\"4\" and @border=\"1\"]/tbody/tr[7]/td[2]/strong")).getText();
      float total = Float.parseFloat(totalValue.substring(2));
	  
      System.out.println("Total value: "+total);
	  Assert.assertEquals(total, item1+item2+tax+shipping);
	  System.out.println("Price validations done");
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
