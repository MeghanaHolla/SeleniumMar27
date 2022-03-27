package com.webappsecurity.zero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {

	@FindBy(id = "transfer_funds_link")
	private WebElement transferFunds;
	
	public Home(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickTransferFunds() {
		transferFunds.click();
	}
	
	public boolean isTransferFundsPresent() {
		return transferFunds.isDisplayed();
	}
}
