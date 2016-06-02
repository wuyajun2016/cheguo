package com.auction.page.beforeloanmanage;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.framework.webdriver.baseapi.WebdriverBaseApi;
import com.framework.webdriver.helper.WebDriverTable;

/**
 * �������Ų��ύ
 * @author Administrator
 *
 */
public class MyTaskAcceptCreditDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskAcceptCreditDetailToDo.class);
	private WebDriverTable webdrivertable;
	
	public MyTaskAcceptCreditDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��MyTaskInputCreditDetailToDo��");
	}

	//���������İ�У��
	public void bankInvestResultCheck() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
		System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
	}
	
	//���������İ�У��
	public void netInvestResultCheck() {

	}
	//����ύ��ť
	public void clickSaveButton() {
		driver.selectFrame(By.name("iframe_undefined"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='save']/span"));
		driver.pause(1000);
		driver.click(By.id("sureOption"));
		driver.pause(1000);
		driver.selectDefaultFrame();
//		driver.click(By.xpath("//*[@id='dialogTip']/div/div/div[1]/button"));
		driver.pause(3000);
		//�ر�ȫ��TAB
		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/button"));
		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/ul/li[3]"));
	}
	
	/**
	 * �����ҵ�����-����-���Ž���-�ύ
	 * @return
	 */
	public HomePage MyTaskPageStartCredit() {
		bankInvestResultCheck();
		netInvestResultCheck();
		clickSaveButton();
		return new HomePage(driver);
	}
}
