package com.auction.testcase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.auction.bean.Configure;
import com.auction.bean.StartCredit;
import com.auction.bean.UserInfo;
import com.auction.page.HomePage;
import com.auction.page.LoginPage;
import com.auction.page.beforeloanmanage.StartCreditPage;
import com.auction.page.customermanage.CustomerManagePage;
import com.framework.util.DbUnitUtil;
import com.framework.util.FrameworkDao;
import com.framework.util.RandomIdentify;
import com.framework.webdriver.baseapi.WebdriverBaseApi;
import com.framework.webdriver.basecase.WebdriverBaseCase;
import com.framework.util.*;

/**
 * ����:�����-�ύ
 * @author Administrator
 *
 */
@Test(groups = { "LoanStart" })
public class LoanStartTest extends WebdriverBaseCase {
	private DbUnitUtil DbUnitUtil;
	private UserInfo UserInfo;
	private LoginPage LoginPage;
	private StartCreditPage StartCreditPage;
	private HomePage HomePage;
	protected WebdriverBaseApi webDriver;
	private RandomIdentify RandomIdentify;
	StartCredit stCredit;
	private String customerName;  //�ͻ�����
	private String identifyNo;    //֤������
	private String CellPhone;     //������ֻ�����
	private String CustomerManagerName;  //�ͻ���������
	private int identifytype=1;   //֤�������Զ���Ϊ���֤
	private String investbank="���ݹ��йŶ�·֧��";     //��������Ĭ��ѡ�е�һ��,Ŀǰ�Ǻ��ݹ��йŶ�·֧�У�ȡ�����б��һ��ֵ����
	private int maritalstatus=2;  //����״���Զ���Ϊδ��
	private Configure Configure;
	private String carname;
	private Logger logger = Logger.getLogger(LoanStartTest.class);

	@BeforeClass(alwaysRun = true)
	public void beforeClassTest() {
		beforeClass();
		try {
			webDriver = new WebdriverBaseApi(driver);
			Configure = (Configure) FrameworkDao.getRandomObjectByParam(
					"Configure.getUserByParam1", "testSet");
			carname = Configure.getCarname();
//			RandomIdentify=new RandomIdentify();
//			customerName = RandomUtil.getChineseName();
//			identifyNo = RandomIdentify.getIDCard();
//			CellPhone = RandomUtil.getTel();
			//��������ɵ��Լ��Զ���Ķ�����access���ݿ�
//			stCredit = new StartCredit();
//			stCredit.setCellPhone(CellPhone);
//			stCredit.setCustomerName(customerName);
//			stCredit.setIdentifyNo(identifyNo);
//			stCredit.setIdentifyType(identifytype);
//			stCredit.setInvestigationBank(investbank);
//			stCredit.setMaritalStatus(maritalstatus);
//			FrameworkDao.addcredit(stCredit);
		} catch (Exception e) {
			logger.error("beforeClassTest error��", e);
		}

	}
	
	@Test(enabled = false)
	public void testLogin() {
		boolean flag = false;
		beforeTest("testLogin");
		try {
			UserInfo = (UserInfo) FrameworkDao.getRandomObjectByParam(
					"UserInfo.getUserByParam", "testLogin");
			CustomerManagerName = UserInfo.getLoginname();
			HomePage = new HomePage(webDriver);
			LoginPage = HomePage.goLoginPage();
			HomePage = LoginPage.loginOK(UserInfo.getUsername(),
					UserInfo.getPassword(), null);
			flag = HomePage.isTextPresent(CustomerManagerName);
		} catch (Exception e) {
			logger.error("testLogin error��", e);
		}
		logger.debug("flag==" + flag);
		String captureName = afterTest("testLogin", flag);
		Assert.assertTrue(flag, className + ".testLogin failed!capture:"
				+ captureName);
	}
	

	@Test(enabled = true, alwaysRun = true)
	public void loanstart() {
		boolean flag = false;
		beforeTest("loanstart");
		try {
			HomePage = new HomePage(webDriver);
			UserInfo = (UserInfo) FrameworkDao.getRandomObjectByParam(
					"UserInfo.getUserByParam", "testLogin");
			CustomerManagerName = UserInfo.getLoginname();
			HomePage.goMyTaskLoanStartDetailToDo().MyTaskPageStartCredit(1,CustomerManagerName,1,carname);
//			flag = HomePage.isTextPresent("����ɹ�");
		} catch (Exception e) {
			logger.error("testLogin error��", e);
		}
//		logger.debug("flag==" + flag);
//		String captureName = afterTest("startcredit", flag);
//		Assert.assertTrue(flag, className + ".testLogin failed!capture:"
//				+ captureName);
	}


	@AfterClass(alwaysRun = true)
	public void afterClassTest() {
		try {
//			DbUnitUtil.tearDown();
		} catch (Exception e) {
			logger.error("afterClassTest error��", e);
		}
		afterClass();
	}
}
