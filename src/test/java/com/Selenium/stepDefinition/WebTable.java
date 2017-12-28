package com.Selenium.stepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Selenium.utils.Base;
import com.Selenium.utils.ExcelConnection;

import cucumber.api.java.en.*;

public class WebTable extends Base{
	String filePath="./src/test/resources/com/Selenium/dataFiles/TableVerification.xlsx";
	
	@Then("^Print all elements in the table$")
	public void print_all_elements_in_the_table() throws Throwable {
	    List<WebElement> list=driver.findElements(By.xpath("//thead/tr/th"));
	    for(WebElement each: list){
	    	System.out.println(each.getText());
	    }
	}

	@Then("^Print table body$")
	public void print_table_body() throws Throwable {
		int row=driver.findElements(By.xpath("//tbody/tr")).size();
		row: for (int i = 1; i <= row; i++) {
				int col=driver.findElements(By.xpath("//tbody/tr["+i+"]/td")).size();
			column:	for (int j = 1; j <=col; j++) {
					String text=driver.findElement(By.xpath("//tbody/tr["+i+"]/td["+j+"]")).getText();
					System.out.print(text+"       ");
				}
				System.out.println();
			}
		
	}

	@Then("^Verify headers with table headers in excel file$")
	public void verify_headers_with_table_headers_in_excel_file() throws Throwable {
		List<WebElement> list=driver.findElements(By.xpath("//thead/tr/th"));
		int col=ExcelConnection.usedColumnCount(filePath, 0);
		for (int i = 0; i < col; i++) {
			System.out.println(ExcelConnection.getStringCellValue(filePath, 0, i));
			assertEquals(ExcelConnection.getStringCellValue(filePath, 0, i),list.get(i).getText());
		}
		
		
		
	}

	@Then("^Verify body with table body in excel file$")
	public void verify_body_with_table_body_in_excel_file() throws Throwable {
		int row=driver.findElements(By.xpath("//tbody/tr")).size();
		row: for (int i = 1; i <= row; i++) {
				int col=driver.findElements(By.xpath("//tbody/tr["+i+"]/td")).size();
			column:	for (int j = 1; j <col; j++) {
					String webText=driver.findElement(By.xpath("//tbody/tr["+i+"]/td["+j+"]")).getText();
					String exceltext=ExcelConnection.getStringCellValue(filePath, i, j-1);
					assertEquals(webText, exceltext);
				}
			
			}
	}
}
