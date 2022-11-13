package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class PumaRegisterPage extends TestBase{
	
	@FindBy(id = "account-button")
	@CacheLookup
	WebElement accountBtn;
	
	@FindBy(xpath = "//div[@class='space-y-2']//a[2]")
	WebElement registerBtn;
	
	@FindBy(name = "firstName")
	WebElement firstName;
	
	@FindBy(name = "lastName")
	WebElement lastName;
	
	@FindBy(name = "email")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(id = "cookie-banner-close-btn")
	WebElement cookieBan;
	
	@FindBy(id = "register")
	WebElement reg;
	
	
	public PumaRegisterPage() throws IOException {
		PageFactory.initElements(driver,this);
	}

	public void clickOnRegisterHere() {
		accountBtn.click();
		registerBtn.click();
	}
	
	public void fillupRegisteration(String fName,String lName,String eml, String pwd) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		email.sendKeys(eml);
		password.sendKeys(pwd);
		cookieBan.click();
		reg.click();
	}
}
