package com.tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.utility.LibraryFunctions;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class FramesTest extends  LibraryFunctions{
  @Test(priority= -1)
  public void SingleFrame() {
	  driver.navigate().to(ObjProperties.getProperty("FramesURL"));
	  driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	  String titleofFrames = driver.getTitle();
	  System.out.println("titleofFrames: "+titleofFrames);
	  Assert.assertEquals(titleofFrames,ObjProperties.getProperty("TitleOfFrames"));
	  
	  //identifying the single frame
	  driver.switchTo().frame("frame2");
	  //locating the webElement inside Frame
	  driver.findElement(By.xpath("//select[@id=\"animals\"]")).click();
	  driver.switchTo().defaultContent();
	  
  }
  
  @Test(priority = 0)
  public void validatingIframeWithInIframe() {
	  //WebElement OuterFrameElement = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
	  driver.switchTo().frame("frame1");
	  driver.findElement(By.xpath("//b[@id=\"topic\"]/following::input")).sendKeys("Hai");
	  //WebElement InnerFrameElement = driver.findElement(By.xpath("//iframe[@src='SingleFrame.html']"));
	  driver.switchTo().frame("frame3");
	  driver.findElement(By.xpath("//input[@type=\"checkbox\"]")).click();
	  driver.switchTo().defaultContent();
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
