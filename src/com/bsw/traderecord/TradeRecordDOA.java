package com.bsw.traderecord;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.bsw.db.*;

import java.util.*;


/**
 * 交易记录管理类，管理交易记录插入数据库和
 * 
 * @author Student
 * @version 1.0.0
 */
public class TradeRecordDOA {

	/**
	 * Statement对象 
	 */
	private Statement state;

	/**
	 * PreparedStatement对象
	 */
	private PreparedStatement preState;

	/**
	 * 结果集对象
	 */
	private ResultSet resultSet;

	/** 
	 * 数据库连接类对象
	 */
	private Connection connection;

	/**
	 * 默认构造函数
	 */
	public TradeRecordDOA() {
		
		state = null;
		preState = null;
		resultSet = null;
		connection = null;
	}
	
	/**
	 * 获取所有 交易记录
	 * 
	 * @return 存放交易记录的容器
	 */
	public ArrayList queryOrders() {

		ArrayList recordList = new ArrayList(); // 初始化一个容器

		try {

			connection = DBManager.getConnection();
			state = connection.createStatement();
			String sql = "select * from  traderecord";
			resultSet = state.executeQuery(sql); // 执行 SQL 查询操作

			while (resultSet.next()) {

				TradeRecord record = new TradeRecord(resultSet.getInt(1),
											  resultSet.getInt(2),
											  resultSet.getInt(3),
											  resultSet.getInt(4),
											  resultSet.getInt(5));

				

				recordList.add(record); // 将封装好的order对象加入容器
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			
			DBManager.closeAll(connection, state, resultSet);
		}
		return recordList;
	}
	
	/**
	 * 向数据库中加入交易记录,插入成功返回真，否则返回假
	 * 
	 * @param tr 给定要插入交易记录
	 * @return true 或 false
	 */
	public boolean insertTradeRecord(TradeRecord tr) {
		
		connection = DBManager.getConnection(); // 得到数据库连接

		StringBuffer sqlState = new StringBuffer();
		sqlState.append("INSERT INTO traderecord(userId,bookId,tradeNum,status) VALUES(?,?,?,?)");

		try {

			preState = connection.prepareStatement(sqlState.toString()); // 采用预处理方式

			// 设置每个要插入的的属性
			preState.setInt(1, tr.getUserId());
			preState.setInt(2, tr.getBookId());
			preState.setInt(3, tr.getTradeNum());
			preState.setInt(4, tr.getStatus());
			
			preState.execute("begin"); // 事务开始
			preState.executeUpdate();
			preState.execute("commit"); // 提交插入操作

			System.out.println(" insert success!");	

			return true;
		} catch (SQLException e) {

			try {

				preState.execute("rollback"); // 回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}

			e.printStackTrace();

			return false;
		} finally {
			DBManager.closeAll(connection, preState, resultSet);
		}
	}
	////////////////////Test////////////////////
	/*public static void main(String[] args) {
		
		
		TradeRecordDOA trdoa = new TradeRecordDOA();
		
		TradeRecord tr = new TradeRecord(1,1,2,1,66);
		
		ArrayList al = trdoa.queryOrders();
		Iterator it = al.iterator();
		while(it.hasNext()) {
			
			TradeRecord t = (TradeRecord)it.next();
			System.out.println(t.getId());
			System.out.println(t.getUserId());
			System.out.println(t.getBookId());
			System.out.println(t.getTradeNum());
			System.out.println(t.getStatus());
		}
		//trdoa.insertTradeRecord(tr);
	}*/
	
}
