package tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;

import library.BaseClass;
import library.excel;

public class testme extends BaseClass{
	static WebDriver driver;
	static InputStream input = null;
	static Properties prop = new Properties();

	

	
	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException {
		input = new FileInputStream("config/projectconfig.properties");
		prop.load(input);
		excel.readexcelfordataprovider("data/positivetestdata.xlsx", "Sheet1", 1, 1);
		String browser = prop.getProperty("browser");
		System.out.println(browser);
			// TODO Auto-generated method stub

	}

}
