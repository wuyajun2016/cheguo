package com.framework.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

public class DbUtil {

	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	private String dbDriver = null;
	private String dbConnectionURL = null;
	private String dbUsername = null;
	private String dbPassword = null;
	private PropUtil PropUtil = new PropUtil("config/db.properties");
	private Logger logger = Logger.getLogger(DbUtil.class);

	public DbUtil() {
		dbDriver = PropUtil.get("Driver");
		dbConnectionURL = PropUtil.get("ConnectionURL");
		dbUsername = PropUtil.get("Username");
		dbPassword = PropUtil.get("Password");
	}

	public DbUtil(String dbDriver, String dbConnectionURL, String dbUsername,
			String dbPassword) {
		this.dbDriver = dbDriver;
		this.dbConnectionURL = dbConnectionURL;
		this.dbUsername = dbUsername;
		this.dbPassword = dbPassword;
	}

	/**
	 * ���ܣ���ȡ���ݿ�����
	 */
	public Connection getConnection() {
		try {
			Class.forName(dbDriver);
			conn = DriverManager.getConnection(dbConnectionURL, dbUsername,
					dbPassword);
		} catch (Exception e) {
			logger.error("Error: DbUtil.getConnection() ������ݿ�����ʧ��.\r\n��������:"
					+ dbDriver + "\r\n����URL:" + dbConnectionURL + "\r\n�����û�:"
					+ dbUsername + "\r\n��������:" + dbPassword, e);
		}
		return conn;
	}

	/**
	 * ���ܣ�ִ�в�ѯ���
	 */
	public ResultSet executeQuery(String sql) {
		getConnection();
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			logger.error("ִ��DbUtil.executeQuery()���������쳣���쳣��Ϣ��", e);
		}
		return rs;
	}

	/**
	 * ���ܣ�ִ�в�ѯ��䣬��ȡ��¼��
	 */
	public int getRecordCount(String sql) {
		int counter = 0;
		rs = executeQuery(sql);
		try {
			while (rs.next()) {
				counter++;
			}
		} catch (SQLException e) {
			logger.error("ִ��DbUtil.getRecordCount()���������쳣���쳣��Ϣ��", e);
		}
		close();
		return counter;
	}

	/**
	 * ����:ִ�и��²���
	 */
	public int executeUpdate(String sql) {
		int result = 0;
		getConnection();
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			result = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			logger.error("ִ��DbUtil.executeUpdate()���������쳣���쳣��Ϣ��", e);
		}
		close();
		return result;
	}

	/**
	 * ����:�ر����ݿ������
	 */
	public void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			logger.error("ִ��DbUtil.close()���������쳣���쳣��Ϣ��", e);
		}
	}
}
