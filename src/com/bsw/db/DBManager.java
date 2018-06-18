package com.bsw.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 * 数据库管理类，提供数连接据库，和拆除连接功能
 * 
 * @author Student
 * @version 1.0.0
 */
public class DBManager { 
	
	/** 连接数据库的URL */
	private static String url = "jdbc:mysql://localhost:3306/sow?useUnicode=true&characterEncoding=utf-8";

	/**　MySQL数据库服务器的用户名　*/ 
	private static String username = "root";

	/**　MySQL数据库服务器的密码　*/
	private static String password = "root";

	/**
	 * 获得数据库连接对象 
	 * @return 数据库连接对象
	 */
	public static Connection getConnection() {
		Connection connection = null;
		/* 注册驱动，获得数据库连接 */
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance(); // 注册驱动
			// 获得连接
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
	 * 关闭所有的数据库连接资源
	 * @param con 数据库连接对象资源
	 * @param state Statement资源
	 * @param set ResultSet资源
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
