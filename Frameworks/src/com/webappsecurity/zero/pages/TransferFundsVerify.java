package com.webappsecurity.zero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFundsVerify {

	public TransferFundsVerify(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="btn_submit")
	private WebElement submitBtn;
	
	public void clickSubmit() {
		submitBtn.click();
	}
}
