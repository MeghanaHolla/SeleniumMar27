package com.webappsecurity.zero.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	@FindBy(id="user_login")
	private WebElement uName;
	
	@FindBy(id="user_password")
	private WebElement pass;
	
	@FindBy(name="submit")
	private WebElement login;
	
	@FindBy(css="#login_form > div.alert.alert-error")
	private WebElement errMsgBox;
	
	
	public String getErrorMsgText() {
		String errorMsgText = errMsgBox.getText();
		return errorMsgText;
	}
	public Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void applicationLogin(String loginName, String loginPassword) {
		uName.sendKeys(loginName);
		pass.sendKeys(loginPassword);
		login.click();
	}

}
