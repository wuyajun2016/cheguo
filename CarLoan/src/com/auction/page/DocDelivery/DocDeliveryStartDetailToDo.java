package com.auction.page.DocDelivery;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.auction.page.NextNodePopupPage;
import com.auction.page.customermanage.CustomerManagePage;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * �ĵ����ݷ���
 * @author Administrator
 *
 */
public class DocDeliveryStartDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(CustomerManagePage.class);

	public DocDeliveryStartDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��DocDeliveryStartDetailToDo��");
	}

	//�����ĵ�����
	public void clickDocDeliveryStartButton() {
		driver.selectFrame(By.name("iframe_4001"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='wait']/div[1]/div[2]/div[2]/table/tbody/tr[1]/td[8]/div/button"));
		driver.click(By.xpath("//*[@id='wait']//a[@class='startDocumentDelivery']"));
	}
	
	//�ĵ�����ҳ���������ֵ
	public void inputDocDelivery() {
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='collapse_0']//div[@data-title='�������ѵ�Ѻ��ͬ']"));
		driver.click(By.xpath("//*[@id='collapse_0']//div[@data-title='���������֤��']"));
		driver.click(By.xpath("//*[@id='collapse_0']//div[@data-title='���֤']"));
	}
	//�����ĵ�����-�ύ
	public void DocDeliverySub(String loginAccount){
		NextNodePopupPage nextnode = new NextNodePopupPage(driver);
		nextnode.NextNodePopup(1,loginAccount,7);
	}




	
	public HomePage DocDeliveryStart(String loginAccount) {
		clickDocDeliveryStartButton();
		inputDocDelivery();
		DocDeliverySub(loginAccount);
		return new HomePage(driver);
	}

}
