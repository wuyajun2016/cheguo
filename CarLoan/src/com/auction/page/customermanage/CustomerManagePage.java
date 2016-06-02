package com.auction.page.customermanage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * �����ͻ�
 * @author Administrator
 *
 */
public class CustomerManagePage extends BasePage {
	private Logger logger = Logger.getLogger(CustomerManagePage.class);

	public CustomerManagePage(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��CustomerManagePage��");
//		vercode = getVercode("GBK");
	}

	//����ͻ�����ҳ��
	public CustomerManagePage clickCustomerManagerButton() {
		driver.click(By.xpath("//*[@id='side-menu']/li[3]/a/span[1]"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='side-menu']/li[3]/ul/li[2]/a"));
		driver.pause(1000);
		return new CustomerManagePage(driver);
	}
	
	//��������ͻ���ť
	public void clickAddCustomerButton() {
		driver.selectFrame(By.name("iframe3"), 1000);
		driver.click(By.xpath("//*[@id='add']/span"));
		driver.pause(1000);
	}
	//����ͻ�����
	public void inputCustomerName(String customerName) {
		driver.sendKeys(By.xpath("//*[@id='addUserForm']/div[1]/div/div/input"), customerName);
	}
	//ѡ��֤������
	public void chooseCustomerIdentify(int CustomerIdentifyType) {
		driver.selectByIndex(By.xpath("//*[@id='addUserForm']/div[2]/div/div/select"), CustomerIdentifyType);
	}
	//����֤������
	public void inputCustomerIdentify(String CustomerIdentify) {
		driver.sendKeys(By.xpath("//*[@id='addUserForm']/div[3]/div/div/input"), CustomerIdentify);
	}
	//�����ֻ�����
	public void inputCellPhone(String CustomerCellPhone) {
		driver.sendKeys(By.xpath("//*[@id='addUserForm']/div[4]/div/div/input"), CustomerCellPhone);
		driver.pause(1000);
	}
	//������水ť
	public void clickSaveButton() {
		driver.click(By.id("save"));
		driver.pause(1000);
	}





	//�������˿ͻ�
	public HomePage AddCustomer(String customerName, int CustomerIdentifyType, String CustomerIdentify,String CustomerCellPhone) {
		driver.pause(3000);
		clickAddCustomerButton();
		inputCustomerName(customerName);
		chooseCustomerIdentify(CustomerIdentifyType);
		inputCustomerIdentify(CustomerIdentify);
		inputCellPhone(CustomerCellPhone);
		clickSaveButton();
		return new HomePage(driver);
	}


	public HomePage loginOK(String userName, String passWord, String vercode) {
//		login(userName, passWord, vercode);
		return new HomePage(driver);
	}



	public HomePage goHomePage() {
		driver.click(By.partialLinkText("������ҳ"));
		return new HomePage(driver);
	}
}
