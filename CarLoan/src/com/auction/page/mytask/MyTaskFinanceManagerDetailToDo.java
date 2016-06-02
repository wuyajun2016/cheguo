package com.auction.page.mytask;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.auction.page.NextNodePopupPage;
import com.framework.support.Win32GuiByAu3;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * �������ܣ��������룩-�ύ
 * @author Administrator
 *
 */
public class MyTaskFinanceManagerDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskFinanceManagerDetailToDo.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	public MyTaskFinanceManagerDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��MyTaskFinanceManagerDetailToDo��");
	}

	//�����������-������Ϣ-�տ�����Ϣ
	public void FinanceManagerPayee(int BusinessType){
		driver.pause(1000);
		driver.selectFrame(By.name("iframe_undefined"));
		if(BusinessType==1){
			driver.click(By.id("accountSelect"));
			driver.pause(1000);
			driver.click(By.xpath("//*[@id='table_pay']/tbody/tr[1]/td[1]/a"));
		}else{
			logger.debug("�ֹ�˾��������������ֱ������");
		}

		
	} 
	
	//�����������-�������
	public void FinanceManagerOpinion(){
		driver.pause(1000);
		driver.sendKeys(By.name("opinion"), "�����������ͨ����");
	}
	
	//�����������-�ύ
	public void FinanceManagerSubmit(String loginAccount){
//		driver.pause(1000);
//		driver.click(By.id("btn-opinion-save"));
//		driver.pause(2000);
//		driver.setRadioGroup(By.xpath("//*[@id='table_sign']/tbody/tr[3]/td[1]/input"), "on");
//		driver.pause(1000);
//		driver.click(By.id("select-sign-btn"));
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
		nextnode.NextNodePopup(1,loginAccount,1);
	}

	/**
	 * �����ҵ�����-����-���������ύ
	 * @return
	 */
	public HomePage MyTaskPageFinanceManager(int BusinessType,String loginAccount) {
		FinanceManagerPayee(BusinessType);
		FinanceManagerOpinion();
		FinanceManagerSubmit(loginAccount);
		return new HomePage(driver);
	}


}
