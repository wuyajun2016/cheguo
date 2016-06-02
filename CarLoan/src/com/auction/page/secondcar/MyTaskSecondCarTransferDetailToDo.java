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
public class MyTaskSecondCarTransferDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskSecondCarTransferDetailToDo.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	public MyTaskSecondCarTransferDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��MyTaskSecondCarTransferDetailToDo��");
	}

	//������ֳ�������ҳ��
	public void ClickSecondCarTransferStart() {
		driver.selectFrame(By.name("iframe_8002"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='table_1']/tbody/tr[1]/td[11]/button"));

	}
	//������ֳ�����-������Ϣ
	public void SecondCarTransferBasicInfo(){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
		driver.pause(1000);
		driver.selectFrame(By.name("iframe_undefined"));
		driver.pause(1000);
		driver.sendKeys(By.xpath("//*[@id='registeredForm']/div[5]/div[2]/div[1]/div[1]/div/input"), df.format(new Date()), 3);
		driver.sendKeys(By.name("transferMemo"), "��������OK", 1);
		
	}
	
	//������ֳ�����-Ӱ�����
	public void SecondCarTransferImageManage(int i,int type){
		ImageManagePage imagemanage = new ImageManagePage(driver);
		imagemanage.ImageManage(i,type);
	}
	
	
	//�ύ
	public void SecondCarTransferSubmit(String loginAccount,int type){
		driver.click(By.id("tohref"));
		driver.pause(1000);

		NextNodePopupPage nextnode = new NextNodePopupPage(driver);
		nextnode.NextNodePopup(3,loginAccount,type);
	}
	/**
	 * ������ֳ���������ҳ��
	 * @return
	 */
	public HomePage SecondCarTransferStart(String loginAccount) {
		ClickSecondCarTransferStart();
		SecondCarTransferBasicInfo();
		SecondCarTransferImageManage(4,2);
		SecondCarTransferSubmit(loginAccount,5);
		return new HomePage(driver);
	}


}
