package com.Selenium.stepDefinition;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;

import com.Selenium.utils.Base;

import cucumber.api.java.en.*;

public class NestedFrame extends Base{
	@Then("^verify that there is three nested frame in top frame$")
	public void verify_that_there_is_three_nested_frame_in_top_frame() throws Throwable {
		driver.switchTo().frame("frame-top");
		assertEquals(3, driver.findElements(By.xpath("//*[@name='frameset-middle']/frame")).size());
	}

	@Then("^go into Middle frame the return Bottom frame$")
	public void go_into_Middle_frame_the_return_Bottom_frame() throws Throwable {
	   driver.switchTo().frame("frame-middle");
	   assertEquals("MIDDLE", driver.findElement(By.id("content")).getText());
	   driver.switchTo().defaultContent();
	   driver.switchTo().frame("frame-bottom");
	   driver.switchTo().defaultContent();
	  }
	
	@Then("^From buttom frame go right frame$")
	public void from_buttom_frame_go_right_frame() throws Throwable {
		
		driver.switchTo().frame("frame-top");
	   driver.switchTo().frame("frame-middle");
	   driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-top");
	   driver.switchTo().frame("frame-right");
	}

	@Then("^go into Right frame then go to the left frame$")
	public void go_into_Right_frame_then_go_to_the_left_frame() throws Throwable {
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-right");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-left");
		driver.switchTo().defaultContent();
	}

	@Then("^go into the buttom frame the return Right frame$")
	public void go_into_the_buttom_frame_the_return_Right_frame() throws Throwable {
		   driver.switchTo().frame("frame-bottom");
		   driver.switchTo().defaultContent();
		   driver.switchTo().frame("frame-top").switchTo().frame("frame-right");
		   driver.switchTo().defaultContent();
	}

}
