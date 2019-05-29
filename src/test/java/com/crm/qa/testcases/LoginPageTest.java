package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage LoginPageObj;
	HomePage homePage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		LoginPageObj = new LoginPage();
	}

	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = LoginPageObj.validateLoginPageTitle();
		String Expected="CRMPRO - CRM software for customer relationship management, sales, and support.";
		Assert.assertEquals(title, Expected);
	}

	@Test(priority=2)
	public void verifyLoginLogoTest() {
		boolean flag = LoginPageObj.validateCRMLogo();
		Assert.assertTrue(flag);
	}

	@Test(priority=3)
	public void loginTest() throws InterruptedException {
		homePage = LoginPageObj.login(prop.getProperty("username"), prop.getProperty("password"));

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
