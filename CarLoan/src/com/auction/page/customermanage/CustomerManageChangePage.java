package com.auction.page.customermanage;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import com.auction.page.BasePage;
import com.auction.page.HomePage;
import com.framework.webdriver.baseapi.WebdriverBaseApi;

/**
 * �޸Ŀͻ�������Ϣ
 * @author Administrator
 *
 */
public class CustomerManageChangePage extends BasePage {
	private Logger logger = Logger.getLogger(CustomerManageChangePage.class);

	public CustomerManageChangePage(WebdriverBaseApi driver) {
		super(driver);
		logger.debug("running test in ��CustomerManageChangePage��");
//		vercode = getVercode("GBK");
	}

	
	//����ͻ���Ϣ�޸�ҳ��
	public void enterCustomerManageChange() {
		driver.selectFrame(By.name("iframe_2002"), 10);
		driver.click(By.xpath("//*[@id='table']/tbody/tr[1]/td[9]/div/button"));
		driver.pause(1000);
		driver.click(By.xpath("//*[@id='table']/tbody/tr[1]/td[9]/div/ul/li[2]"));
		driver.pause(1000);
	}
	/**
	 * �޸Ŀͻ���Ϣ
	 * @param marriage ����״����2�ѻ� 1δ��
	 */
	public void CustomerManageChange(int marriage){
		driver.pause(1000);
		driver.selectFrame(By.name("iframe_undefined"));
		if(marriage==1){
			driver.selectByIndex(By.name("maritalStatus"), 2);
		}else{
			driver.selectByIndex(By.name("maritalStatus"), 1);
		}

		driver.sendKeys(By.name("homePhone"), "021-6222122");
		driver.sendKeys(By.name("nativePlace"), "����");
		driver.selectByIndex(By.name("education"), 4);
		driver.selectByIndex(By.name("housingStatus"), 1);
		driver.sendKeys(By.name("profession"), "������Թ���ʦ");
		driver.selectByIndex(By.name("industry"), 7);
		driver.selectByIndex(By.name("monthlyIncome"), 2);
		driver.sendKeys(By.name("company"), "��������Ƽ����޹�˾");
		driver.sendKeys(By.name("workPhone"), "0577-6222122");
		driver.selectByIndex(By.name("reservedFunds"), 2);
		//���뵥λ��ַ
		driver.pause(1000);
		driver.selectByIndex(By.name("companyAddressProvinceCode"), 11,3);
		driver.pause(3000);
		driver.selectByIndex(By.name("companyAddressCityCode"), 1,3);
		driver.pause(3000);
		driver.selectByIndex(By.name("companyAddressCountyCode"), 5,3);
		driver.pause(3000);
		driver.sendKeys(By.name("companyAddress"), "��ϼ���峣��·11��502��");
		//�����ͥ��ַ
		driver.pause(1000);
		driver.selectByIndex(By.name("homeAddressProvinceCode"), 11,3);
		driver.pause(3000);
		driver.selectByIndex(By.name("homeAddressCityCode"), 3,3);
		driver.pause(3000);
		driver.selectByIndex(By.name("homeAddressCountyCode"), 11,3);
		driver.pause(3000);
		driver.sendKeys(By.name("homeAddressVillage"), "���ӱ�·11Ū1��");
		driver.pause(1000);
		if(marriage==1){
			driver.sendKeys(By.name("spouseMobilePhone"), "13888888888");
			driver.sendKeys(By.name("spouseNativePlace"), "����");
			driver.selectByIndex(By.name("spouseReservedFunds"), 2);
			driver.sendKeys(By.name("spouseCompany"), "������ѧ");
			driver.sendKeys(By.name("spouseCompanyPhone"), "0571-85465324");
			driver.selectByIndex(By.name("spouseCompanyAddrProvinceCode"), 11,3);
			driver.pause(3000);
			driver.selectByIndex(By.name("spouseCompanyAddrCityCode"), 1,3);
			driver.pause(3000);
			driver.selectByIndex(By.name("spouseCompanyAddrCountyCode"), 5,3);
			driver.pause(1000);
			driver.sendKeys(By.name("spouseCompanyAddr"), "����һ��11��10-2");
			driver.selectByIndex(By.name("spouseMonthlyIncome"), 2);
		}else{
			logger.debug("-------------------����ż----------------");
		}
		driver.click(By.id("save"));
		driver.pause(1000);
	} 
	


	public HomePage CustomerManageChangeT(int marriage) {
		enterCustomerManageChange();
		CustomerManageChange(marriage);
		return new HomePage(driver);
	}

}
