package com.auction.page.beforeloanmanage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.auction.page.NextNodePopupPage;
import com.framework.support.Win32GuiByAu3;
import com.framework.webdriver.baseapi.WebdriverBaseApi;
import com.framework.webdriver.helper.WebDriverTable;

/**
 * �������Ų��ύ
 * @author Administrator
 *
 */
public class MyTaskStartCreditDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskStartCreditDetailToDo.class);
	private WebDriverTable webdrivertable;
	
	public MyTaskStartCreditDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��MyTaskStartCreditDetailToDo��");
	}

	//������ѡ��һ����ת��Ա���ȷ����ť�ύ����һ��
	public void submitToNextNode(String loginAccount_zx) {
//		driver.pause(3000);
//		driver.setRadioGroup(By.xpath("//*[@id='table_3']/tbody/tr[3]/td[1]/input"), "on");
//		driver.pause(1000);
//		driver.click(By.xpath("//*[@id='task']/div/div/div[3]/div/button[1]/span"));
//		driver.pause(1000);
//		driver.selectDefaultFrame();
//		driver.click(By.xpath("//*[@id='dialogTip']/div/div/div[1]/button"));
//		driver.pause(3000);
//		//�ر�ȫ��TAB
//		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/button"));
//		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/ul/li[3]"));
		NextNodePopupPage nextnode = new NextNodePopupPage(driver);
		nextnode.NextNodeZX(1,loginAccount_zx);
	}
	
	//����ύ��ť
	public void clickSaveButton() {
		driver.selectFrame(By.name("iframe_undefined"));
		driver.click(By.xpath("//*[@id='save']/span"));
		driver.pause(1000);
		driver.click(By.id("sureOption"));
		driver.pause(3000);
	}
	//�ҵ�����-���������İ�У��
	public void checkContent(String nextNode) {
		boolean isSucceed = false;
		String nextnode = driver.getText(By.id("nextFlowNodeName"));
		if(nextnode.equals(nextNode)){
			isSucceed = true;
		}else{
			logger.debug("�ҵ�����-���ŷ���-�İ�У��ʧ��");
			Assert.assertTrue(isSucceed);
		}
	}
	
	/**
	 * �����ҵ�����-����-���ſ�ʼ-�ύ
	 * @return
	 */
	public HomePage MyTaskPageStartCredit(String nextNode,String loginAccount_zx) {
		clickSaveButton();
//		checkContent(nextNode);
		submitToNextNode(loginAccount_zx);
		return new HomePage(driver);
	}
}
