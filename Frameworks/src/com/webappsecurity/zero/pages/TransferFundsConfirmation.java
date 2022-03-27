package com.webappsecurity.zero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFundsConfirmation {

	public TransferFundsConfirmation(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#settingsBox > ul > li:nth-child(3) > a")
	private WebElement username;
	
	@FindBy(id="logout_link")
	private WebElement logout;
	
	@FindBy(css ="#transfer_funds_content > div > div > div.alert.alert-success")
	private WebElement confMsgBox;
	
	public String getConfMsg() {
		String confMsg = confMsgBox.getText();
		return confMsg;
	}
	
	public void logoutFromApp() {
		username.click();
		logout.click();
	}
}
