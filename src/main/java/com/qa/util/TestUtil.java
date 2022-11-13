package com.qa.util;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public TestUtil() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;	
		
	public static String[][] getTestData() throws IOException {

		File excelFile =new File("C:\\Selenium_WorkSpace\\POM_SportsWebsite_TestNG_Project\\src\\main\\java\\com\\qa\\data\\AddidasRegisterationData.xlsx");
		
		FileInputStream fis = new FileInputStream(excelFile);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		
		XSSFSheet sheet = workbook.getSheet("RegisterationData");
				
		int noOfRows = sheet.getPhysicalNumberOfRows();
		int noOfCol = sheet.getRow(0).getLastCellNum();
		
		System.out.println("Number of Row    : "+noOfRows);
		System.out.println("Number of Column : "+noOfCol);
		
		String[][] data = new String[noOfRows-1][noOfCol];
		
		for(int i =1 ; i<noOfRows ; i++) {
			for(int j= 0; j<noOfCol ; j++) {
				data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		return data;
	}
	
	public static void takeScreenshotAtEndOfTest() throws IOException{
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
	}
}
