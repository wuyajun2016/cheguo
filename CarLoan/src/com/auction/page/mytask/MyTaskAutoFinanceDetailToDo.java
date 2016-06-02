package com.auction.page.mytask;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.auction.page.ImageManagePage;
import com.auction.page.NextNodePopupPage;
import com.framework.support.Win32GuiByAu3;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * �������ڲ�-�ύ
 * @author Administrator
 *
 */
public class MyTaskAutoFinanceDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskAutoFinanceDetailToDo.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	public MyTaskAutoFinanceDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��MyTaskAutoFinanceDetailToDo��");
	}

	//�����������ڲ�-������Ϣ
	public void AutoFinanceApprovalInfo(){

		
	} 
	
	//�����������ڲ�-�������
	public void AutoFinanceOpinion(){
		driver.pause(1000);
		driver.selectFrame(By.name("iframe_undefined"));
		driver.setRadioGroup(By.xpath("//*[@id='opinionForm']//input[@name='isConcernedCustomer']"), "on"); //�Ƿ��ע�ͻ�
		driver.setRadioGroup(By.xpath("//*[@id='opinionForm']//input[@name='isAgency']"), "on"); //�Ƿ����
		driver.setRadioGroup(By.xpath("//*[@id='opinionForm']//input[@name='isGpsInstalled1']"), "on"); //����˾�涨��װGPS
		driver.setRadioGroup(By.xpath("//*[@id='opinionForm']//input[@name='isGpsInstalled2']"), "on"); //�����й涨��װGPS
		driver.pause(1000);
		driver.sendKeys(By.name("opinion"), "�������ڲ�ͨ��");
	}
	
	//����Ӱ�����-���ͼƬ
	public void ImageManageUpload(){
		ImageManagePage imagemanage = new ImageManagePage(driver);
		imagemanage.CheckImage();
	}
	
	//�����������ڲ�-�ύ
	public void AutoFinanceSubmit(String loginAccount){
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
		nextnode.NextNodePopup(1,loginAccount,1);
		
	}

	/**
	 * �����ҵ�����-����-�������ڲ��ύ
	 * @return
	 */
	public HomePage MyTaskPageAutoFinance(String loginAccount) {
		AutoFinanceOpinion();
		ImageManageUpload();
		AutoFinanceSubmit(loginAccount);
		return new HomePage(driver);
	}


}
