package tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import library.BaseClass;
import library.excel;
import library.xpaths;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class loginTest extends BaseClass {

	@Test(dataProvider="inputval")
	public void f(String un, String pswd) throws EncryptedDocumentException, IOException {

		driver.get(url);
		driver.findElement(By.xpath(xpaths.username)).sendKeys(un);
		driver.findElement(By.xpath(xpaths.password)).sendKeys(pswd);
		driver.findElement(By.xpath(xpaths.loginbutton)).click();

	}
	@DataProvider(name="inputval")
	public Object[][] inputdata() 
	{return excel.readexcelfordataprovider("data/positivetestdata.xlsx", "Sheet1", 2,2);
	}
	
	@BeforeMethod
	public void beforeMethod() throws IOException {
		intitialize();
	}

	@AfterMethod
	public void afterMethod() {
		teardown();
	}

}
