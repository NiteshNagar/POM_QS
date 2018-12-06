package com.quickschool.com.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.quickschool.com.base.TestBase;
import com.quickschool.com.pages.HomePage;
import com.quickschool.com.pages.TestLoginPage;

public class LoginPageTest extends TestBase {
	TestLoginPage TestLoginPage;
	HomePage homePage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialize();
		TestLoginPage = new TestLoginPage();
	}
	
	
	@Test(priority =1)
	public void LoginTitlePageTest() {
		String title = TestLoginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Quick School - ERP");
		
	}
	
	@Test(priority =5)
	public void imgLogoTest() {
		boolean Image_flag =TestLoginPage.validateImage();
		Assert.assertTrue(Image_flag);
	}
	
	@Test(priority =2)
	public void UserenabledTest() {
		boolean Usertext_flag =TestLoginPage.UsertextEnabled();
		Assert.assertTrue(Usertext_flag);
	}
	
	@Test(priority =3)
	public void PasswordenabledTest() {
		boolean Passwordtext_flag =TestLoginPage.UsertextEnabled();
		Assert.assertTrue(Passwordtext_flag);
	}
	
	
	@Test(priority =4)
	public void LoginTest() {
		homePage = TestLoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
