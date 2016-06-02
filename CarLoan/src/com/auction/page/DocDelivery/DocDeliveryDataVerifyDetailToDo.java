package com.auction.page.DocDelivery;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.auction.page.NextNodePopupPage;
import com.auction.page.customermanage.CustomerManagePage;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * �ĵ�����-�������
 * @author Administrator
 *
 */
public class DocDeliveryDataVerifyDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(CustomerManagePage.class);

	public DocDeliveryDataVerifyDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��DocDeliveryDataVerifyDetailToDo��");
	}

	//�������-��Ŀ������Ϣ
	public void clickDocDeliveryDataVerifyButton() {
		driver.selectFrame(By.name("iframe_undefined"));
		driver.pause(1000);
		driver.sendKeys(By.name("opinion"), "�������ͬ��");
	}
	
	//�������-������Ϣ
	public void DocDeliveryDataVerifyAutoInfo() {
		driver.pause(1000);
		driver.click(By.xpath("//a[@href='#car']"));
		driver.pause(1000);
		driver.sendKeys(By.name("carFrameNo"),"AAASSSDD123",3);
		driver.sendKeys(By.name("carEngineNo"),"FADONGJI123",3);
		driver.sendKeys(By.name("billNo"),"FAPIAO1232423543534",3);
		driver.sendKeys(By.name("billDate"),"2016-03-07",3);
		driver.sendKeys(By.name("maxCapacity"),"AAASSSDD123",3);
		driver.pause(1000);
		driver.click(By.id("carBtnSave"));
	}
	//�����ĵ�����-�ύ
	public void DocDeliverySub(String loginAccount){
		driver.click(By.xpath("//a[@href='#basic']"));
		NextNodePopupPage nextnode = new NextNodePopupPage(driver);
		nextnode.NextNodePopup(1,loginAccount,7);
	}




	
	public HomePage DocDeliveryStart(String loginAccount) {
		clickDocDeliveryDataVerifyButton();
		DocDeliveryDataVerifyAutoInfo();
		DocDeliverySub(loginAccount);
		return new HomePage(driver);
	}

}
