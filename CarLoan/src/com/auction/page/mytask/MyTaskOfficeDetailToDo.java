package com.auction.page.mytask;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.seleniumhq.jetty7.util.log.Log;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.auction.page.ImageManagePage;
import com.auction.page.NextNodePopupPage;
import com.framework.support.Win32GuiByAu3;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * ����¼��(ҵ��¼��)
 * @author Administrator
 *
 */
public class MyTaskOfficeDetailToDo extends BasePage{
	private Logger logger = Logger.getLogger(MyTaskOfficeDetailToDo.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	public MyTaskOfficeDetailToDo(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ������¼��_MyTaskOfficeDetailToDo��");
	}

	//����ҵ��¼��-������Ϣ-�������Ϣ
	public void OfficeBasicInfoBorrower(){
		driver.pause(1000);
		driver.selectFrame(By.name("iframe_undefined"));
		driver.sendKeys(By.name("homePhone"), "021-6222122");
		driver.sendKeys(By.name("nativePlace"), "����");
		driver.selectByIndex(By.name("education"), 4);
		driver.selectByIndex(By.name("housingStatus"), 1);
		driver.sendKeys(By.name("profession"), "������Թ���ʦ");
		driver.selectByIndex(By.name("industry"), 7);
		driver.selectByIndex(By.name("monthlyIncome"), 2);
		driver.sendKeys(By.name("companyName"), "��������Ƽ����޹�˾");
		driver.sendKeys(By.name("companyPhone"), "0577-6222122");
		driver.selectByIndex(By.name("reservedFunds"), 2);
		//���뵥λ��ַ
		driver.pause(1000);
		driver.selectByIndex(By.name("companyAddressPid"), 11,3);
		driver.pause(5000);
		driver.selectByIndex(By.name("companyAddressCid"), 1,3);
		driver.pause(5000);
		driver.selectByIndex(By.name("companyAddressRid"), 5,3);
		driver.sendKeys(By.name("companyAddressDetail"), "��ϼ���峣��·11��502��");
		//�����ͥ��ַ
		driver.pause(1000);
		driver.selectByIndex(By.name("homeAddressPid"), 11,3);
		driver.pause(5000);
		driver.selectByIndex(By.name("homeAddressCid"), 3,3);
		driver.pause(5000);
		driver.selectByIndex(By.name("homeAddressRid"), 11,3);
		driver.sendKeys(By.name("homeAddressDetail"), "���ӱ�·11Ū1��");
		driver.pause(1000);

//		driver.selectDefaultFrame();
//		driver.click(By.xpath("//*[@id='dialogTip']//button[@class='close']"));
	} 
	
	//����ҵ��¼��-������Ϣ-�������Ϣ-��ż
	public void OfficeBasicInfoBorrowerWife(int maritalstatus){
		if(maritalstatus==1){
			driver.sendKeys(By.name("spouseMobilePhone"), "13222211122");
			driver.sendKeys(By.name("spousePermantAddress"), "����");
			driver.selectByIndex(By.name("spouseReservedFunds"), 2);
			driver.sendKeys(By.name("spouseCompanyName"), "������ѧ");
			driver.sendKeys(By.name("spouseCompanyPhone"), "0571-85465324");
			driver.selectByIndex(By.name("spouseCompanyAddressPid"), 11,3);
			driver.pause(2000);
			driver.selectByIndex(By.name("spouseCompanyAddressCid"), 1,3);
			driver.pause(2000);
			driver.selectByIndex(By.name("spouseCompanyAddressRid"), 5,3);
			driver.pause(1000);
			driver.sendKeys(By.name("spouseCompanyAddress"), "����һ��11��10-2");
			driver.selectByIndex(By.name("spouseMonthlyIncome"), 2);
		}else{
			logger.debug("û����ż����ִ��");
		}
		//������������Ϣ
		driver.click(By.id("btn-baseInfo-save"));
		//�ر���ʾ��
		driver.pause(1000);
		
	} 
	
	//����ҵ��¼��-������Ϣ-������ϵ��
	public void OfficeBasicInfoCtriticalContacts(String name,int relationship,String phone,int usecar,String address){
		driver.pause(3000);
		driver.selectFrame(By.name("iframe_undefined"));
		driver.click(By.id("btn-contacter-add"),20);
		driver.pause(1000);
		driver.sendKeys(By.name("emergencyContact"), name);
		driver.selectByIndex(By.name("relationship"), relationship);
		driver.sendKeys(By.xpath("//*[@id='contacterForm']//input[@name='mobilePhone']"), phone);
		driver.pause(1000);
		driver.selectByIndex(By.name("isCarUser"), usecar);
		driver.pause(1000);
		driver.sendKeys(By.name("contactAddress"), address);
		driver.pause(1000);
		//�������
		driver.click(By.id("btn-contacter-save"));
	} 
	
	//����ҵ��¼��-������Ϣ-�������
	public void OfficeBasicInfoOpinion(){
		driver.pause(1000);
		driver.sendKeys(By.name("opinion"), "����¼��ͬ��");
	} 

	//Ԥ�㵥
	public void Budget(int businessType){
		//����Ԥ�㵥tab
		driver.click(By.xpath("//a[@href='#budget']"));
		//���������Ϣ
		driver.selectByIndex(By.id("isPublicLicense"), 1);
		driver.sendKeys(By.id("licenseCompany"), "�㽭����������޹�˾");
		driver.selectByIndex(By.id("paymentMethod"), 1);  //ȫ����
		
		
		/**
		 * ���������Ϣ
		 */
		//GPS
		driver.selectByIndex(By.id("gpsNumber"), 1);
		//��һ�걣��
		driver.selectByIndex(By.id("premiumType"), 1);
		//��һ�걣��-���
		driver.sendKeys(By.id("insuranceAmount"), "100");
		//���չ�˾
		driver.selectByIndex(By.id("insurance"), 1);
		//�ϻ�Ѻ��
		driver.sendKeys(By.id("accountDeposit"), "100.36");
		//�Ƿ�����
		driver.selectByIndex(By.id("isRenewal"), 1);
		//����Ѻ��
//		driver.sendKeys(By.id("renewalDeposit"), "100.36");
		//��Լ��֤��
		driver.sendKeys(By.id("pbDeposit"), "100");
		//Ԥ�Ƴ�������˰
		driver.selectByIndex(By.id("predictedPurchasetax"), 1);
		
		if(businessType==1){
			//Ԥ�Ƴ�������˰-���
			driver.sendKeys(By.id("purchaseTax"), "100");
			//�ᳵ��ʽ
			driver.selectByIndex(By.name("deliveryMethod"), 1);
			//����ȼ�
			driver.selectByIndex(By.name("paymentLevel"), 1);
			//���㷽ʽ
			driver.selectByIndex(By.name("settleMethod"), 1);
//			String totalfee = driver.getAttribute(By.id("totalFee"), "value"); //��ȡ���úϼ�
//			driver.sendKeys(By.id("collectedAmount"), totalfee);
		}else{
			logger.info("������ֱ��");
		}

		
		//�������Ԥ�㵥
		driver.pause(2000);
		driver.click(By.id("btn-budgetInfo-save"));
		driver.pause(1000);
//		driver.selectDefaultFrame();
//		driver.pause(1000);
//		driver.click(By.xpath("//*[@id='dialogTip']//button[@class='close']"));
	}
	
	//����ҵ��¼��-Ӱ�����TAB
	public void ImageManageEnter(){
		driver.pause(1000);
//		driver.selectFrame(By.name("iframe_undefined"));
//		driver.click(By.xpath("//*[@href='#detail']"));
	}
	
	
	
	//����ҵ��¼��-Ӱ�����-�ϴ�ͼƬ
	public void ImageManageUpload(int i){
		ImageManagePage imagemanage = new ImageManagePage(driver);
		imagemanage.ImageManage(i,1);
	}
	
	//������֤��
	public void CorrelationGuarantor(int correct){
		driver.click(By.xpath("//a[@href='#guarantee']"));
		driver.pause(3000);
		if(correct==1){
			GuaranteeInfoEnter1();
		}else{
			//����������
			driver.pause(1000);
			driver.click(By.id("relationGuarantor"));
//			driver.pause(1000);
//			driver.sendKeys(By.xpath("//*[@id='searchGuarantor']/div[1]/div[1]/div/input"), "�ݵĶ�");
//			driver.click(By.id("btn-guarantor-search2"));
			driver.pause(1000);
			driver.click(By.xpath("//*[@id='table_rGuarantor']/tbody/tr[1]/td[1]/a"));
			GuaranteeInfoEnter1();
			//��ӷ�������
			driver.pause(1000);
			driver.click(By.id("addGuarantor"));
			driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[1]/div[1]/div/input"), "��������");
			driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[2]/div[1]/div/select"), 1);
			driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[2]/div[2]/div/input"), "110102199701019252");
			driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[2]/div[3]/div/select"), 1);
			driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[3]/div[1]/div/input"), "1997-01-01");
			driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[3]/div[2]/div/input"), "20");
			driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[3]/div[3]/div/select"), 2);
			driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[4]/div[1]/div/input"), "13200000000");
			GuaranteeInfoEnter2();
		}
		
		//		driver.selectDefaultFrame();
//		driver.click(By.xpath("//*[@id='dialogTip']//button[@class='close']"));
	}

	//���뵣������Ϣ//*[@id="getLoanGuarantorInfo"]/form/fieldset/div/div[2]/fieldset/div[4]/div[1]/div/input
	public void GuaranteeInfoEnter1(){
		driver.pause(1000);
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[4]/div[2]/div/input"), "021-62202120");
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[4]/div[3]/div/input"), "����");
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[5]/div[1]/div/select"), 4);
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[5]/div[2]/div/select"), 1);
		
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[6]/div[1]/div/input"), "������Թ���ʦ");
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[6]/div[2]/div/select"), 7);
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[6]/div[3]/div/select"), 1);
		
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[7]/div[1]/div/input"), "��������cgw");
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[7]/div[2]/div/input"), "021-6222122");
		
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[7]/div[3]/div/select"), 2);
		
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[8]/div[1]/div/select"), 8);
		driver.pause(3000);
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[8]/div[2]/div/select"), 1);
		driver.pause(3000);
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[8]/div[3]/div/select"), 1);
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[9]/div/div/input"), "��������λ��ַ");
		
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[10]/div[1]/div/select"), 9);
		driver.pause(3000);
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[10]/div[2]/div/select"), 1);
		driver.pause(3000);
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/fieldset/div[10]/div[3]/div/select"), 1);
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/div/div[1]/div/input"), "�Ϻ���ͥ��ַ");
		driver.click(By.xpath("//*[@id='getLoanGuarantorInfo']/form/fieldset/div/div[2]/div/div[2]/button[1]"));
	}
	
	public void GuaranteeInfoEnter2(){
		driver.pause(1000);
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[4]/div[2]/div/input"), "021-62202120");
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[4]/div[3]/div/input"), "����");
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[5]/div[1]/div/select"), 4);
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[5]/div[2]/div/select"), 1);
		
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[6]/div[1]/div/input"), "������Թ���ʦ");
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[6]/div[2]/div/select"), 7);
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[6]/div[3]/div/select"), 1);
		
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[7]/div[1]/div/input"), "��������cgw");
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[7]/div[2]/div/input"), "021-6222122");
		
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[7]/div[3]/div/select"), 2);
		
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[8]/div[1]/div/select"), 8);
		driver.pause(3000);
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[8]/div[2]/div/select"), 1);
		driver.pause(3000);
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[8]/div[3]/div/select"), 1);
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[9]/div/div/input"), "��������λ��ַ");
		
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[10]/div[1]/div/select"), 9);
		driver.pause(3000);
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[10]/div[2]/div/select"), 1);
		driver.pause(3000);
		driver.selectByIndex(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/fieldset/div[10]/div[3]/div/select"), 1);
		driver.sendKeys(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/div/div[1]/div/input"), "�Ϻ���ͥ��ַ");
		driver.click(By.xpath("//*[@id='getLoanGuarantorInfo']/form[1]/fieldset/div/div[2]/div/div[2]/button[1]"));
	}
	
	//�ύ
	public void OfficeSubmit(String loginAccount){
		NextNodePopupPage nextnode = new NextNodePopupPage(driver);
		nextnode.NextNodePopup(1,loginAccount,1);
	}

	/**
	 * �����ҵ�����-����-����¼��-�ϴ�ͼƬ
	 * @return
	 */
	public HomePage MyTaskPageStartCredit(int businessType,String loginAccount,int maritalstatus,int customerAlready,int relationship) {
		if(customerAlready==0){
			System.out.println("--------------customerAlready:"+customerAlready+"-----------------");
			OfficeBasicInfoBorrower();
			OfficeBasicInfoBorrowerWife(maritalstatus);
		}else{
			logger.debug("");
		}
		OfficeBasicInfoCtriticalContacts("����",1,"13200000000",1,"�㽭������������һ��·11��");
		OfficeBasicInfoCtriticalContacts("����",2,"13200000001",0,"�㽭������������һ��·12��");
		OfficeBasicInfoOpinion();
		Budget(businessType);
		ImageManageEnter();
//		for(int i = 5;i<=14;i++){
//			ImageManageUpload(i);
//		}
//		for(int i=23;i<=27;i++){
//			ImageManageUpload(i);
//		}
		CorrelationGuarantor(relationship);
		OfficeSubmit(loginAccount);
		return new HomePage(driver);
	}


}
