package com.crm.qa.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
// Object Repository

	@FindBy(xpath = "//td[contains(text(),'Amol c')]")
	WebElement userNameLable;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;

	@FindBy(xpath = "//a[contains(text(),'Deal')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;

	@FindBy(xpath = "//*[@id=\"navMenu\"]/ul/li")
	List<WebElement> navList;

	// Initializing the Page objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean isUserNameLablePresent() {
		return userNameLable.isDisplayed();
	}

	public ContactsPage clickOnContactLink() {
		contactsLink.click();
		return new ContactsPage();
	}

	public DealsPage clickOnDealLink() {
		dealsLink.click();
		return new DealsPage();
	}

	public TaskPage clickOnTaskLink() {
		tasksLink.click();
		return new TaskPage();
	}

	/**
	 * This Method returns the navigation list
	 * 
	 * @return List
	 */
	public List<String> getNavList() {
		List<String> navLableList = new ArrayList<String>();
		for (WebElement webElement : navList) {
			navLableList.add(webElement.getText());
		}
		return navLableList;
	}

}
