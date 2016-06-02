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
 * ¼�����Ų��ύ
 * @author Administrator
 *
 */
public class MyTaskInputCreditDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskInputCreditDetailToDo.class);
	private WebDriverTable webdrivertable;
	
	public MyTaskInputCreditDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��MyTaskInputCreditDetailToDo��");
	}

	/**
	 * ��������
	 * @param maritalStatus 1����ż��2����ż
	 * @param relationship 1�й�ϵ�� 2�޹�ϵ��
	 */
	public void bankInvestResult(int maritalStatus,int relationship) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
		System.out.println(df.format(new Date()));// new Date()Ϊ��ȡ��ǰϵͳʱ��
		driver.selectFrame(By.name("iframe_undefined"));
		driver.pause(1000);
		driver.selectByIndex(By.xpath("//*[@id='creditForm']//select[@name='relavants[0].checkType']"), 1);
		driver.pause(1000);
		driver.selectByIndex(By.xpath("//*[@id='creditForm']//select[@name='relavants[0].checkResult']"), 1);
		driver.sendKeys(By.xpath("//*[@id='creditForm']//input[@name='relavants[0].checkDate']"), df.format(new Date()));
		driver.sendKeys(By.xpath("//*[@id='creditForm']//textarea[@name='relavants[0].creditRemark']"), "�������������ͨ��");
		driver.pause(1000);
		//����ż���
		if(maritalStatus==1){
			driver.selectByIndex(By.xpath("//*[@id='wife']//select[@name='relavants[1].checkType']"), 1, 1);
			driver.pause(1000);
			driver.selectByIndex(By.xpath("//*[@id='wife']//select[@name='relavants[1].checkResult']"), 1);
			driver.sendKeys(By.xpath("//*[@id='wife']//input[@name='relavants[1].checkDate']"), df.format(new Date()));
			driver.sendKeys(By.xpath("//*[@id='wife']//textarea[@name='relavants[1].creditRemark']"), "��ż��������ͨ��");
			driver.pause(1000);
		}else{
			logger.debug("û����ż");
		}
		//�й�ϵ�˺���ż���
		if(relationship==1&&maritalStatus==1){
			driver.selectByIndex(By.xpath("//*[@id='partyBox']//select[@name='relavants[2].checkType']"), 1);
			driver.selectByIndex(By.xpath("//*[@id='partyBox']//select[@name='relavants[2].checkResult']"), 1);
			driver.sendKeys(By.xpath("//*[@id='partyBox']//input[@name='relavants[2].checkDate']"), df.format(new Date()));
			driver.sendKeys(By.xpath("//*[@id='partyBox']//textarea[@name='relavants[2].creditRemark']"), "��ϵ����������ͨ��");
		}else{
			logger.debug("û�й�ϵ��");
		}
		//ֻ�й�ϵ��
		if(relationship==1&&maritalStatus!=1){
			driver.selectByIndex(By.xpath("//*[@id='partyBox']//select[@name='relavants[1].checkType']"), 1);
			driver.selectByIndex(By.xpath("//*[@id='partyBox']//select[@name='relavants[1].checkResult']"), 1);
			driver.sendKeys(By.xpath("//*[@id='partyBox']//input[@name='relavants[1].checkDate']"), df.format(new Date()));
			driver.sendKeys(By.xpath("//*[@id='partyBox']//textarea[@name='relavants[1].creditRemark']"), "��ϵ����������ͨ��");
		}else{
			logger.debug("û�й�ϵ��");
		}
	}
	
	//��������
	public void netInvestResult() {

	}
	//����ύ��ť
	public void clickSaveButton() {
		driver.click(By.xpath("//*[@id='save']/span"));
		driver.pause(1000);
		driver.click(By.id("sureOption"));
		driver.pause(1000);
		driver.selectDefaultFrame();
//		driver.click(By.xpath("//*[@id='dialogTip']/div/div/div[1]/button"));
		driver.pause(1000);
		//�ر�ȫ��TAB

		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/button"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/ul/li[3]"));
	}
	
	/**
	 * �����ҵ�����-����-����¼��-�ύ
	 * @return
	 */
	public HomePage MyTaskPageStartCredit(int maritalStatus,int relationship) {
		bankInvestResult(maritalStatus,relationship);
		netInvestResult();
		clickSaveButton();
		return new HomePage(driver);
	}
}
