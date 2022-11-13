package com.qa.pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class AddidasHomePage extends TestBase{
	
	@FindBy(xpath = "//div[@data-auto-id='main-menu']/div/a")
	WebElement menuBaritems;

	@FindBy(xpath = "//button[@data-auto-id='glass-cookie-consent-close-button']")
	WebElement pop;
	
	@FindBy(xpath = "//a[@data-auto-id='logo']")
    WebElement logo;
	
	@FindBy(xpath = "//div[@data-auto-id='main-menu']/div/a")
    List<WebElement> menuBar;
	
	@FindBy(xpath = "//button[@data-auto-id='profile-icon-header']")
	WebElement signInBtn;
	
	@FindBy(id = "login-register-auto-flow-input")
	WebElement emailAdd;
	
	@FindBy(xpath = "//button[@aria-label='Continue']")
	WebElement continueBtn;
	
	@FindBy(id = "hint-message")
	WebElement hintMsg;
	
	@FindBy(xpath = "//button[@class='gl-modal__close']")
	WebElement closeSignInBtn;
	
	@FindBy(linkText = "Help & Customer Service")
	WebElement scrollDown;
	
	@FindBy(xpath = "//div[@class='footer-main-links___1FEBm']/ul[4]//a")
	List<WebElement> footerBar; 
	
	public AddidasHomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public String getWebsiteTitle() {
		return driver.getTitle();
	}
	
	public boolean closePopoUp() {
		boolean flag2 = pop.isDisplayed();
		if(flag2)
		{
			pop.click();
		}
		return flag2;
	}
	
	public boolean validateLogo()
    {
        boolean flag3 = logo.isDisplayed();
        return flag3;
    }
	
	public int getMenuSize() {
		int menuSize = menuBar.size();
		//System.out.println("SIZE : "+menuSize);
		return menuSize;
	}
	
	public List<WebElement> printMenu() {
		return menuBar;
	}
	
	public boolean clickOnSignIn() {
		boolean flag4 = signInBtn.isDisplayed();
		if(flag4 == true) 
		{
			signInBtn.click();
		}
		return flag4;
	}
	
	public String enterEmailAddress() {
		emailAdd.sendKeys("gvashvsca");
		continueBtn.click();
		String emailErrorMessage = hintMsg.getText();
		return emailErrorMessage;
	}
	
	public boolean closSignIn() {
		boolean flag5 = closeSignInBtn.isDisplayed();
		if(flag5 == true)
		{
			closeSignInBtn.click();
		}
		return flag5;
	}
	
	public void scrollDownPage() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
	    jse.executeScript("arguments[0].scrollIntoView(true);", scrollDown);
	}
	
	public int getFooterSize() {
		int footersize = footerBar.size();
		//System.out.println("SIZE : "+footersize);
		return footersize;
	}
	
	public List<WebElement> printFooter() {
		return footerBar;
	}
}
