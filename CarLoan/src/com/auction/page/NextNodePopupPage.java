package com.auction.page;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.seleniumhq.jetty7.util.log.Log;
import org.testng.Assert;

import com.auction.page.beforeloanmanage.MyTaskStartCreditDetailToDo;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * ��ת��һ�ڵ㵯����
 * @author Administrator
 *
 */
public class NextNodePopupPage extends BasePage{
	private Logger logger = Logger.getLogger(NextNodePopupPage.class);
	
	public NextNodePopupPage(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��NextNodePopupPage��");
	}

	/**
	 * ��һ�ڵ���ת������(������Լ�֮������)
	 * @param havenextnode ��ʾ�Ƿ��е�����,3�����ڵ�,4������¼��ڵ�
	 * @param type 1��ͨ���� 2���ֳ��������� 3���ֳ����� 4���ֳ����� 5���ֳ����� 6���ֳ������������� 7�ĵ����ݷ��� 8���Ϲ鵵
	 * @param loginAccount ��¼�˺���
	 */
	public void NextNodePopup(int havenextnode,String loginAccount,int type) {
		if(havenextnode==0){
			driver.pause(1000);
			driver.click(By.id("btn-opinion-save"));
			driver.pause(2000);
			driver.click(By.id("sureOption"));
			
		}
			
		else if(havenextnode==3){
			if(type==1){
				driver.click(By.id("submit"));
			}
			else if(type==2){
				driver.click(By.xpath("//*[@id='registeredForm']//button[@fors='0']"));

			}
			else if(type==3){
				driver.click(By.xpath("//*[@id='registeredForm']/div[9]/div/button[1]"));
			}else if(type==5){
				driver.click(By.xpath("//*[@id='registeredForm']/div[8]/div/button[1]"));
			}else if(type==6){
				driver.click(By.xpath("//*[@id='registeredForm']/div[13]/div/button[1]"));
			}
			else{
				driver.click(By.xpath("//*[@id='registeredForm']/div[10]/div/button[1]"));
			}
			driver.pause(1000);
			driver.click(By.id("sureOption"),5);
			driver.pause(3000);
			//�ж���û�е�����ת��
			try{
				String test1 = driver.getAttribute(By.id("task"), "style");
				driver.pause(1000);
				if(test1.contains("block")){	
					for(int j=1;j<=5;j++){
						logger.debug(loginAccount);
						System.out.println("----------------"+loginAccount+"--------------------");
						if(driver.getText(By.xpath("//*[@id='table_3']/tbody/tr["+j+"]/td[4]")).equals(loginAccount)){
							driver.setRadioGroup(By.xpath("//*[@id='table_3']/tbody/tr["+j+"]/td[1]/input"), "on");
							driver.pause(1000);
							driver.click(By.xpath("//*[@id='task']/div/div/div[3]/div/button[1]"));
							break;
						}
				}
				}else{
					logger.debug("û�е�����ת��");
				}
			}catch(Exception e){
				logger.debug(e.getMessage());
			}
			
		}
		
		else if(havenextnode==4){
			driver.pause(1000);
			driver.selectFrame(By.name("iframe_undefined"));
			driver.click(By.id("btn-opinion-save"));
			driver.pause(2000);
			driver.click(By.id("sureOption"));
			driver.pause(1000);
			String test2 = driver.getAttribute(By.id("signModal"), "style");
			if(test2.contains("block")){//*[@id="table_sign"]/tbody/tr[2]/td[4]
				for(int j=1;j<=4;j++){
					if(driver.getText(By.xpath("//*[@id='table_3']/tbody/tr["+j+"]/td[4]")).equals(loginAccount)){
						driver.setRadioGroup(By.xpath("//*[@id='table_3']/tbody/tr["+j+"]/td[1]/input"), "on");
						driver.pause(1000);
						driver.click(By.id("select-sign-btn"));
						break;
					}
			}
//			driver.setRadioGroup(By.xpath("//*[@id='table_sign']/tbody/tr[3]/td[1]/input"), "on");
//			driver.pause(1000);
//			driver.click(By.id("select-sign-btn"));
		}
		}
		else{
			try{
				driver.pause(1000);
				if(type!=7)driver.click(By.id("btn-opinion-save"));
				if(type==7||type==8)driver.click(By.id("sub"));
				driver.pause(1000);
				driver.click(By.id("sureOption"));
				driver.pause(2000);
				String test3 = driver.getAttribute(By.id("signModal"), "style");
				if(test3.contains("block")){
					for(int j=1;j<=3;j++){
						if(driver.getText(By.xpath("//*[@id='table_sign']/tbody/tr["+j+"]/td[4]")).equals(loginAccount)){
							driver.setRadioGroup(By.xpath("//*[@id='table_sign']/tbody/tr["+j+"]/td[1]/input"), "on");
							driver.pause(1000);
							driver.click(By.id("select-sign-btn"));
							break;
						}
				}
			}
			}catch(Exception e){
				logger.debug("û�е�����ת��");
			}		
		}

		
		//�رյ�����ת��XXX����ʾ��
		driver.pause(1000);
		driver.selectDefaultFrame();
//		driver.click(By.xpath("//*[@id='dialogTip']//button[@class='close']"));
		if(havenextnode!=0&&type!=4&&type!=6&&type!=8)Assert.assertTrue(driver.isTextPresent("�ɹ���ת����"+loginAccount+"��", 4));
		//�ر�ȫ��TAB
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='page-wrapper']//button[@class='dropdown J_tabClose']"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/ul/li[3]"));
		driver.pause(1000);
	}
	
	/**
	 * ��һ�ڵ���ת������(��������)
	 * 
	 */
	public void NextNodeZX(int havenextnode_zx,String loginAccount_zx){
		try{
			if(havenextnode_zx==1){
				String test4 = driver.getAttribute(By.id("task"), "style");
				if(test4.contains("block")){
					for(int k=1;k<=4;k++){
						if(driver.getText(By.xpath("//*[@id='table_3']/tbody/tr["+k+"]/td[4]")).equals(loginAccount_zx)){
							driver.pause(3000);
							driver.setRadioGroup(By.xpath("//*[@id='table_3']/tbody/tr["+k+"]/td[1]/input"), "on");
							driver.pause(1000);
							driver.click(By.xpath("//*[@id='task']/div/div/div[3]/div/button[1]/span"));
							driver.pause(1000);
							break;
						}
					}
				}

			}
			else{
				logger.debug("û�е�����ת��");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
		driver.pause(1000);
		driver.selectDefaultFrame();
		Assert.assertTrue(driver.isTextPresent("�ɹ���ת����"+loginAccount_zx+"��", 4));
//		driver.pause(2000);
//		driver.click(By.xpath("//*[@id='dialogTip']/div/div/div[1]/button"));
		driver.pause(3000);
		//�ر�ȫ��TAB
		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/button"));
		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/ul/li[3]"));
	}
	
	/**
	 * ѡ����һ�ڵ㵯����
	 * @return
	 */
	public HomePage PageOfNextNodePopup(int havenextnode,String loginAccount,int type) {
		NextNodePopup(havenextnode,loginAccount,type);
		return new HomePage(driver);
	}


}
