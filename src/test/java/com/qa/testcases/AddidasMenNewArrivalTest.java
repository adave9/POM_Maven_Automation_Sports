package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AddidasMenNewArrivalPage;

public class AddidasMenNewArrivalTest extends TestBase{

	public AddidasMenNewArrivalPage arrival_page_object;
	
	public AddidasMenNewArrivalTest() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException{
		initialization();
		arrival_page_object = new AddidasMenNewArrivalPage();
	}
	
	@Test(priority = 1)
	public void hovetToNewArrival() {
		arrival_page_object.navigateToNewArrival();
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
}
