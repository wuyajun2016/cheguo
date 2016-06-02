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
 * ��ǩ������
 * @author Administrator
 *
 */
public class MyTaskSecondSignBillInvestDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskSecondSignBillInvestDetailToDo.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	public MyTaskSecondSignBillInvestDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��MyTaskSecondSignBillInvestDetailToDo��");
	}

	//���븱ǩ������-�������
	public void MainSignBillInvestProcessOpinion(){
		driver.pause(1000);
		driver.selectFrame(By.name("iframe_undefined"));
		driver.sendKeys(By.name("opinion"), "ǩ������ͬ��");
	} 

	//����ǩ������-����Ӱ�����TAB
	public void MainSignBillInvestImageManageEnter(){
//		driver.click(By.xpath("/html/body/div[1]/ul/li[2]/a"));
	}
	
	//����ǩ������-Ӱ�����
	public void MainSignBillInvestImageManage(int i){
//		driver.pause(1000);
//		driver.click(By.id("tree_"+i+"_span"));
//
//		driver.click(By.xpath("//*[@id='detail']/div/div[1]/div[2]/div/div[2]/ul/li[2]/a"));
//
//		driver.click(By.xpath("//*[@id='upImage']/span"));
//
//		win32guibyau3.fileUpload("��","C:\\Users\\Public\\Pictures\\Sample Pictures\\"+i+".jpg",1);
//
//		driver.click(By.xpath("//*[@id='upload']/span"));
//		driver.pause(1000);
		ImageManagePage imagemanage = new ImageManagePage(driver);
		imagemanage.ImageManage(i,1);
	}

	//�ύ
	public void MainSignBillInvestSubmit(String loginAccount){
//		driver.click(By.id("btn-opinion-save"));
//		driver.pause(1000);
//		driver.setRadioGroup(By.xpath("//*[@id='table_sign']/tbody/tr[3]/td[1]/input"), "on");
//		driver.pause(1000);
//		driver.click(By.id("select-sign-btn"));
//		//����رյ�����ʾ�򡮳ɹ���ת��XXX��
//		driver.pause(1000);
//		driver.selectDefaultFrame();
//		driver.click(By.xpath("//*[@id='dialogTip']/div/div/div[1]/button"));
//		//�ر�ȫ��TAB
//		driver.pause(1000);
//		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/button"));
//		driver.pause(1000);
//		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/ul/li[3]"));
		NextNodePopupPage nextnode = new NextNodePopupPage(driver);
		nextnode.NextNodePopup(1,loginAccount,1);
	}
	
	/**
	 * �����ҵ�����-����-��ǩ������-�ύ
	 * @return
	 */
	public HomePage MyTaskSignBillDistribution(String loginAccount) {
		MainSignBillInvestProcessOpinion();
		MainSignBillInvestImageManageEnter();
		//ѭ������Ӱ����Ƭ
//		for(int i=5;i<=14;i++){
//			MainSignBillInvestImageManage(i);
//		}
		MainSignBillInvestSubmit(loginAccount);
		return new HomePage(driver);
	}


}
