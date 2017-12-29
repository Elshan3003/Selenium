package com.Selenium.utils;


import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusuableMethods extends Base{
	
	public static boolean isAlertPresent(){
	    boolean foundAlert = false;
	    WebDriverWait wait = new WebDriverWait(driver, 5 );
	    try {
	        wait.until(ExpectedConditions.alertIsPresent());
	        foundAlert = true;
	    } catch (TimeoutException eTO) {
	        foundAlert = false;
	    }
	    return foundAlert;
	}
	
	
	public static String generateRandomPassword(){

		String[] arr={"A", "B", "a", "b","C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O",
				"P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",  "c", "d", "e", "f", "g", "h", "i",
				"j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
				"1","2","3","4","5","6","7","8","9","0"};
		
		List<String>list=Arrays.asList(arr);	
		Random r=new Random();
			
		String password="";
		for (int i = 0; i < 18; i++) {
			int a=r.nextInt(list.size());
			password=password+list.get(a);
		}
		System.out.println(password);
		
		
		return password;
	}
	
	
	   
}
