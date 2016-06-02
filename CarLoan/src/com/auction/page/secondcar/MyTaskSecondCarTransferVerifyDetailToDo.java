package com.auction.page.secondcar;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.auction.page.ImageManagePage;
import com.auction.page.NextNodePopupPage;
import com.framework.support.Win32GuiByAu3;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * ���ֳ���������-�ύ
 * @author Administrator
 *
 */
public class MyTaskSecondCarTransferVerifyDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskSecondCarTransferVerifyDetailToDo.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	public MyTaskSecondCarTransferVerifyDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��MyTaskSecondCarTransferVerifyDetailToDo��");
	}

	
	//������ֳ���������-�������
	public void SecondCarTransferVerifyOpinion(){
		driver.pause(1000);
		driver.selectFrame(By.name("iframe_undefined"));
		driver.click(By.xpath("//*[@id='registeredForm']//input[@value='1']"));
		driver.sendKeys(By.id("opinion"), "���������������OK");
	}
	
	//���뷢���ֳ���������-Ӱ�����
	public void SecondCarTransferVerifyImageManage(int i,int type){
		ImageManagePage imagemanage = new ImageManagePage(driver);
		imagemanage.ImageManage(i,type);
	}
	
	
	//���ֳ����������ύ
	public void SecondCarTransferVerifySubmit(String loginAccount,int type){
		driver.click(By.id("tohref"));
		driver.pause(1000);
		NextNodePopupPage nextnode = new NextNodePopupPage(driver);
		nextnode.NextNodePopup(3,loginAccount,type);
	}
	/**
	 * ������ֳ���������ҳ��
	 * @return
	 */
	public HomePage SecondCarTransferVerifySubmit(String loginAccount) {
		SecondCarTransferVerifyOpinion();
		SecondCarTransferVerifyImageManage(6,2);
		SecondCarTransferVerifySubmit(loginAccount,5);
		return new HomePage(driver);
	}


}
