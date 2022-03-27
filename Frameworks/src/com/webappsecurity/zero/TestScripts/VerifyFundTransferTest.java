package com.webappsecurity.zero.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.webappsecurity.zero.pages.Home;
import com.webappsecurity.zero.pages.Login;
import com.webappsecurity.zero.pages.TransferFunds;
import com.webappsecurity.zero.pages.TransferFundsConfirmation;
import com.webappsecurity.zero.pages.TransferFundsVerify;

import utils.GenericMethods;

public class VerifyFundTransferTest extends Base {

	@Test
	public void verifyFundTransfer() throws IOException {
		Login lp = new Login(driver);
		Home hm = new Home(driver);
		TransferFunds tf = new TransferFunds(driver);
		TransferFundsVerify tfv = new TransferFundsVerify(driver);
		TransferFundsConfirmation tfc = new TransferFundsConfirmation(driver);
		
		String[][] data = GenericMethods.getData("D:\\Sel27Feb\\TestData.xlsx", "Sheet1");
		
		for(int i =1;i<data.length;i++) {
			lp.applicationLogin(data[i][0], data[i][1]);
			driver.navigate().back();
			hm.clickTransferFunds();
			tf.doFundTransfer(Integer.parseInt(data[i][2]),Integer.parseInt(data[i][3]),data[i][4], data[i][5]);
			tfv.clickSubmit();
			String actualMsg = tfc.getConfMsg();
			String expectedMsg = data[i][6];
			Assert.assertEquals(actualMsg, expectedMsg, "Row number is:"+i);
			tfc.logoutFromApp();
			driver.navigate().to("http://zero.webappsecurity.com/login.html");
		}
		
	}
}
