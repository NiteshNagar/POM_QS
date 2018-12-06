package com.quickschool.com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.quickschool.com.utility.TestUtil;

public class TestBase {

 public static WebDriver driver;
 public static Properties prop;
 
	
 public TestBase(){
	 
	 try {
		 prop = new Properties();
		 FileInputStream ip = new FileInputStream("E:\\Workspace Photn\\com.quickschool.com\\src\\main\\java\\com\\quickschool\\com\\config\\config.properties");

		 prop.load(ip);
	 
	 }catch (FileNotFoundException e) {
		 e.printStackTrace();
	 }catch (IOException e) {
		e.printStackTrace();
	 }
}
 
 
 public static void initialize() {
	 String BrowserName = prop.getProperty("browser");
	 
	 if(BrowserName.equals("chrome")){
    	 ChromeOptions option = new ChromeOptions();
	   	 option.addArguments("--disable-notifications");
	   	 System.setProperty("webdriver.chrome.driver", "E:\\Chrome\\chromedriver.exe");
	   	 driver = new ChromeDriver(option);
	   
	 }
	 
	 else if (BrowserName.equals("firefox")) {
		 System.setProperty("webdriver.firefox.marionette","E:\\Chrome\\geckodriver.exe");
         driver = new FirefoxDriver();
	 }
	 
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME_WAIT, TimeUnit.SECONDS);
	 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITY_WAIT, TimeUnit.SECONDS);
	 
	 driver.get(prop.getProperty("url"));

	 
}
}
 

