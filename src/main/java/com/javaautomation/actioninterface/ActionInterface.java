package com.javaautomation.actioninterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public interface ActionInterface {
	
	public void implicitWait(WebDriver driver, int time);
	public void fluentWait(WebDriver driver, WebElement element, int time);
	public void explicitWait(WebDriver driver, WebElement element, int time);
	public void pageLoadTimeout(WebDriver driver, int time);
	public boolean isDisplayed(WebDriver driver, WebElement elem);
	public boolean selectByVisibleText(WebElement element, String visibletext);
	public boolean selectByValue(WebElement element, String value);
	public String takeScreenshot(WebDriver driver, String filename);
	public String getCurrentTime();
	

}
