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
import com.auction.page.beforeloanmanage.MyTaskInputCreditDetailToDo;
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
 * ����:�ҵ�����-���������ύ
 * @author Administrator
 *
 */
@Test(groups = { "StartCredit" })
public class MyTaskAcceptCreditTest extends WebdriverBaseCase {
	private DbUnitUtil DbUnitUtil;
	private UserInfo UserInfo;
	private LoginPage LoginPage;
	private MyTaskPage mytaskpage;
	private HomePage HomePage;
	private MyTaskInputCreditDetailToDo mytaskinputcreditdetailtodo;
	protected WebdriverBaseApi webDriver;
	StartCredit stCredit;
	private Logger logger = Logger.getLogger(MyTaskAcceptCreditTest.class);

	@BeforeClass(alwaysRun = true)
	public void beforeClassTest() {
		beforeClass();
		try {
			webDriver = new WebdriverBaseApi(driver);
		} catch (Exception e) {
			logger.error("beforeClassTest error��", e);
		}

	}
	

	@Test(enabled = true, alwaysRun = true)
	public void myTaskInputCredit() {
		boolean flag = false;
		beforeTest("myTaskStartCredit");
		try {
			HomePage = new HomePage(webDriver);
			HomePage = HomePage.goMyTaskPage(0).MyTaskPageStartCredit().goAcceptCreditPage().MyTaskPageStartCredit();
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
