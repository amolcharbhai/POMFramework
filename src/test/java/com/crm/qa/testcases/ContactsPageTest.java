package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage loginPageObj;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	public ContactsPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		loginPageObj = new LoginPage();
		homePage = loginPageObj.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchToFrame("mainpanel");
		contactsPage = homePage.clickOnContactLink();
	}

	@Test(priority = 1)
	public void verifyContactPageLable() {
		Assert.assertTrue(contactsPage.verifyContactPageLabel(), "Contact lable is missing on Page");
	}

	@Test(priority = 2)
	public void selectContactsTest() {
		Assert.assertTrue(contactsPage.isContactValuePresent("Samir Gulhane"),
				"Contact name is missing on contact table");
		contactsPage.selectContactsByName("Samir Gulhane");
	}

	@Test(priority = 3)
	public void selectStatusValueTest() {
		contactsPage.selectValueFromStatus("Active");
		String ActualSelectedValue = contactsPage.getSelectedStatusValue();
		System.out.println(ActualSelectedValue);
		Assert.assertEquals(ActualSelectedValue, "Active", "Dropdown values are not matcing");
		contactsPage.clickOnSearchButton();
	}

	@Test(priority = 4)
	public void createNewContactTest() {
		homePage.clickOnNewContactLink();
		contactsPage.createNewContact("Mr.", "Vilas", "Sathe", "ABC");
		homePage.clickOnContactLink();
		Assert.assertTrue(contactsPage.isContactValuePresent("Vilas Sathe"),
				"Contact name is missing in contact table");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
