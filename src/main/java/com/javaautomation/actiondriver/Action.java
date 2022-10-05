package com.javaautomation.actiondriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.javaautomation.base.BaseDriver;

public class Action extends BaseDriver {

	public static void implicitWait(WebDriver driver, int time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	
	public static void fluentWait(WebDriver driver, WebElement element, int time) {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(time)).pollingEvery(Duration.ofSeconds(2)).ignoring(Exception.class);
			wait.until(ExpectedConditions.visibilityOf(element));
			element.click();
		}catch(Exception e) {
			System.out.println("Element is not visible after wait");
		}
	}
	
	public static void explicitWait(WebDriver driver, WebElement element, int time ) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void pageLoadTimeout(WebDriver driver, int time) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(time));
	}

	public static boolean isDisplayed(WebDriver driver, WebElement elem) {
		boolean f = false;
		f = elem.isDisplayed();
		if (f) {
			System.out.println("The element is Displayed");
		} else {
			System.out.println("The element is not Displayed");
		}
		return f;
	}
	
	public static boolean selectByVisibleText(WebElement element, String visibletext) {
		boolean f = false;
		try {
			Select s = new Select(element);
			s.selectByVisibleText(visibletext);
			f = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (f) {
				System.out.println("Option selected by VisibleText");
			} else {
				System.out.println("Option not selected by VisibleText");
			}
		}
	}
	
	public static boolean selectByValue(WebElement element, String value) {
		boolean f = false;
		try {
			Select s = new Select(element);
			s.selectByValue(value);
			f = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (f) {
				System.out.println("Option selected by Value");
			} else {
				System.out.println("Option not selected by Value");
			}
		}
	}
	
	public static String takeScreenshot(WebDriver driver, String filename) {
		
		String date = getCurrentTime();
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "\\Screenshots\\" + filename + "_" + date + ".png";
		
		try {
			FileUtils.copyFile(source, new File(path));
		} catch (Exception e) {
			e.getMessage();
		}
		
		// This new path for jenkins
		String newPath = "http://localhost:9090/job/selenium-java-automation-github/ws/Screenshots/" + filename + "_"
				+ date + ".png";
		return newPath;
	}
	
	public static String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}

}
