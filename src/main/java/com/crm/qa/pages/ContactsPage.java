package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.crm.qa.base.TestBase;


public class ContactsPage extends TestBase {

	/**
	 * Define Object repository
	 */

	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactLbl;

	@FindBy(name = "cs_status")
	WebElement statusDropDown;

	@FindBy(xpath = "//input[@type='submit' and @name='cs_submit']")
	WebElement searchBtn;

	@FindBy(id = "first_name")
	WebElement firstName;

	@FindBy(id = "surname")
	WebElement lastName;

	@FindBy(name = "client_lookup")
	WebElement company;
	
	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
	
	@FindBy(name="title")
	WebElement titleDropDown;

	/**
	 * This method initialize Page Factory variable
	 */
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method verify Contact label on contact page.
	 * 
	 * @return
	 */
	public boolean verifyContactPageLabel() {
		return contactLbl.isDisplayed();
	}

	/**
	 * This Method select value from Status drop down list.
	 * 
	 * @param value
	 */

	public void selectValueFromStatus(String value) {
		Select selectStatus = new Select(statusDropDown);
		selectStatus.selectByVisibleText(value);
		//System.out.println(selectStatus.getFirstSelectedOption().getText());
		//searchBtn.click();
	}
	
	public void clickOnSearchButton()
	{
		searchBtn.click();
	}

	/**
	 * This method select contact in contact table.
	 * 
	 * @param name
	 */

	public void selectContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='" + name + "']//parent::td[@class='datalistrow']"
				+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
	}

	public boolean isContactValuePresent(String contact) {
		return driver.findElement(By.xpath("//a[text()='" + contact + "']//parent::td[@class='datalistrow']"))
				.isDisplayed();
	}

	/**
	 * This method create new contact
	 * 
	 * @param title
	 * @param ftName
	 * @param ltName
	 * @param comp
	 */
	public void createNewContact(String title, String ftName, String ltName, String comp) {
		Select select = new Select(titleDropDown);
		select.selectByVisibleText(title);
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(comp);
		saveBtn.click();
	}

	/**
	 *  This Method returns selected drop down value.
	 * @return String
	 */
	public String getSelectedStatusValue() {
		Select selectStatus = new Select(statusDropDown);
		return selectStatus.getFirstSelectedOption().getText();
	}
	
	
}
