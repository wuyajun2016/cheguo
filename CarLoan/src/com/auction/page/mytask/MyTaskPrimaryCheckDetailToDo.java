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
 * �������-�ύ
 * @author Administrator
 *
 */
public class MyTaskPrimaryCheckDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskPrimaryCheckDetailToDo.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	public MyTaskPrimaryCheckDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��MyTaskPrimaryCheckDetailToDo��");
	}

	//����������-������Ϣ
	public void PrimaryCheckApprovalInfo(){

		
	} 
	
	//����������-�������
	public void PrimaryCheckOpinion(){
		driver.pause(1000);
		driver.selectFrame(By.name("iframe_undefined"));
		driver.sendKeys(By.name("opinion"), "�������ͨ��");
	}
	
	//����������-�ύ
	public void PrimaryCheckSubmit(String loginAccount){
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
		NextNodePopupPage nextnode = new NextNodePopupPage(driver);
		nextnode.NextNodePopup(1,loginAccount,1);
	}

	//����Ӱ�����-���ͼƬ
	public void ImageManageUpload(){
		ImageManagePage imagemanage = new ImageManagePage(driver);
		imagemanage.CheckImage();
	}
	
	/**
	 * �����ҵ�����-����-��������ύ
	 * @return
	 */
	public HomePage MyTaskPagePrimaryCheck(String loginAccount) {
		PrimaryCheckOpinion();
		ImageManageUpload();
		PrimaryCheckSubmit(loginAccount);
		return new HomePage(driver);
	}


}
