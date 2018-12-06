package com.quickschool.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.quickschool.com.base.*;

 public class TestLoginPage extends TestBase  {

	 //https://quickschool.niitnguru.com/ABHYUDAY/WebApp/LandingPage.aspx
	 //admin_1	abhyuday1s
	  
	 
 //Page Factory - OR
	 
	 @FindBy(id = "txtUserName")
	 WebElement user_Name;
	 
	 @FindBy(id = "txtPassword")
	 WebElement Password;
	 
	 @FindBy(id = "btnLogin")
	 WebElement Login_btn;
	
	 @FindBy(id = "btnforgotpass")
	 WebElement forgotPasswordButton;
	 
	 @FindBy(xpath = "//img[contains(.,'School Logo')]")
	 WebElement img_Logo;
	 
	 //Initializing the Object 
	 public TestLoginPage() {
	
		 PageFactory.initElements(driver, this); //Initialize page factory, This means current class object.
	 }
	 
	 //Actions
	 public String validateLoginPageTitle() {
		 return driver.getTitle();
	}
	 
	 public boolean validateImage() {
		 return img_Logo.isDisplayed();
		 
	}
	 
	 public boolean UsertextEnabled() {
		 return user_Name.isEnabled();
	 }	 
	 
	 public boolean PasswordTextEnabled() {
		 return Password.isEnabled();
	 }	 
	 
	 public HomePage login(String un, String pswd) {
		 user_Name.sendKeys(un);
		 Password.sendKeys(pswd);
		 Login_btn.click();
		 
		 return new HomePage();
	 }
	 
	 
	
}
