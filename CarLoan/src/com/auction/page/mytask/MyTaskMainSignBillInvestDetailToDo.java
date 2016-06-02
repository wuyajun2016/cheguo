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
public class MyTaskMainSignBillInvestDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskMainSignBillInvestDetailToDo.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	public MyTaskMainSignBillInvestDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��MyTaskMainSignBillInvestDetailToDo��");
	}

	//������ǩ������-�������
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
//		driver.selectDefaultFrame();
//		driver.click(By.xpath("//*[@id='dialogTip']/div/div/div[1]/button"));
//		driver.pause(1000);
//		//�ر�ȫ��TAB
//		driver.pause(1000);
//		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/button"));
//		driver.pause(1000);
//		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/ul/li[3]"));
		NextNodePopupPage nextnode = new NextNodePopupPage(driver);
		nextnode.NextNodePopup(0,loginAccount,1);
	}
	
	/**
	 * �����ҵ�����-����-��ǩ������-�ύ
	 * @return
	 */
	public HomePage MyTaskSignBillDistribution(String loginAccount) {
		MainSignBillInvestProcessOpinion();
		MainSignBillInvestImageManageEnter();
		//ѭ������Ӱ����Ƭ-��Ŀ�ĵ�
		for(int i=5;i<=12;i++){
			MainSignBillInvestImageManage(i);
		}
		//ѭ������Ӱ����Ƭ-��ǰ��������
//		for(int i=21;i<=25;i++){
//			MainSignBillInvestImageManage(i);
//		}
		MainSignBillInvestSubmit(loginAccount);
		return new HomePage(driver);
	}


}
