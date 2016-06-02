package com.framework.util;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.auction.bean.StartCredit;
import com.ibatis.sqlmap.client.SqlMapClient;

public class FrameworkDao {
	private static SqlMapClient sqlMapClient;
	private static Logger logger = Logger.getLogger(FrameworkDao.class);

	/**
	 * ��ȡ����ָ�������Ķ���
	 * 
	 * @param statment
	 *            Ҫִ�е�statment
	 * @param object
	 *            ִ��statment����������
	 * 
	 * @return ���������ĵ�������
	 */
	public static Object getObjectByParam(String statment, Object object) {
		getSqlMapClient();
		try {
			return sqlMapClient.queryForObject(statment, object);
		} catch (Exception e) {
			logger.error("ִ��FrameworkDao.getObjectByParam()���������쳣���쳣��Ϣ��", e);
		}
		return null;
	}

	/**
	 * ���ѡ����󼯺��е�ĳ������
	 * 
	 * @param statment
	 *            Ҫִ�е�statment
	 * @param object
	 *            ִ��statment����������
	 * 
	 * @return ���ѡȡ�����������Ķ��󼯺��еĵ�������
	 */
	public static Object getRandomObjectByParam(String statment, Object object) {
		List list = getObjectListByParam(statment, object);
		int listSize = list.size();
		int randomNum = RandomUtil.getRandomNumber(0, listSize);
		return listSize == 0 ? null : list.get(randomNum);
	}

	/**
	 * ��ȡ�������������ж��󼯺ϡ�
	 * 
	 * @param statment
	 *            Ҫִ�е�statment
	 * @param object
	 *            ִ��statment����������
	 * 
	 * @return �������������ж��󼯺�
	 */
	public static List getObjectListByParam(String statment, Object object) {
		getSqlMapClient();
		try {
			return sqlMapClient.queryForList(statment, object);
		} catch (Exception e) {
			logger.error("ִ��FrameworkDao.getObjectListByParam()���������쳣���쳣��Ϣ��", e);
		}
		return null;
	}

	/**
	 * ��ȡ���еĶ��󼯺ϡ�
	 * 
	 * @param statment
	 *            Ҫִ�е�statment
	 * 
	 * @return ���ж��󼯺�
	 */
	public static List getAllObjects(String statment) {
		getSqlMapClient();
		try {
			return sqlMapClient.queryForList(statment);
		} catch (Exception e) {
			logger.error("ִ��FrameworkDao.getAllObjects()���������쳣���쳣��Ϣ��", e);
		}
		return null;
	}

	/**
	 * ��ȡSqlMapClient����
	 * 
	 * @param ��
	 * 
	 * @return SqlMapClient����
	 */
	public static SqlMapClient getSqlMapClient() {
		sqlMapClient = SqlMapper.getSqlMapClient();
		return sqlMapClient;
	}
	
	/**
	 * �������ݿ����
	 * @param startcredit
	 * @return
	 */
	public static boolean addcredit(StartCredit startcredit) {
		getSqlMapClient();
		Object object = null;
		boolean flag = false;
		try {
			object = sqlMapClient.insert("StartCredit.addcredit", startcredit);
			logger.debug("��ӷ���ֵ��" + object);
		} catch (SQLException e) {
		    e.printStackTrace();
		}
		if (object != null) {
		    flag = true;
		}
		return flag;
		}
}
