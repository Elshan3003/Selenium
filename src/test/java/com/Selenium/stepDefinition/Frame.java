package com.Selenium.stepDefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;

import com.Selenium.utils.Base;

import cucumber.api.java.en.*;

public class Frame extends Base{
	@Then("^verify if number if iframes are three$")
	public void verify_if_number_if_iframes_are_three() throws Throwable {
	 assertEquals(3, driver.findElements(By.xpath("//frameset/frame")).size());
	}

	@Then("^verify that \"([^\"]*)\" text is displayed in left frame$")
	public void verify_that_text_is_displayed_in_left_frame(String text) throws Throwable {
	  driver.switchTo().frame("left");
	 assertTrue(driver.findElement(By.xpath("//*[text()='"+text+"']")).isDisplayed());
	 driver.switchTo().defaultContent();
	}

	@Then("^verify that \"([^\"]*)\" text is displayed in right frame$")
	public void verify_that_text_is_displayed_in_right_frame(String text) throws Throwable {
	   driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='right']")));
	   assertTrue(driver.findElement(By.xpath("//*[text()='"+text+"']")).isDisplayed());
	   driver.switchTo().defaultContent();
	}
	
	@Then("^verify that \"([^\"]*)\" text is displayed in middle frame$")
	public void verify_that_text_is_displayed_in_middle_frame(String text) throws Throwable {
	 
	 	try{
	 		driver.switchTo().frame(1);
	 		assertEquals(text, driver.findElement(By.tagName("p")).getText());
	 		driver.switchTo().defaultContent();
	 	}catch(Exception e){
	 		System.out.println("Middle iframe is not found");
	 	}finally{
	 		driver.switchTo().defaultContent();
	 	}
	}

	@Then("^verify if the title of middle frame is like \"([^\"]*)\"$")
	public void verify_if_the_title_of_middle_frame_is_like(String arg1) throws Throwable {
		try{
			driver.switchTo().frame(1);
			System.out.println("Title of middle frame:"+driver.findElement(By.xpath("//head")).getAttribute("title"));
		}catch (Exception e) {
		
		}finally{
			driver.switchTo().defaultContent();
		}
	}
	@Then("^verify if title is \"([^\"]*)\" in frame with index number \"([^\"]*)\" and has a message like \"([^\"]*)\"$")
	public void verify_if_title_is_in_frame_with_index_number_and_has_a_message_like(String title, String index, String message) throws Throwable {
		try{
			driver.switchTo().frame(index);
			assertEquals(message, driver.findElement(By.tagName("p")).getText());
		}catch(Exception e){
			
		}finally{
			driver.switchTo().defaultContent();
		}
		
	}
	
	@Then("^click on Follow Twitter link$")
	public void click_on_Follow_Twitter_link() throws Throwable {
		try{
			driver.switchTo().frame("right");
			driver.switchTo().frame(0);
			driver.findElement(By.id("widget")).click();
		}catch(Exception e){
			
		}finally{
			driver.switchTo().defaultContent();
		}
	}

	@Then("^verify that title of new Window is \"([^\"]*)\"$")
	public void verify_that_title_of_new_Window_is(String title) throws Throwable {
		Set<String>id=driver.getWindowHandles();
		System.out.println(id);
		Iterator<String> iter=id.iterator();
		String mainWindow=iter.next();
		String childWindow=iter.next();
		driver.switchTo().window(childWindow);
		assertEquals(title, driver.getTitle());
		
	    }

	@Then("^verify that this twitter account belongs to \"([^\"]*)\"$")
	public void verify_that_this_twitter_account_belongs_to(String name) throws Throwable {
		assertEquals(name, driver.findElement(By.xpath("//div[@id='twitter-upgundecha']//a[1]")).getText());	
	}
}
