package com.Selenium.stepDefinition;

import org.openqa.selenium.By;

import com.Selenium.utils.Base;

import cucumber.api.java.en.*;

public class FluentWait extends Base {
	@Then("^Click on \"([^\"]*)\" link in herohuapp\\.com page\\.$")
	public void click_on_link_in_herohuapp_com_page(String link) throws Throwable {
	   driver.findElement(By.xpath("//a[text()='"+link+"']")).click();
	}

	@Then("^Click on \"([^\"]*)\" link\\.$")
	public void click_on_link(String arg1) throws Throwable {
	   driver.findElement(By.xpath("//a[text()='Enabled']")).click();
	}
}
