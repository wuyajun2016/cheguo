package com.auction.page.mytask;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.auction.page.NextNodePopupPage;
import com.framework.support.Win32GuiByAu3;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * ǩ�������ύ
 * @author Administrator
 *
 */
public class MyTaskSignBillDistributionDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskSignBillDistributionDetailToDo.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	public MyTaskSignBillDistributionDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��MyTaskSignBillDistributionDetailToDo��");
	}

	//����ǩ������-ǩ������
	public void SignBillDistribution(String CustomerManagerName,String MainSign){
		driver.pause(1000);
		driver.selectFrame(By.name("iframe_undefined"));
		//�����ǩ�������ѡ��ť
		driver.click(By.id("mainSignSelect"));
		driver.pause(2000);
		//��ǩ����������ѡ��һ����Ա
//		driver.click(By.xpath("//*[@id='table_sign_main']/tbody/tr[1]/td[1]/a"));
//		driver.pause(1000);
		
		for(int i=1;i<=10;i++){
			String name=driver.getText(By.xpath("//*[@id='table_sign_main']/tbody/tr["+i+"]/td[4]"));
			if(name.equals(MainSign)){
				driver.click(By.xpath("//*[@id='table_sign_main']/tbody/tr["+i+"]/td[1]/a"));
				break;
			}
		}
		//�����ǩ�������ѡ��ť
		driver.pause(2000);
		driver.click(By.id("viceSignSelect"));
		driver.pause(2000);
		//��ǩ����������ѡ��һ����Ա,��ѯ��zqd1
		driver.sendKeys(By.name("signName"), CustomerManagerName);
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='btn-search-qd']/span[2]"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='table_sign_vice']/tbody/tr/td[1]/a"));
	}
	
	//����ǩ������-ѡ��Ȩ��
	public void SignBillDistributionWeight(){
		driver.pause(1000);
		driver.sendKeys(By.id("mainSignerWeight"), "80");
	}
	
	//����ǩ������-�������
	public void SignBillProcessOpinion(){
		driver.pause(1000);
		driver.sendKeys(By.name("opinion"), "ǩ������ͬ��");
	} 

	//�ύ
	public void SignBillDistributionSubmit(String loginAccount){
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
	 * �����ҵ�����-����-ǩ������-�ύ
	 * @return
	 */
	public HomePage MyTaskSignBillDistribution(String loginAccount,String CustomerManagerName,String MainSign) {
		SignBillDistribution(CustomerManagerName,MainSign);
		SignBillDistributionWeight();
		SignBillProcessOpinion();
		SignBillDistributionSubmit(loginAccount);
		return new HomePage(driver);
	}


}
