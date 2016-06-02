package com.framework.webdriver.basecase;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.framework.util.DateTimeUtil;
import com.framework.util.PropUtil;
import com.framework.webdriver.testcase.InitWebdriverTest;

public class WebdriverBaseCase {
	protected static WebDriver driver;
	protected final String className = this.getClass().getName();
	protected static String capturePath;
	private long beforeSuiteStarts = 0;
	private long afterSuiteStops = 0;
	private long beforeClassStarts = 0;
	private long afterClassStops = 0;
	private long beforeTestStarts = 0;
	private long afterTestStops = 0;
	private PropUtil PropUtil = new PropUtil("config/FrameWork.properties");
	private Logger logger = Logger.getLogger(WebdriverBaseCase.class);

	public void beforeSuite() {
		capturePath = PropUtil.get("CapturePath");
		driver = InitWebdriverTest.getWebDriver();
		String begins = DateTimeUtil.formatedTime("yyyy-MM-dd HH:mm:ss:SSS");
		beforeSuiteStarts = System.currentTimeMillis();
		logger.info("======" + begins + "�����Լ���ʼ======");
	}

	public void afterSuite() {
		String ends = DateTimeUtil.formatedTime("yyyy-MM-dd HH:mm:ss:SSS");
		afterSuiteStops = System.currentTimeMillis();
		logger.info("======" + ends + "�����Լ�����======");
		logger.info("======���β��Լ���������ʱ�� "
				+ (double)(afterSuiteStops - beforeSuiteStarts) / 1000 + " �룡======");
	}

	public void beforeClass() {
		String begins = DateTimeUtil.formatedTime("yyyy-MM-dd HH:mm:ss:SSS");
		beforeClassStarts = System.currentTimeMillis();
		logger.info("======" + begins + "�����ԡ�" + className + "����ʼ======");
	}

	public void afterClass() {
		String ends = DateTimeUtil.formatedTime("yyyy-MM-dd HH:mm:ss:SSS");
		afterClassStops = System.currentTimeMillis();
		logger.info("======" + ends + "�����ԡ�" + className + "������======");
		logger.info("======���β�����������ʱ�� " + (double)(afterClassStops - beforeClassStarts)
				/ 1000 + " �룡======");
	}

	public void beforeTest(String methodName) {
		String begins = DateTimeUtil.formatedTime("yyyy-MM-dd HH:mm:ss:SSS");
		beforeTestStarts = System.currentTimeMillis();
		logger.info("======" + begins + "��������" + className + "." + methodName
				+ "����ʼ======");
	}

	public String afterTest(String methodName, boolean isSucceed) {
		String ends = DateTimeUtil.formatedTime("yyyy-MM-dd HH:mm:ss:SSS");
		String captureName = "";
		if (isSucceed) {
			logger.info("���� ��" + className + "." + methodName + "�� ����ͨ����");
		} else {
			String dateTime = DateTimeUtil.formatedTime("-yyyyMMdd-HHmmssSSS");
			StringBuffer sb = new StringBuffer();
			captureName = sb.append(capturePath).append(className).append(".")
					.append(methodName).append(dateTime).append(".png")
					.toString();
			captureScreenshot(captureName);
			logger.error("���� ��" + className + "." + methodName
					+ "�� ����ʧ�ܣ���鿴��ͼ���գ�" + captureName);
		}
		logger.info("======" + ends + "��������" + className + "." + methodName
				+ "������======");
		afterTestStops = System.currentTimeMillis();
		logger.info("======���ΰ�����������ʱ�� " + (double)(afterTestStops - beforeTestStarts)
				/ 1000 + " �룡======");
		return captureName;
	}

	/**
	 * ��ȡ��Ļ��ͼ�����浽ָ��·��
	 * 
	 * @param name
	 *            ������Ļ��ͼ����
	 * @return ��
	 */
	public void capture(String name) {
		String dateTime = DateTimeUtil.formatedTime("-yyyyMMdd-HHmmssSSS");
		StringBuffer sb = new StringBuffer();
		String captureName = sb.append(capturePath).append(name)
				.append(dateTime).append(".png").toString();
		captureScreenshot(captureName);
		logger.debug("��鿴��ͼ���գ�" + captureName);
	}

	/**
	 * ��ȡ��Ļ��ͼ�����浽ָ��·��
	 * 
	 * @param filepath
	 *            ������Ļ��ͼ�����ļ����Ƽ�·��
	 * @return ��
	 */
	public void captureScreenshot(String filepath) {
		File screenShotFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShotFile, new File(filepath));
		} catch (Exception e) {
			logger.error("������Ļ��ͼʧ�ܣ�ʧ����Ϣ��", e);
		}
	}

	/**
	 * public method for handle assertions and screenshot.
	 * 
	 * @param isSucceed
	 *            if your operation success
	 * @throws RuntimeException
	 */
	public void operationCheck(String methodName, boolean isSucceed) {
		if (isSucceed) {
			logger.info("method ��" + methodName + "�� ����ͨ����");
		} else {
			logger.error("method ��" + methodName + "�� ����ʧ�ܣ�");
		}
	}
}