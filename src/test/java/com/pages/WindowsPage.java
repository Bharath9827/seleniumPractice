package com.pages;

import org.openqa.selenium.By;

import com.utility.LibraryFunctions;

public class WindowsPage extends LibraryFunctions{

	public static By browserWindowButton = By.xpath("//button[@id='button1']");
	public static By browserMessageButton = By.xpath("//button[@onclick='newMsgWin()']");
	public static By browserMessage = By.tagName("body");
}
