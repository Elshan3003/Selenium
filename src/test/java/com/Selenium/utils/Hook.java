package com.Selenium.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {
	private static WebDriver driver;
	
	@Before
	public  void setupDriver(){
		
		switch ("chrome") {
		
		case "chrome":
			System.setProperty(Config.getProperty("chromeDriver"), Config.getProperty("chromePath"));
			if(driver==null ||((RemoteWebDriver)driver).getSessionId()==null){
			ChromeOptions cOptions=new ChromeOptions();
			    cOptions.addArguments("disable-infobars");
			 	cOptions.addArguments("test-type");
			    //cOptions.addArguments("start-maximized");
			    cOptions.addArguments("--js-flags=--expose-gc");  
			    cOptions.addArguments("--enable-precise-memory-info"); 
			    cOptions.addArguments("--disable-popup-blocking");
			    cOptions.addArguments("--disable-default-apps"); 
			    
			driver=new ChromeDriver(cOptions);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			}
			Base.driver=driver;
			break;
			
		case "firefox":
			System.setProperty(Config.getProperty("firefoxDriver"), Config.getProperty("firefoxPath"));
			if(driver==null ||((RemoteWebDriver)driver).getSessionId()==null){
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			}
			Base.driver=driver;
			break;

		
		}
		
	}
	
	@After
	public void tearDown(Scenario scenario){
		if(scenario.isFailed()){
			final byte[] screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		driver.quit();
	}

}
