package com.bsw.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * ���ݿ�����࣬�ṩ�����Ӿݿ⣬�Ͳ�����ӹ���
 * 
 * @author Student
 * @version 1.0.0
 */
public class DBManager { 
	
	/** �������ݿ��URL */
	private static String url = "jdbc:mysql://localhost:3306/sow?useUnicode=true&characterEncoding=utf-8";

	/**��MySQL���ݿ���������û�����*/ 
	private static String username = "root";

	/**��MySQL���ݿ�����������롡*/
	private static String password = "root";

	/**
	 * ������ݿ����Ӷ��� 
	 * @return ���ݿ����Ӷ���
	 */
	public static Connection getConnection() {
		Connection connection = null;
		/* ע��������������ݿ����� */
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance(); // ע������
			// �������
			connection = DriverManager.getConnection(url, username, password);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * �ر����е����ݿ�������Դ
	 * @param con ���ݿ����Ӷ�����Դ
	 * @param state Statement��Դ
	 * @param set ResultSet��Դ
	 */
	public static void closeAll(Connection connection,
								Statement state, ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (state != null) {
				state.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		DBManager.getConnection();
	}
}
