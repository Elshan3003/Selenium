package com.Selenium.stepDefinition;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import com.Selenium.utils.Base;
import com.Selenium.utils.ReusuableMethods;

import cucumber.api.java.en.*;

public class AlertTest extends Base{
	@Then("^Click on \"([^\"]*)\" button$")
	public void click_on_button(String arg1) throws Throwable {
		driver.findElement(By.xpath("//input[@value='Show alert box']")).click();
	}

	@Then("^If alert is appeared, accept it$")
	public void if_alert_is_appeared_accept_it() throws Throwable {
	 	if(ReusuableMethods.isAlertPresent()){
	 		driver.switchTo().alert().accept();
	 	}else{
	 		System.out.println("No alert found");
	 	}
	}

	@Then("^Click on  first Try it button$")
	public void click_on_first_Try_it_button() throws Throwable {
	    driver.findElement(By.id("confirm")).click();
	}

	@Then("^if Alert is present , dismiss it$")
	public void if_Alert_is_present_dismiss_it() throws Throwable {
		if(ReusuableMethods.isAlertPresent()){
	 		driver.switchTo().alert().dismiss();;
	 	}else{
	 		System.out.println("No alert found");
	 	}
	}

	@Then("^Verify if \"([^\"]*)\" text is displayed$")
	public void verify_if_text_is_displayed(String text) throws Throwable {
		assertTrue(driver.findElement(By.xpath("//*[text()='"+text+"']")).isDisplayed());
	}

	@Then("^Click on  second Try it button$")
	public void click_on_second_Try_it_button() throws Throwable {
		driver.findElement(By.id("prompt")).click();
	}

	@Then("^if Alert is present , Send \"([^\"]*)\" to alertbox$")
	public void if_Alert_is_present_Send_to_alertbox(String text) throws Throwable {
		if(ReusuableMethods.isAlertPresent()){
	 		Alert alert=driver.switchTo().alert();
	 		alert.sendKeys(text);
	 		alert.accept();
	 	}else{
	 		System.out.println("No alert found");
	 	}
	}

}
