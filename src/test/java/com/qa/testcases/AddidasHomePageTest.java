package com.qa.testcases;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AddidasHomePage;

public class AddidasHomePageTest extends TestBase{
  
	public AddidasHomePage addidas_page_obj;
	
	public AddidasHomePageTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException{
		initialization();
		addidas_page_obj = new AddidasHomePage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = addidas_page_obj.getWebsiteTitle();
		System.out.println(title);
		Assert.assertEquals(title, "adidas Official Website | adidas Canada");
	}
	
	@Test(priority=2)
	public void isPopUpDisplayed() {
		boolean pop_closed = addidas_page_obj.closePopoUp();
		Assert.assertTrue(pop_closed, "PopUp does not close !");
	}
	
	@Test(priority=3)
    public void validateLogo()
    {
        boolean lg = addidas_page_obj.validateLogo();
        System.out.println(lg);
        Assert.assertTrue(lg, "Logo Mismatch !");
    }
	
	@Test(priority=4)
	public void validateMenuSize() {
		int menuSize = addidas_page_obj.getMenuSize();
		Assert.assertTrue(menuSize<10, "Menu Size is more then 10 !");
	}
	
	@Test(priority=5)
	public void getMenuItems() {
		for(WebElement wb : addidas_page_obj.printMenu()) {
			System.out.println(wb.getText());
		}
	}
	
	@Test(priority=6)
	public void validateSignInBtn() {
		boolean signIn = addidas_page_obj.clickOnSignIn();
		Assert.assertTrue(signIn,"SignIn Button Click Failed !");
	}
	
	@Test(priority=7)
	public void validateSignIn() {
		String actualEmailError = addidas_page_obj.enterEmailAddress();
		String expected_Error = "The email address is invalid.";
		Assert.assertTrue(expected_Error.equals(actualEmailError),"Email error message Mismatch !");
	}
	
	@Test(priority=8)
	public void validateCloseSIgnIn() {
		boolean closeSignIn = addidas_page_obj.closSignIn();
		Assert.assertTrue(closeSignIn, "SignIn PopUp Cannot be closed !");
	}
	@Test(priority=9)
	public void scrollDown_AddidasPage() {
		addidas_page_obj.scrollDownPage();
	}
	
	@Test(priority=10)
	public void validateFooterSize() {
		int footerSize = addidas_page_obj.getFooterSize();
		Assert.assertTrue(footerSize<15, "Footer Size is more then 15 !");
	}

	@Test(priority=11)
	public void getFooterItems() {
		for(WebElement fwb : addidas_page_obj.printFooter()) {
			System.out.println(fwb.getText());
		}
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
