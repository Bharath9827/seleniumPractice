package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.utility.LibraryFunctions;

public class AlertsPage extends LibraryFunctions {
	
	public static By FirstAlertBox = By.xpath("//button[@onClick=\"jsConfirm()\"]");
	public static By FirstAlertMsg = By.xpath("//p[@id=\"result\"]");
	public static By SecondAlertBox = By.xpath("//button[@onClick=\"jsPrompt()\"]");
	public static By SecondAlertMsg = By.xpath("//p[@id=\"result\"]");

	public static void clickOnAlertBox() {
		Objaction.click(LibraryFunctions.driver.findElement(FirstAlertBox)).build().perform();
		//driver.findElement(FirstAlertBox).click();
	}

	public static String getConfirmMsg1() {
		return driver.findElement(FirstAlertMsg).getText();
	}

	public static void clickOnAlertBox2() {
		driver.findElement(SecondAlertBox).click();
	}

	public static String getConfirmMsg2() {
		return driver.findElement(SecondAlertMsg).getText();

	}
	public static void ClickElement(){
		driver.findElement(FirstAlertBox).click();
	}
}
