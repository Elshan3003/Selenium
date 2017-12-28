package com.Selenium.stepDefinition;

import static org.junit.Assert.assertEquals;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Selenium.utils.Base;

import cucumber.api.java.en.*;

public class LinkTest extends Base{
	List<WebElement>list=driver.findElements(By.xpath("//li[@class='list-group-item']/a"));
	
	
	
	@Then("^Verify if all links are working fine$")
	public void verify_if_all_links_are_working_fine() throws Throwable {
	   for (WebElement eachLink : list) {
		   String linkURL=eachLink.getAttribute("href");
		   
		   
		   URL url=new URL(linkURL);
		   HttpURLConnection urlConnection=(HttpURLConnection)url.openConnection();
		   urlConnection.connect();
		   urlConnection.setConnectTimeout(3000);
		   	
		   	if(urlConnection.getResponseCode()==200){
		   		System.out.println("  "+urlConnection.getResponseMessage()+"    "+linkURL);
		   		assertEquals(200, urlConnection.getResponseCode());
		   	}
	}
	   
		
	}

}
