package com.qa.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.PumaRegisterPage;
import com.qa.util.TestUtil;

public class PumaRegisterationTest extends TestBase{

	PumaRegisterPage puma_page_obj;
	
	public PumaRegisterationTest() throws IOException {
		super();
	}

	@BeforeMethod 
	public void setUp() throws IOException{
		initialization2();
		puma_page_obj = new PumaRegisterPage();
	}

	@Test(priority=1)
	public void validateNavigateToRegister() {
		puma_page_obj.clickOnRegisterHere();
	}
	
	@DataProvider
	public static String[][] getData() throws IOException 
	{
		String data[][] = TestUtil.getTestData();
		return data;
	}
	
	@Test(priority = 2, dataProvider = "getData")
	  public void validateRegisterartionForm(String firstName,String lastName,String email, String password) {
		puma_page_obj.clickOnRegisterHere();
		System.out.println("====================================================");
		System.out.println(firstName+"     "+lastName+"     "+"     "+email+"     "+password);
		System.out.println("====================================================");
		puma_page_obj.fillupRegisteration(firstName, lastName, email, password);
	  }
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
