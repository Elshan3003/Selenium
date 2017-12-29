package com.Selenium.stepDefinition;

import com.Selenium.pages.FaceBook;
import com.Selenium.utils.Base;
import com.Selenium.utils.DBConnection;
import com.Selenium.utils.ReusuableMethods;

import cucumber.api.java.en.*;

public class DataBaseFB extends Base{
	FaceBook fb=new FaceBook();
	
	@Given("^Navigate to facebook homepage$")
	public void navigate_to_facebook_homepage() throws Throwable {
		driver.get("https://www.facebook.com/");
	}

	@Then("^Enter First and Last name$")
	public void enter_First_and_Last_name() throws Throwable {
		String fsql="Select first_name from 4stay_test.users where last_name='Hart'";
		String lsql="Select last_name from 4stay_test.users where first_name='Megan'";
		String fname=DBConnection.getSingleString(fsql);
		String lname=DBConnection.getSingleString(lsql);
		fb.firstname.sendKeys(fname);
    	fb.lastname.sendKeys(lname);
	}
	@Then("^Insert email and Password$")
	public void insert_email_and_Password() throws Throwable {
		String emailSql="Select email from 4stay_test.users where first_name='Megan'";
		String email=DBConnection.getSingleString(emailSql);
	    	fb.email.sendKeys(email);
	    		}

	@Then("^Generate a random password and insert password box$")
	public void generate_a_random_password_and_insert_password_box() throws Throwable {
		String password=ReusuableMethods.generateRandomPassword();
			fb.password.sendKeys(password);

	}

	@Then("^Click on Create Account button$")
	public void click_on_Create_Account_button() throws Throwable {
		fb.createAccount.click();
	}
}
