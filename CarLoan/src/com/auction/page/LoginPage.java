package com.auction.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.framework.webdriver.baseapi.WebdriverBaseApi;

public class LoginPage extends BasePage {
	private Logger logger = Logger.getLogger(LoginPage.class);

	public LoginPage(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��LoginPage��");
	}

	public void inputUserName(String userName) {
		driver.sendKeys(By.name("userName"), userName);
	}

	public void inputPassWord(String passWord) {
		driver.sendKeys(By.name("password"), passWord);
	}

	public void inputVercode(String vercode) {

	}

	public void clickLoginButton() {
		driver.click(By.id("loginBtn"));
	}

	public void login(String userName, String passWord, String vercode) {
		inputUserName(userName);
		inputPassWord(passWord);
		inputVercode(vercode);
		clickLoginButton();
	}
	


	/**
	 * ��¼�ɹ�
	 * 
	 * @param userName
	 * @param passWord
	 * @param vercode
	 * @return
	 */
	public HomePage loginOK(String userName, String passWord, String vercode) {
		login(userName, passWord, vercode);
		return new HomePage(driver);
	}
	
	
}
