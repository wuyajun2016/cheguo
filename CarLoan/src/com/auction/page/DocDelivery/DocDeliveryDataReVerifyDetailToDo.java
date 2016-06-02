package com.auction.page.DocDelivery;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.auction.page.NextNodePopupPage;
import com.auction.page.customermanage.CustomerManagePage;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * �ĵ�����-���ϸ���
 * @author Administrator
 *
 */
public class DocDeliveryDataReVerifyDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(CustomerManagePage.class);

	public DocDeliveryDataReVerifyDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��DocDeliveryDataReVerifyDetailToDo��");
	}

	//�������-��Ŀ������Ϣ
	public void clickDocDeliveryContractCopyButton() {
		driver.selectFrame(By.name("iframe_undefined"));
		driver.pause(1000);
		driver.sendKeys(By.name("opinion"), "���ϸ���ͬ��");
	}
	
	//�������-������Ϣ
	public void DocDeliveryDataReVerifyAutoInfo() {
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
	
	public void DocDeliveryEnterAllTab(){
		driver.click(By.xpath("//a[@href='#policyInfo']"));
		driver.pause(2000);
		driver.click(By.xpath("//a[@href='#cumterInfo']"));
		driver.pause(1000);
		driver.jsExecutor("window.scrollTo(0, document.body.scrollHeight)");
		driver.pause(2000);
		driver.click(By.xpath("//a[@href='#budget']"));
		driver.pause(1000);
		driver.jsExecutor("window.scrollTo(0, document.body.scrollHeight)");
		driver.pause(2000);
		driver.click(By.xpath("//a[@href='#document']"));
		driver.pause(2000);
		driver.click(By.xpath("//a[@href='#counter']"));
		driver.pause(2000);
		driver.click(By.xpath("//a[@href='#process']"));
		driver.pause(2000);
	}
	
	//�����ĵ�����-�ύ
	public void DocDeliverySub(String loginAccount){
		driver.click(By.xpath("//a[@href='#basic']"));
		NextNodePopupPage nextnode = new NextNodePopupPage(driver);
		nextnode.NextNodePopup(1,loginAccount,7);
	}




	
	public HomePage DocDeliveryDataReVerify(String loginAccount) {
		clickDocDeliveryContractCopyButton();
		DocDeliveryDataReVerifyAutoInfo();
		DocDeliveryEnterAllTab();
		DocDeliverySub(loginAccount);
		return new HomePage(driver);
	}

}
