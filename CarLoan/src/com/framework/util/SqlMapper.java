package com.framework.util;

import java.io.Reader;

import org.apache.log4j.Logger;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapper {
	private static SqlMapClient sqlMapClient;
	private static Logger logger = Logger.getLogger(SqlMapper.class);

	/**
	 * ����SqlMapClientʵ����SqlMapClientʵ����Ibatis��ܵĺ��ġ�
	 */
	static {
		try {
			Reader reader = Resources
					.getResourceAsReader("config/SqlMapConfig.xml");
			sqlMapClient = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		} catch (Exception e) {
			logger.error("����SqlMapClient instance�����쳣���쳣��Ϣ��", e);
		}
	}

	/**
	 * ���SqlMapClientʵ����
	 * 
	 * @return SqlMapClient
	 */
	public static SqlMapClient getSqlMapClient() {
		return sqlMapClient;
	}
}
