package com.crm.qa.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookType;

public class ExcelHelper {

	public static Object[][] getExcelData(String sheetName) {

		try {
			Object[][] obj = null;
			FileInputStream fin = new FileInputStream(
					new File(ResourceHelper.resourceHelper("\\src\\main\\java\\com\\crm\\qa\\testData\\testData.xlsx")));
			XSSFWorkbook wb = new XSSFWorkbook(fin);
			XSSFSheet sh = wb.getSheet(sheetName);
			System.out.println(wb.getSheetName(0));
			int rowCount = sh.getLastRowNum();
			//getLastRowNum() count Rownumber from 0th index , so 4 Rows will be counted as 3 Rows (0,1,2,3)
			
			System.out.println(rowCount);
			int cellCount = sh.getRow(0).getLastCellNum();
			//getLastCellNum() count exact column like index start from 1
			
			System.out.println(cellCount);

			obj = new Object[rowCount][cellCount];

			for (int i = 0; i <rowCount; i++) {

				for (int k = 0; k < cellCount; k++) {

					obj[i][k] = sh.getRow(i+1).getCell(k).toString();

				}
			}

			return obj;

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;

	}

	public static void main(String[] args) {

		Object[][] obj1 = getExcelData("Contacts");
		System.out.println(obj1.length);
	}

}
