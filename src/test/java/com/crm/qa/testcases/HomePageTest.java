package com.crm.qa.testcases;

import static org.testng.Assert.assertTrue;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;
import com.google.common.collect.ImmutableList;

public class HomePageTest extends TestBase {
	LoginPage LoginPageObj;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() throws InterruptedException {
		initialization();
		testUtil = new TestUtil();
		contactsPage = new ContactsPage();
		LoginPageObj = new LoginPage();
		homePage = LoginPageObj.login(prop.getProperty("username"), prop.getProperty("password"));
	}

		@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "CRMPRO", "Home Page Title is not matched");
	}

	@Test(priority = 2)
	public void verifyUsernameTest() {
		testUtil.switchToFrame("mainpanel");
		assertTrue(homePage.isUserNameLablePresent(), "username is wrong on Homepage");
	}

	@Test(priority = 3)
	public void verifyContactLink() {
		testUtil.switchToFrame("mainpanel");
		contactsPage = homePage.clickOnContactLink();
	}

	@Test(priority = 4)
	public void successfulTest() {
		testUtil.switchToFrame("mainpanel");
		List<String> expectedLabelsList = ImmutableList.of("no company loaded", "Add Boxes»", "«Shortlist",
				"Quick Create»", "Pipeline", "Timeline", "Alerts", "Messages", "Custom Views", "Schedule Call",
				"Call List", "Mail Accounts", "Products", "Promotions", "Resources", "Knowledge Base", "Team View",
				"Import", "Export", "Sales Targets", "Preferences", "Audit Trail", "Blog");
	//	System.out.println(homePage.getNavList());
		Assert.assertEquals(homePage.getNavList(), expectedLabelsList);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
