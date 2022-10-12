package com.javaautomation.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import com.javaautomation.utilities.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseDriver {
    
	public static Properties prop;
	// public static WebDriver driver;

	// Declare a static WebDriver as ThreadLocal for Parallel Execution
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	@BeforeSuite(groups = { "Sanity", "Regression", "Smoke" })
	public void loadConfig() throws IOException {
		
		ExtentManager.setExtent();
		
		String log4JFilePath = System.getProperty("user.dir") + "\\resources\\log4j.xml";
		LoggerContext loggerContext = (LoggerContext) LogManager.getContext(false);
		File file = new File(log4JFilePath);
		loggerContext.setConfigLocation(file.toURI());

		try {
			FileReader fr = new FileReader(System.getProperty("user.dir") + "\\configfiles\\Config.properties");
			prop = new Properties();
			prop.load(fr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Method to get Driver from ThreadLocal
	public static WebDriver getDriver() {
		return driver.get();
	}

//	@BeforeTest(groups = { "Sanity", "Regression", "Smoke" })
//	public void loadConfig() {
//
//		try {
//			FileReader fr = new FileReader(System.getProperty("user.dir") + "\\configfiles\\Config.properties");
//			prop = new Properties();
//			prop.load(fr);
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	public static void launchApp(String browserName) {
		// String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			// driver = new ChromeDriver();
			// Set browser to ThreadLocal
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			// driver = new EdgeDriver();
			// Set browser to ThreadLocal
			driver.set(new EdgeDriver());
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(prop.getProperty("implicitWait"))));
		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(prop.getProperty("pageLoadTimeout"))));
		//Select url from config file. Use when run project in IDE
//		getDriver().get(prop.getProperty("url"));
		//Select url from pom.xml. Use when run project in Jenkins.
		getDriver().get(System.getProperty("appURL"));

	}

	@AfterSuite(groups = { "Sanity", "Regression", "Smoke" })
	public void afterSuite() {
		ExtentManager.endReport();
	}

	public static void closeApp() {
		getDriver().quit();
	}

}
