package com.Selenium.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.Selenium.utils.Base;

public class FaceBook extends Base {
	public FaceBook(){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="firstname")  public WebElement firstname;
	@FindBy(name="lastname")  public WebElement lastname; 
	@FindBy(name="reg_email__")  public WebElement email;
	@FindBy(name="reg_passwd__")  public WebElement password;
	@FindBy(name="websubmit")  public WebElement createAccount;
	
}
