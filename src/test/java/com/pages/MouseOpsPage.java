package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.utility.LibraryFunctions;

public class MouseOpsPage extends LibraryFunctions{
	
	public static By doubleClickButton = By.xpath("//button[@id='doubleClickBtn']");
	public static By doubleClickText = By.xpath("//p[@id='doubleClickMessage']");
	public static By rightClick = By.xpath("//button[@id='rightClickBtn']");
	public static By rightClickText = By.xpath("//p[@id='rightClickMessage']");
	public static By clickButton = By.xpath("//button[@id='rightClickBtn']/following::button");
	public static By clickText = By.xpath("//p[@id='dynamicClickMessage']");
	public static By dragid = By.xpath("//div[@id='column-a']");
	public static By dropid = By.xpath("//div[@id='column-b']");
	
	public static void doubleClick() {
		Objaction.doubleClick(driver.findElement(doubleClickButton)).build().perform();
	}
	public static String DoubleClickValidation() {
		return driver.findElement(doubleClickText).getText();
	}
	
	public static void rightClick() {
		Objaction.contextClick(driver.findElement(rightClick)).build().perform();
	}
	public static String rightClickValidation() {
		return driver.findElement(rightClickText).getText();
	}
	
	public static void normalClick() {
		Objaction.click(driver.findElement(clickButton)).build().perform();
	}
	public static String normalClickValidation() {
		return driver.findElement(clickText).getText();
	}
	public static void DragAndDrop(WebElement dragid,WebElement dropid) {
		//Objaction.dragAndDrop(dragid, dropid).build().perform();
		//WebElement DragElement_Source = LibraryFunctions.driver.findElement(draggable);
		//WebElement DropElement_Destination = LibraryFunctions.driver.findElement(droppable);
		//objActions = new Actions(driver);
		//ExplicitWaitUntilElementToBeClickable(DragElement_Source);
		Objaction.clickAndHold(dragid);
		Objaction.moveToElement(dropid);
		Objaction.build().perform();
	}
}
