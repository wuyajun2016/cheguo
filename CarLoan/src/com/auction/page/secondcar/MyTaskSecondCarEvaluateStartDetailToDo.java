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
public class MyTaskSecondCarEvaluateStartDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskSecondCarEvaluateStartDetailToDo.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	public MyTaskSecondCarEvaluateStartDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��MyTaskSecondCarEvaluateStartDetailToDo��");
	}

	//������ֳ�������ҳ��
	public void ClickSecondCarStart() {
		driver.selectFrame(By.name("iframe_8001"));
		driver.pause(1000);
		driver.click(By.id("assessment"));

	}
	//���뷢����ֳ�����-����������Ϣҳ��
	public void SecondCarBasicInfo(){
		driver.pause(1000);
		driver.selectFrame(By.name("iframe_undefined"));
		driver.pause(1000);
		int brand_random=(int)Math.rint(Math.random()*140);
		driver.selectByIndex(By.id("getBrand"), brand_random,3);
		driver.pause(3000);
		driver.selectByIndex(By.id("getCarList"), 1,3);
		driver.pause(3000);
		driver.selectByIndex(By.id("getCarModel"), 1,3);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//�������ڸ�ʽ
		driver.sendKeys(By.name("licenseDate"), df.format(new Date()));
		driver.sendKeys(By.id("kilometres"), "10000");
		driver.sendKeys(By.name("carColour"), "��ɫ");
		driver.sendKeys(By.name("carIdentifyNum"), "auto12345");
		driver.sendKeys(By.name("commercialInsuranceExpiredDate"), df.format(new Date()));
		driver.sendKeys(By.name("trafficCompulsoryInsuranceExpiredDate"), df.format(new Date()));
		driver.sendKeys(By.name("newCarPrice"), "800000");
		driver.sendKeys(By.name("secondHandCarPrice"), "700000");
		driver.sendKeys(By.name("memo"), "���ֳ�����������");
		driver.click(By.xpath("//*[@id='registeredForm']//button[@fors='1']"));
		driver.pause(1000);
		driver.click(By.id("sureOption"));
		driver.pause(1000);
		driver.selectDefaultFrame();
//		driver.click(By.xpath("//*[@id='dialogTip']//button[@class='close']"));
		
	}
	
	//���뷢����ֳ�����-Ӱ�����
	public void SecondCarImageManage(int i,int type){
		ImageManagePage imagemanage = new ImageManagePage(driver);
		imagemanage.ImageManage(i,type);
	}
	
	
	//�ύ
	public void SecondCarSubmit(String loginAccount,int type){
		driver.click(By.id("tohref"));
		driver.pause(1000);

		NextNodePopupPage nextnode = new NextNodePopupPage(driver);
		nextnode.NextNodePopup(3,loginAccount,type);
	}
	/**
	 * ������ֳ�����ҳ��
	 * @return
	 */
	public HomePage SecondCarStart(String loginAccount) {
		ClickSecondCarStart();
		SecondCarBasicInfo();
		SecondCarImageManage(4,2);
		SecondCarSubmit(loginAccount,2);
		return new HomePage(driver);
	}


}
