package com.kernel.basecase;

import org.apache.log4j.Logger;

import com.kernel.util.DateTimeUtil;

public class BaseCase {

	protected final String className = this.getClass().getName();
	protected static String capturePath;
	private long beforeSuiteStarts = 0;
	private long afterSuiteStops = 0;
	private long beforeClassStarts = 0;
	private long afterClassStops = 0;
	private long beforeTestStarts = 0;
	private long afterTestStops = 0;
	private Logger logger = Logger.getLogger(BaseCase.class);

	public void beforeSuite() {

		String begins = DateTimeUtil.formatedTime("yyyy-MM-dd HH:mm:ss:SSS");
		beforeSuiteStarts = System.currentTimeMillis();
		logger.info("======" + begins + "�����Լ���ʼ======");
	}

	public void afterSuite() {
		String ends = DateTimeUtil.formatedTime("yyyy-MM-dd HH:mm:ss:SSS");
		afterSuiteStops = System.currentTimeMillis();
		logger.info("======" + ends + "�����Լ�����======");
		logger.info("======���β��Լ���������ʱ�� "
				+ (afterSuiteStops - beforeSuiteStarts) / 1000 + " �룡======");
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
		logger.info("======���β�����������ʱ�� " + (afterClassStops - beforeClassStarts)
				/ 1000 + " �룡======");
	}

	public void beforeTest(String methodName) {
		String begins = DateTimeUtil.formatedTime("yyyy-MM-dd HH:mm:ss:SSS");
		beforeTestStarts = System.currentTimeMillis();
		logger.info("======" + begins + "��������" + className + "." + methodName
				+ "����ʼ======");
	}

	public void afterTest(String methodName, boolean isSucceed) {
		String ends = DateTimeUtil.formatedTime("yyyy-MM-dd HH:mm:ss:SSS");
		afterTestStops = System.currentTimeMillis();
		if (isSucceed) {
			logger.info("���� ��" + className + "." + methodName + "�� ����ͨ����");
		} else {
			logger.error("���� ��" + className + "." + methodName + "�� ����ʧ�ܣ�");
		}
		logger.info("======" + ends + "��������" + className + "." + methodName
				+ "������======");
		logger.info("======���ΰ�����������ʱ�� " + (afterTestStops - beforeTestStarts)
				/ 1000 + " �룡======");
	}
}