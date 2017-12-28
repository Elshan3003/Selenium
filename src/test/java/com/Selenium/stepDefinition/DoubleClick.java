package com.Selenium.stepDefinition;

import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.Selenium.utils.Base;

import cucumber.api.java.en.*;

public class DoubleClick extends Base{
	@Given("^navigate to Selenium Academy homepage$")
	public void navigate_to_Selenium_Academy_homepage() throws Throwable {
			driver.get("http://www.seleniumacademy.com/cookbook/");
	}

	@Then("^Click on \"([^\"]*)\" link$")
	public void click_on_link(String link) throws Throwable {
	   driver.findElement(By.xpath("//li/a[text()='"+link+"']")).click();
	}

	@Then("^Verify if the text in colored box is \"([^\"]*)\"\\.$")
	public void verify_if_the_text_in_colored_box_is(String text) throws Throwable {  
	   assertEquals(text,  driver.findElement(By.id("message")).getText());
	}

	
	@Then("^Verify if grey box contains \"([^\"]*)\"\\.$")
	public void verify_if_grey_box_contains(String text) throws Throwable {
		   assertTrue(driver.findElement(By.id("area")).getText().contains(text));

	}

	@Then("^Verify if color of element is different before and after double click\\.$")
	public void verify_if_color_of_element_is_different_before_and_after_double_click() throws Throwable {
		String backGroundColor = driver.findElement(By.id("message")).getCssValue("background-color");
		//System.out.println(backGroundColor);
		Actions act=new Actions(driver);
		act.doubleClick(driver.findElement(By.id("message"))).perform();
		String backGroundColorafter = driver.findElement(By.id("message")).getCssValue("background-color");
		//System.out.println(backGroundColorafter);
		assertNotEquals(backGroundColor, backGroundColorafter);
	}

	@Then("^Verify that color of text \"([^\"]*)\" is red\\.$")
	public void verify_that_color_of_text_is_red(String arg1) throws Throwable {
		String color=driver.findElement(By.xpath("//span")).getAttribute("style");
		assertTrue(color.contains("red"));
	}
	
}
