package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import base.Base;

public class Test_13 extends Base{
     
	
	@Test
	public void Test13() throws IOException {
		
//		1. save excel file into an file object
//		2. FileIntutStream - read file
//		3. XSSFWorkbook	//.xlsx
//		4. HSSFWorkbook //.xls
//		5. XSSFSheet - access sheet
//		6. row & cell - read
		
		
		//Access File
		File excelFile = new File(System.getProperty("user.dir") + "/src/main/java/utilites/testData.xlsx");
		FileInputStream Fis = new FileInputStream(excelFile);
		
		//Load the WorkBook
		XSSFWorkbook workBook = new XSSFWorkbook(Fis); //xlsx
		//XSSFWorkbook workBook = new XSSFWorkbook(Fis)  //xls
		
		//Access the sheet
		XSSFSheet sheet = workBook.getSheetAt(0);
		
		for(int i=1; i<=3; i++) {
			String username, mobile, password;
			
		   username = sheet.getRow(i).getCell(0).getStringCellValue();
		   System.out.println(username);
		   
		   XSSFCell cell = sheet.getRow(i).getCell(1);
		   DataFormatter format = new DataFormatter();
		   mobile = format.formatCellValue(cell);
		   System.out.println(mobile);
		   
		   password = sheet.getRow(i).getCell(2).getStringCellValue();
		   System.out.println(password);
		}
		
	}
	
	
	
	}
