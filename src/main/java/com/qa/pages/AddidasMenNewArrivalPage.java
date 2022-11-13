package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class AddidasMenNewArrivalPage extends TestBase{

	Actions action = new Actions(driver);
	
	@FindBy(xpath = "//div[@data-auto-id='glass-header-bottom-desktop']/div/div/div[1]/a[1]")
	WebElement men;
	
	@FindBy(linkText = "Running Shoes")
	WebElement newarrival;
	
	@FindBy(xpath = "//button[@class='gl-modal__close']/span[1]")
	WebElement closePopUp;
	
	public AddidasMenNewArrivalPage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToNewArrival() {
		action.moveToElement(men).build().perform();
		action.moveToElement(newarrival).click().perform();
		closePopUp.click();
	}
}
