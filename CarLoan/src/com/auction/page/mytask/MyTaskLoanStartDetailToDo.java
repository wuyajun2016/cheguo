package com.auction.page.mytask;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.auction.page.NextNodePopupPage;
import com.framework.support.Win32GuiByAu3;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * �³������ֳ������-�ύ
 * @author Administrator
 *
 */
public class MyTaskLoanStartDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskLoanStartDetailToDo.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	public MyTaskLoanStartDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��MyTaskLoanStartDetailToDo��");
	}

	//�����ǰ����-�������󣬵����һ����¼
	public void ClickLoanReviewStart() {
		driver.selectFrame(By.name("iframe_3002"));
		driver.click(By.xpath("//*[@id='table']/tbody/tr[1]/td[10]/button"),10);
		driver.pause(1000);
	}
	//���뷢�����-ҵ����Ϣ
	public void LoanStartBusinessInfo(int i){
		driver.pageLoadSucceed();
		driver.selectFrame(By.name("iframe_undefined"),10);
		if(i==1){
			driver.selectByIndex(By.id("product"), 1);
		}else{
			driver.selectByIndex(By.id("product"), 2);
		}

		
		driver.selectByIndex(By.xpath("//*[@id='creditFormList']//select[@id='productId']"), 1);
	}
	
	
	
	/**
	 * ���뷢�����-��Ŀ������Ϣ-ѡ����
	 * @param cartype 1�³���2���ֳ�
	 */
	public void LoanStartProjectBasicInfo(int cartype,String carDealer){
		driver.pause(2000);
		//ѡ����
		if(cartype==2){
			driver.pause(1000);
			driver.selectByIndex(By.id("carType"), 1);
			driver.click(By.id("customerBtn"));
			driver.pause(1000);
			driver.click(By.xpath("//*[@id='table_5']/tbody/tr[1]/td[7]/button"));
		}else{
				driver.pause(3000);
				driver.selectByIndex(By.id("getBrand"), 1);
				driver.pause(5000);
				driver.selectByIndex(By.id("getCarList"), 3);
				driver.pause(5000);
				driver.selectByIndex(By.id("getCarModel"), 1);

			
			//�жϳ�ϵ�Ƿ�ѡ����
//			driver.pause(2000);
//			String carlist = driver.getAttribute(By.name("carMakeName"), "value");
//			System.out.println("------------------carlist:"+carlist+"---------------");
//			if(carlist.equals("--��ѡ��--")||carlist.equals("")){
//				driver.selectByIndex(By.id("getCarList"), 3,10);
//				driver.pause(1000);
//				driver.selectByIndex(By.id("getCarModel"), 1,10);
//			}
		}
		driver.pause(1000);
		driver.setRadioGroup(By.xpath("//*[@id='creditFormList']/div[3]/div[2]/div[2]/div[1]/div/label[1]/input"), "on");
		//ѡ����
		
//		driver.selectByIndex(By.id("carDealer"), 39);
		driver.selectByValue(By.id("carDealer"), carDealer);
		//��Ʊ��
		driver.sendKeys(By.name("billingPrice"), "500000");
		//������
		driver.sendKeys(By.name("loanAmount"), "200000");
		//���̷���
		driver.selectByIndex(By.id("dealerFeeId"), 1,2);
		//ѡ�����ŵ�ַ
		driver.pause(3000);
		driver.selectByIndex(By.name("visitAddressPid"), 11,10);
		driver.pause(3000);
		driver.selectByIndex(By.name("visitAddressCid"), 1,10);
		driver.pause(3000);
		driver.selectByIndex(By.name("visitAddressRid"), 5,10);
		//�ж����ŵ�ַ�Ƿ�ѡ����
//		driver.pause(2000);
//		String address = driver.getAttribute(By.name("visitAddressCname"), "value");
//		System.out.println("------------------address:"+address+"---------------");
//		if(address.equals("--��ѡ��--")||address.equals("")){
//			driver.selectByIndex(By.name("visitAddressCid"), 1,10);
//			driver.pause(1000);
//			driver.selectByIndex(By.name("visitAddressRid"), 5,10);
//		}
		driver.sendKeys(By.name("visitAddressDetail"), "��Ϫ����");
		driver.pause(1000);
		driver.click(By.id("getPos"));
		driver.pause(1000);
	    //�ڵ�ͼ���һ�ѡ��λ��
		driver.rightClick(By.className("BMap_mask"));
		driver.pause(2000);
		driver.click(By.xpath("//*[@id='map']/div[4]/div/span"));
		driver.pause(3000);
	} 

	//�ύ
	public void LoanStartSubmit(String loginAccount){
//		driver.click(By.id("submit"));
//		driver.pause(2000);
//		driver.setRadioGroup(By.xpath("//*[@id='table_3']/tbody/tr[4]/td[1]/input"), "on");
//		driver.pause(1000);
//		driver.click(By.xpath("//*[@id='task']/div/div/div[3]/div/button[1]"));
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
		nextnode.NextNodePopup(3,loginAccount,1);
	}
	/**
	 * �����ҵ�����-����-���ֳ������ҳ��
	 * @return
	 */
	public HomePage MyTaskPageStartCredit(int i,String loginAccount,int cartype,String carDealer) {
		ClickLoanReviewStart();
		LoanStartBusinessInfo(i);
		LoanStartProjectBasicInfo(cartype,carDealer);
		LoanStartSubmit(loginAccount);
		return new HomePage(driver);
	}


}
