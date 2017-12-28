package com.Selenium.stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Selenium.utils.Base;
import com.Selenium.utils.ReusuableMethods;

import cucumber.api.java.en.*;

public class ContextMenu extends Base{
	@Given("^Navigate to \"([^\"]*)\" page$")
	public void navigate_to_page(String url) throws Throwable {
		driver.get(url);
	}

	@Then("^Verify if \"([^\"]*)\" and \"([^\"]*)\" links are displayed$")
	public void verify_if_and_links_are_displayed(String arg1, String arg2) throws Throwable {
	   assertTrue(driver.findElement(By.xpath("//a[text()='"+arg1+"']")).isDisplayed());
	   assertTrue(driver.findElement(By.xpath("//a[text()='"+arg2+"']")).isDisplayed());
	}
	

	@Then("^Verify if the following link \"([^\"]*)\" are displayed$")
	public void verify_if_the_following_link_are_displayed(String text) throws Throwable {
	   assertTrue(driver.findElement(By.xpath("//a[contains(text(),'"+text+"')]")).isDisplayed());
	}
	
	@Given("^Right Click on Right Click Me element$")
	public void right_Click_on_Right_Click_Me_element() throws Throwable {
		WebElement rightClick=driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions act=new Actions(driver);
		act.contextClick(rightClick).perform();
	}

	@Then("^Verify that there are six elements on menu$")
	public void verify_that_there_are_six_elements_on_menu() throws Throwable {
		assertEquals(driver.findElements(By.xpath("//ul[@class='context-menu-list context-menu-root']/li")).size(), 7);
	}

	@Then("^Verify that all elements are displayed$")
	public void verify_that_all_elements_are_displayed(List<String> list) throws Throwable {
		for (String each : list) {
	   assertTrue(driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-"+each+"']")).isDisplayed());
		}
	}
	

@Then("^Click on EDIT menu option$")
public void click_on_EDIT_menu_option() throws Throwable {
	driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-edit']")).click();
}

@Then("^Verify that if alert is present Then Accept alert$")
public void verify_that_if_alert_is_present_Then_Accept_alert() throws Throwable {
//   WebDriverWait wait=new WebDriverWait(driver, 10);
//   	try {
//		wait.until(ExpectedConditions.alertIsPresent());
//		driver.switchTo().alert().accept();
//	} catch (Exception e) {
//		
//	}
	boolean b=ReusuableMethods.isAlertPresent();
	if(b){
		driver.switchTo().alert().accept();
		System.out.println("Alert has been accepted");
	}else{
		System.out.println("No alert is present");
	}
}

@Then("^Click on Edit by Alt\\+e$")
public void click_on_Edit_by_Alt_e() throws Throwable {
	WebElement rightClick=driver.findElement(By.xpath("//span[text()='right click me']"));
	Actions act=new Actions(driver);
	act.contextClick(rightClick).sendKeys(Keys.ALT+"e").perform();
}

@Then("^Verify that if Alert text is \"([^\"]*)\"$")
public void verify_that_if_Alert_text_is(String text) throws Throwable {
   assertEquals(driver.switchTo().alert().getText(),text);
   driver.switchTo().alert().accept();
}

@Then("^Click on \"([^\"]*)\" element$")
public void click_on_element(String link) throws Throwable {
	driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-"+link+"']")).click();;
	
}



}
