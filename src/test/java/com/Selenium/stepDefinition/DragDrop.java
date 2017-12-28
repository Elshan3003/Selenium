package com.Selenium.stepDefinition;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Selenium.utils.Base;

import cucumber.api.java.en.*;

public class DragDrop extends Base{
	@Then("^verify if \"([^\"]*)\" is displayed$")
	public void verify_if_is_displayed(String text) throws Throwable {
		assertTrue(driver.findElement(By.xpath("//*[text()='"+text+"']")).isDisplayed());
	}

	@Then("^drag source element to target$")
	public void drag_source_element_to_target() throws Throwable {
	 Actions act=new Actions(driver);
	 WebElement source=driver.findElement(By.id("draggable"));
	 WebElement target=driver.findElement(By.id("droppable"));
	 act.dragAndDrop(source, target).perform();
	}

	@Then("^verify if \"([^\"]*)\" is displayed, after the element dropped$")
	public void verify_if_is_displayed_after_the_element_dropped(String text) throws Throwable {
		assertTrue(driver.findElement(By.xpath("//*[text()='"+text+"']")).isDisplayed());
	}

}
