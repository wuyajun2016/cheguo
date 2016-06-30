package com.kernel.testcase;

import java.util.Map;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.kernel.action.LoginAction;
import com.kernel.action.IndexPageAction;
import com.kernel.basecase.BaseCase;
import com.kernel.util.Base64;
import com.kernel.util.ExcelUtil;

@Test(groups = { "LoginActionTest" }, description = "登录测试")
public class LoginActionTest extends BaseCase {
	private LoginAction LoginAction;
	private IndexPageAction IndexPageAction;
	private Logger logger = Logger.getLogger(LoginActionTest.class);

	@BeforeClass(alwaysRun = true)
	public void beforeClassTest() {
		try {
			beforeClass();
		} catch (Exception e) {
			logger.error("执行LoginActionTest.beforeClassTest错误：", e);
		}
	}

	@Test(enabled = true, alwaysRun = true, description = "打开首页")
	public void indexPage() {
		try {
			beforeTest("indexPage");
			IndexPageAction = new IndexPageAction();
			boolean flag = IndexPageAction.login();
			Assert.assertEquals(flag, true, className + ".testLogin failed!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(dependsOnMethods={"indexPage"},enabled = true, alwaysRun = true, description = "登录测试")
	public void testLogin() {
		boolean flag = false;

		try {
			beforeTest("testLogin");
			LoginAction = new LoginAction();
			Map<String, String> userMap = ExcelUtil.importDataTable(
					"testdata.xls", "LoginActionTest", "testLogin");
			String userName = userMap.get("email");
			String password = Base64.encode(userMap.get("password"), "utf-8");
			JSONObject JSONObject = LoginAction.login(userName, password);
			String success = JSONObject.get("code").toString();
			if ("10000".equals(success)) {
			  flag = true;
		    }
		} catch (Exception e) {
			logger.error("执行LoginActionTest.testLogin错误：", e);
		}
		afterTest("testLogin", flag);
		Assert.assertEquals(flag, true, className + ".testLogin failed!");
	}

//	@Test(dependsOnMethods = { "testLogin" }, enabled = true, alwaysRun = false, description = "登录密码错误测试")
//	public void testLoginWithPwdError() {
//		boolean flag = false;
//
//		try {
//			beforeTest("testLoginWithPwdError");
//			Map<String, String> userMap = ExcelUtil.importDataTable(
//					"testdata.xls", "LoginActionTest", "testLoginWithPwdError");
//			String email = userMap.get("email");
//			String password = Base64.encode(userMap.get("password"), "utf-8");
//			JSONObject JSONObject = LoginAction.login(email, password);
//			String errorcode = JSONObject.getJSONObject("result").optString(
//					"errorcode");
//			if ("2201".equals(errorcode)) {
//				flag = true;
//			}
//		} catch (Exception e) {
//			logger.error("执行LoginActionTest.testLoginWithPwdError错误：", e);
//		}
//		afterTest("testLoginWithPwdError", flag);
//		Assert.assertEquals(flag, true, className
//				+ ".testLoginWithPwdError failed!");
//	}

	@AfterClass(alwaysRun = true)
	public void afterClassTest() {
		try {
			afterClass();
		} catch (Exception e) {
			logger.error("执行LoginActionTest.afterClassTest错误：", e);
		}

	}
}
