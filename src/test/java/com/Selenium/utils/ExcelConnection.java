package com.Selenium.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelConnection {
	
	public static String getStringCellValue(String path, int rowNum, int cellNum) throws IOException{
		File file=new File(path);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		XSSFRow row=sheet.getRow(rowNum);
		XSSFCell cell=row.getCell(cellNum);
		return cell.getStringCellValue();
	}
	
	public static int usedColumnCount(String path, int rowNum) throws IOException{
		File file=new File(path);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		XSSFRow row=sheet.getRow(rowNum);	
		return row.getPhysicalNumberOfCells();
	}
	public static int usedRowCount(String path) throws IOException{
		File file=new File(path);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		return sheet.getPhysicalNumberOfRows();
	}

}
