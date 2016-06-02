package com.auction.page.beforeloanmanage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.framework.support.Win32GuiByAu3;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * �������ź󱣴�
 * @author Administrator
 *
 */
public class StartCreditPage extends BasePage{
	private Logger logger = Logger.getLogger(StartCreditPage.class);
	private Win32GuiByAu3 win32guibyau3 = new Win32GuiByAu3();
	
	
	public StartCreditPage(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��StartCreditPage��");
//		vercode = getVercode("GBK");
	}


	//����������Ű�ť
	public void clickStartCreditButton() {
		driver.pause(1000);
		driver.selectFrame(By.name("iframe_3001"), 1000);
		driver.click(By.xpath("//*[@id='launchedCredit']/span"));
		driver.pause(1000);
	}
	//����ͻ�����
	public void inputCustomerName(String customerName) {
		driver.pause(1000);
		driver.selectFrame(By.name("iframe_undefined"), 1000);
		driver.sendKeys(By.name("customerName"), customerName);
	}
	//ѡ��֤������
	public void chooseCustomerIdentify(int CustomerIdentifyType) {
		driver.selectByIndex(By.name("cardType"), CustomerIdentifyType);
	}
	//����֤������
	public void inputCustomerIdentify(String CustomerIdentify) {
		driver.sendKeys(By.name("cardNo"), CustomerIdentify);

	}
	/**
	 * 
	 * @param maritalStatus 1�����ѻ飬��������δ��
	 */
	public void inputmaritalStatus(int maritalStatus,String identifyNoMarry) {
		if(maritalStatus==1){
			driver.selectByIndex(By.name("maritalStatus"), maritalStatus);
			driver.sendKeys(By.xpath("//*[@id='wife']//input[@name='relavants[1].fullName']"), "��ż");
			driver.sendKeys(By.xpath("//*[@id='wife']//input[@name='relavants[1].cardId']"), identifyNoMarry);
			driver.sendKeys(By.xpath("//*[@id='wife']//input[@name='relavants[1].mobile']"), "13200000000");
			driver.click(By.xpath("//*[@id='wife']/div[2]/div[3]/div[1]/button"));
			driver.pause(1000);
			win32guibyau3.fileUpload("��","C:\\Users\\Public\\Pictures\\Sample Pictures\\2.jpg",1);
		}else{
			driver.selectByIndex(By.name("maritalStatus"), maritalStatus);
		}

	}
	//�����������
	public void inputinvestigationBank(int investigationBank) {
		driver.selectByIndex(By.name("inquryBankId"), investigationBank);
	}
	//�����ֻ�����
	public void inputCellPhone(String CustomerCellPhone) {
		driver.sendKeys(By.xpath("//*[@id='creditForm']//input[@name='relavants[0].mobile']"), CustomerCellPhone);
//		driver.jsExecutor("document.getElementByName(\"relavants[0].borrowerRelationship\").value='4';");
	}
	//�����ļ��ϴ�
	public void inputimages() {
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='creditForm']/div[3]/div/div[2]/div[3]/div[1]/button"));
		driver.pause(1000);
		win32guibyau3.fileUpload("��","C:\\Users\\Public\\Pictures\\Sample Pictures\\1.jpg",1);
	}
	
	/**
	 * �Ƿ���ӹ�ϵ��
	 * @param addreationship ��ϵ�ˣ�1��ʾ��ӣ�2��ʾ�����
	 * @param guarantor 1��ʾ�����ˣ�2��ʾ��������
	 */
	public void addReationship(int addreationship,int guarantor,int maritalStatus){
		if(addreationship==1&&maritalStatus==1){
			driver.click(By.id("addParty"));
			driver.pause(3000);
			driver.sendKeys(By.xpath("//*[@id='partyBox']//input[@name='relavants[3].fullName']"), "��ϵ��");
			driver.sendKeys(By.xpath("//*[@id='partyBox']//input[@name='relavants[3].cardId']"), "130103198701018896");
			driver.sendKeys(By.xpath("//*[@id='partyBox']//input[@name='relavants[3].mobile']"), "13000000000");
			driver.selectByIndex(By.xpath("//*[@id='partyBox']//select[@name='relavants[3].borrowerRelationship']"), 10);
			driver.selectByIndex(By.xpath("//*[@id='partyBox']//select[@name='relavants[3].guaranteeRelationship']"), guarantor);
		}else{
			logger.debug("����Ҫ��ӹ�ϵ��");
		}
		if(addreationship==1&&maritalStatus!=1){
			driver.click(By.id("addParty"));
			driver.pause(3000);
			driver.sendKeys(By.xpath("//*[@id='partyBox']//input[@name='relavants[2].fullName']"), "��ϵ��");
			driver.sendKeys(By.xpath("//*[@id='partyBox']//input[@name='relavants[2].cardId']"), "130103198701018896");
			driver.sendKeys(By.xpath("//*[@id='partyBox']//input[@name='relavants[2].mobile']"), "13000000000");
			driver.pause(1000);
			driver.selectByIndex(By.xpath("//*[@id='partyBox']//select[@name='relavants[2].borrowerRelationship']"), 10);
			driver.selectByIndex(By.xpath("//*[@id='partyBox']//select[@name='relavants[2].guaranteeRelationship']"), guarantor);
		}else{
			logger.debug("����Ҫ��ӹ�ϵ��");
		}
	}
	
	//��������ҳ�沿���İ�У��
	public void checkContent(String customerName,String customerManagerName,String CustomerIdentifyType, String CustomerIdentify){
		boolean isSucceed = false;
//		driver.selectFrame(By.name("iframe5"), 1000);
		//��ȡ���������
		String lgusername = (String) driver.jsReturner("return document.getElementById('name').value");
		//��ȡ�ͻ���������
		String ctname = (String) driver.jsReturner("return document.getElementsByTagName('input')[5].value"); 
		//��ȡ֤������
		String identifytype = (String) driver.jsReturner("return document.getElementsByTagName('input')[8].value"); 
		//��ȡ֤������
		String identifyno = (String) driver.jsReturner("return document.getElementsByTagName('input')[10].value"); 
		System.out.println("���������"+lgusername);
		System.out.println("�ͻ���������"+ctname);
		System.out.println("֤������"+identifytype);
		System.out.println("֤������"+identifyno);
		System.out.println("1���������"+customerName);
		System.out.println("1�ͻ���������"+customerManagerName);
		System.out.println("1֤������"+CustomerIdentifyType);
		System.out.println("1֤������"+CustomerIdentify);
		//�ж��İ��Ƿ������ֵһ��
		if(lgusername.equals(customerName)&&ctname.equals(customerManagerName)&&identifytype.equals(CustomerIdentifyType)&&identifyno.equals(CustomerIdentify)){
			isSucceed = true;
			logger.debug("���ŷ���_У��ɹ�");
		}else{
			logger.debug("���ŷ���_У��ʧ��");
			Assert.assertTrue(isSucceed,".testLogin failed!capture");
		}
	}
	//������水ť
	public void clickSaveButton() {
		driver.click(By.id("preservation"));
		driver.pause(2000);
		driver.click(By.id("sureOption"));
		driver.pause(1000);
		driver.selectDefaultFrame();
//		driver.click(By.xpath("//*[@id='dialogTip']/div/div/div[1]/button"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='toast-container']"),10);
		//�ر�ȫ��TAB
		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/button"));
		driver.click(By.xpath("//*[@id='page-wrapper']/div[2]/div/ul/li[3]"));
	}





	/**
	 * ����������������
	 * @param customerName �ͻ�����
	 * @param CustomerIdentifyType ֤������
	 * @param CustomerIdentify ֤������
	 * @param CustomerCellPhone ������ֻ�����
	 * @param maritalStatus ����״̬
	 * @param investigationBank ��������
	 * @return
	 */
	public HomePage StartCredit(String customerName, int CustomerIdentifyType, String CustomerIdentify,String CustomerCellPhone,
			int maritalStatus,String investigationBank,String CustomerManagerName,String identifyNoMarry,int addreationship,int guarantor) {
		driver.pause(1000);
		//ת����1Ϊ���֤
		String sfz = null;
		if(CustomerIdentifyType==1){
			sfz="���֤";
		}else{
			sfz="����";
		}
		//��������investigationBank���ã����¶���һ��ֵ��ʾ��Ҫѡ�������
		int investbank = 2;
		//��������
		clickStartCreditButton();
		inputCustomerName(customerName);
		chooseCustomerIdentify(CustomerIdentifyType);
		inputCustomerIdentify(CustomerIdentify);
		inputmaritalStatus(maritalStatus,identifyNoMarry);
		inputinvestigationBank(investbank);		
		inputCellPhone(CustomerCellPhone);
		inputimages();
		addReationship(addreationship,guarantor,maritalStatus);
		checkContent(customerName, CustomerManagerName, sfz, CustomerIdentify);
		clickSaveButton();
		return new HomePage(driver);
	}


}
