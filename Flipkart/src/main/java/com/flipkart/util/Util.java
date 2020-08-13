package com.flipkart.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.flipkart.base.TestBase_new;

public class Util extends TestBase_new{
	
	public static long PAGE_LOAD_TIMEOUT = 1000;
	public static long IMPLICIT_WAIT = 3;
	public static long EXPLICIT_WAIT = 30;
	public static String TESTDATA_SHEET_PATH =System.getProperty("user.dir")+"\\src\\main\\java\\"
								+ "com\\flipkart\\data\\TestData.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	String parentWindow_Name;
	String newWindowTitle;
	
public Object[][] getTestData(String sheetName){
		
		FileInputStream fis = null;
		File excelFile = new File(TESTDATA_SHEET_PATH);
	   // FileInputStream fis = new FileInputStream(excelFile);
	
		try{
			// file = new FileInputStream(TESTDATA_SHEET_PATH);
			 fis = new FileInputStream(excelFile);
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i = 0;i<sheet.getLastRowNum();i++){
			for(int j = 0; j<sheet.getRow(0).getLastCellNum();j++){
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}
		return data;		
	}

	/*Wait for a Element Implicitly*/
	public static void implicitWait()
	{
		driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
	}
	/*Wait for a page to be loaded*/
	public static void pageLoadWait()
	{
		driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	}

}
