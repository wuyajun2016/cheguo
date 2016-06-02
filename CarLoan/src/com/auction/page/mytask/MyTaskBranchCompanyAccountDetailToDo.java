package com.auction.page.mytask;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.auction.page.NextNodePopupPage;
import com.framework.support.Win32GuiByAu3;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * �ֹ�˾���ɣ��ֹ�˾���-�ύ
 * @author Administrator
 *
 */
public class MyTaskBranchCompanyAccountDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskBranchCompanyAccountDetailToDo.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	public MyTaskBranchCompanyAccountDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��MyTaskBranchCompanyAccountDetailToDo��");
	}

	//����ֹ�˾����-������Ϣ-������Ϣ
	public void BranchCompanyAccountPayInfo(int BusinessType){
		if(BusinessType==1){
			driver.pause(1000);
			driver.selectFrame(By.name("iframe_undefined"));
			driver.click(By.id("accountSelect"));
			driver.pause(1000);
			driver.click(By.xpath("//*[@id='table_pay']/tbody/tr/td[1]/a"));
			driver.pause(1000);
			driver.sendKeys(By.name("dealerPaymentRemark"), "������Ϣ�ǶԵ�,������ͬ��");
		}else{
			driver.pause(1000);
			driver.selectFrame(By.name("iframe_undefined"));
			driver.sendKeys(By.name("collectedRemark"), "������Ϣ�ǶԵ�,������ͬ��");
		}

	} 
	
	//����ֹ�˾����-�������
	public void BranchCompanyAccountOpinion(){
		driver.pause(1000);
		driver.sendKeys(By.name("opinion"), "�ֹ�˾�������ͨ����");
	}
	
	//����ֹ�˾����-�ύ
	public void FBranchCompanyAccountSubmit(String loginAccount){
//		driver.pause(1000);
//		driver.click(By.id("btn-opinion-save"));
//		//�رյ�����ת��XXX����ʾ��
//		driver.pause(1000);
//		driver.selectDefaultFrame();
//		driver.click(By.xpath("//*[@id='dialogTip']//button[@class='close']"));
//		//�ر�ȫ��TAB
//		driver.pause(2000);
//		driver.click(By.xpath("//*[@id='page-wrapper']//button[@class='dropdown J_tabClose']"));
//		driver.pause(1000);
//		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/ul/li[3]"));
//		driver.pause(1000);
		NextNodePopupPage nextnode = new NextNodePopupPage(driver);
		nextnode.NextNodePopup(0,loginAccount,1);
	}

	/**
	 * �����ҵ�����-����-�ֹ�˾�����ύ
	 * @return
	 */
	public HomePage MyTaskPageBranchCompanyAccount(int BusinessType,String loginAccount) {
		BranchCompanyAccountPayInfo(BusinessType);
		BranchCompanyAccountOpinion();
		FBranchCompanyAccountSubmit(loginAccount);
		return new HomePage(driver);
	}


}
