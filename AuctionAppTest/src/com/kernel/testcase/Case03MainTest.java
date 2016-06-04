package com.kernel.testcase;

import org.athrun.android.framework.AthrunTestCase;
import org.athrun.android.framework.Test;

import android.util.Log;

import com.kernel.activity.Login;
import com.kernel.activity.Main;
import com.kernel.util.ConstantUtil;
import com.robotium.solo.Solo;

public class Case03MainTest extends AthrunTestCase {
	private String className = this.getClass().getName();
	private Solo solo;
	private Login Login;
	private Main Main;
	private final String TAG = ConstantUtil.TAG;
	private final String PATH = ConstantUtil.PATH;
	private final long TIMEOUT = ConstantUtil.TIMEOUT;

	public Case03MainTest() throws Exception {
		super("org.crazyit.auction.client", "org.crazyit.auction.client.Login");
		AthrunTestCase.setMaxTimeToFindView(10000);
		Log.i(TAG, "running Case03MainTest");
	}

	public void setUp() {
		Log.i(TAG, "running setUp");
		try {
			solo = new Solo(getInstrumentation(), getActivity());
			Login = new Login(this, solo);
			Main = Login.loginOk("mysql", "mysql");
			super.setUp();
		} catch (Exception e) {
			logger.error("setUp error", e);
		}
	}

	/**
	 * 
	 * ����ViewSuccessItem
	 */
	@Test
	public void test01goViewSuccessItem() {
		Log.i(TAG, "running test01goViewSuccessItem");
		boolean flag = false;
		String captureName = "";
		try {
			Main.goViewSuccessItem();
			flag = solo.waitForText("���������Ʒ", 1, TIMEOUT);
			Log.d(TAG, "flag=" + flag);
			if (!flag) {
				captureName = className + ".test01goViewSuccessItem";
				solo.takeScreenshot(captureName);
			}
		} catch (Exception e) {
			logger.error(captureName + " error", e);
		}
		assertEquals(captureName + " failed!capture:" + PATH + captureName
				+ ".jpg", true, flag);
	}

	/**
	 * 
	 * ����ViewFailItem
	 */
	@Test
	public void test02goViewFailItem() {
		Log.i(TAG, "running test02goViewFailItem");
		boolean flag = false;
		String captureName = "";
		try {
			Main.goViewFailItem();
			flag = solo.waitForText("���������Ʒ", 1, TIMEOUT);
			Log.d(TAG, "flag=" + flag);
			if (!flag) {
				captureName = className + ".test02goViewFailItem";
				solo.takeScreenshot(captureName);
			}
		} catch (Exception e) {
			logger.error(captureName + " error", e);
		}
		assertEquals(captureName + " failed!capture:" + PATH + captureName
				+ ".jpg", true, flag);
	}

	/**
	 * 
	 * ����ManageKind
	 */
	@Test
	public void test03goManageKind() {
		Log.i(TAG, "running test03goManageKind");
		boolean flag = false;
		String captureName = "";
		try {
			Main.goManageKind();
			flag = solo.waitForText("ϵͳ��������Ʒ����", 1, TIMEOUT);
			Log.d(TAG, "flag=" + flag);
			if (!flag) {
				captureName = className + ".test03goManageKind";
				solo.takeScreenshot(captureName);
			}
		} catch (Exception e) {
			logger.error(captureName + " error", e);
		}
		assertEquals(captureName + " failed!capture:" + PATH + captureName
				+ ".jpg", true, flag);
	}

	/**
	 * 
	 * ����ManageItem
	 */
	@Test
	public void test04goManageItem() {
		Log.i(TAG, "running test04goManageItem");
		boolean flag = false;
		String captureName = "";
		try {
			Main.goManageItem();
			flag = solo.waitForText("����ǰ��������Ʒ", 1, TIMEOUT);
			Log.d(TAG, "flag=" + flag);
			if (!flag) {
				captureName = className + ".test04goManageItem";
				solo.takeScreenshot(captureName);
			}
		} catch (Exception e) {
			logger.error(captureName + " error", e);
		}
		assertEquals(captureName + " failed!capture:" + PATH + captureName
				+ ".jpg", true, flag);
	}

	/**
	 * 
	 * ����ChooseKind
	 */
	@Test
	public void test05goChooseKind() {
		Log.i(TAG, "running test05goChooseKind");
		boolean flag = false;
		String captureName = "";
		try {
			Main.goChooseKind();
			flag = solo.waitForText("��ѡ��һ����Ʒ����", 1, TIMEOUT);
			Log.d(TAG, "flag=" + flag);
			if (!flag) {
				captureName = className + ".test05goChooseKind";
				solo.takeScreenshot(captureName);
			}
		} catch (Exception e) {
			logger.error(captureName + " error", e);
		}
		assertEquals(captureName + " failed!capture:" + PATH + captureName
				+ ".jpg", true, flag);
	}

	/**
	 * 
	 * ����ViewBid
	 */
	@Test
	public void test06goViewBid() {
		Log.i(TAG, "running test06goViewBid");
		boolean flag = false;
		String captureName = "";
		try {
			Main.goViewBid();
			flag = solo.waitForText("�����뾺�����Ʒ", 1, TIMEOUT);
			Log.d(TAG, "flag=" + flag);
			if (!flag) {
				captureName = className + ".test06goViewBid";
				solo.takeScreenshot(captureName);
			}
		} catch (Exception e) {
			logger.error(captureName + " error", e);
		}
		assertEquals(captureName + " failed!capture:" + PATH + captureName
				+ ".jpg", true, flag);
	}

	public void tearDown() {
		Log.i(TAG, "running tearDown");
		try {
			super.tearDown();
		} catch (Exception e) {
			logger.error("tearDown error", e);
		}
	}
}
