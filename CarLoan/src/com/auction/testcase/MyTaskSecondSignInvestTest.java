package com.auction.testcase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.auction.bean.StartCredit;
import com.auction.bean.UserInfo;
import com.auction.page.HomePage;
import com.auction.page.LoginPage;
import com.auction.page.MyTaskPage;
import com.auction.page.beforeloanmanage.MyTaskStartCreditDetailToDo;
import com.auction.page.beforeloanmanage.StartCreditPage;
import com.auction.page.customermanage.CustomerManagePage;
import com.framework.util.DbUnitUtil;
import com.framework.util.FrameworkDao;
import com.framework.util.RandomIdentify;
import com.framework.webdriver.baseapi.WebdriverBaseApi;
import com.framework.webdriver.basecase.WebdriverBaseCase;
import com.framework.util.*;

/**
 * 用例:我的任务-副签单调查
 * @author Administrator
 *
 */
@Test(groups = { "LoanStart" })
public class MyTaskSecondSignInvestTest extends WebdriverBaseCase {
	private DbUnitUtil DbUnitUtil;
	private UserInfo UserInfo;
	private LoginPage LoginPage;
	private MyTaskPage mytaskpage;
	private HomePage HomePage;
	private MyTaskStartCreditDetailToDo mytaskstartcreditdetailtodo;
	protected WebdriverBaseApi webDriver;
	StartCredit stCredit;
	private String CustomerManagerName;  //客户经理名字
	private Logger logger = Logger.getLogger(MyTaskSecondSignInvestTest.class);

	@BeforeClass(alwaysRun = true)
	public void beforeClassTest() {
		beforeClass();
		try {
			webDriver = new WebdriverBaseApi(driver);
		} catch (Exception e) {
			logger.error("beforeClassTest error：", e);
		}

	}
	
	@Test(enabled = true)
	public void testLogin() {
		boolean flag = false;
		beforeTest("testLogin");
		try {
			
			UserInfo = (UserInfo) FrameworkDao.getRandomObjectByParam(
					"UserInfo.getUserByParam", "zad1");
			CustomerManagerName = UserInfo.getLoginname();
			HomePage = new HomePage(webDriver);
			LoginPage = HomePage.Logincancel();
			HomePage = LoginPage.loginOK(UserInfo.getUsername(),
					UserInfo.getPassword(), null);
			flag = HomePage.isTextPresent(CustomerManagerName);
		} catch (Exception e) {
			logger.error("testLogin error：", e);
		}
		logger.debug("flag==" + flag);
		String captureName = afterTest("testLogin", flag);
		Assert.assertTrue(flag, className + ".testLogin failed!capture:"
				+ captureName);
	}
	

	@Test(dependsOnMethods={"testLogin"},enabled = true, alwaysRun = true)
	public void myTaskStartCredit() {
		boolean flag = false;
		beforeTest("myTaskStartCredit");
		try {
			HomePage = new HomePage(webDriver);
			UserInfo = (UserInfo) FrameworkDao.getRandomObjectByParam(
					"UserInfo.getUserByParam", "testLogin");
			String CustomerManagerName_o = UserInfo.getLoginname();
			System.out.println("-----------------"+CustomerManagerName_o+"-----------------------");
//			mytaskpage = HomePage.goMyTaskPage(1);
//			mytaskpage.MyTaskPageStartCredit();
			HomePage.goMyTaskPage(1).MyTaskPageStartCredit().goMyTaskSecondSignBillInvestDetailToDo().MyTaskSignBillDistribution(CustomerManagerName_o);
//			flag = HomePage.isTextPresent("保存成功");
		} catch (Exception e) {
			logger.error("testLogin error：", e);
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
			logger.error("afterClassTest error：", e);
		}
		afterClass();
	}
}
