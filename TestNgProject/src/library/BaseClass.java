package library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public WebDriver driver;
	public FileInputStream input;
	public Properties property;
	public String testtype;
	public String password;
	public String browser;
	public String url;

	public void intitialize() {
		try {
			input = new FileInputStream("config/projectconfig.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		property = new Properties();
		try {
			property.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		testtype = property.getProperty("testtype");
		password = property.getProperty("password");
		browser = property.getProperty("browser");
		url = property.getProperty("url");
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();

		}
		else if(browser.equals("firefox"))
		{			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
	     driver = new FirefoxDriver(); 
		}
	}

	public void teardown() {
		driver.close();
		try {
			input.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
