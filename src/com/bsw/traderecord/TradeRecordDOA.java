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
 * ���׼�¼�����࣬�����׼�¼�������ݿ��
 * 
 * @author Student
 * @version 1.0.0
 */
public class TradeRecordDOA {

	/**
	 * Statement���� 
	 */
	private Statement state;

	/**
	 * PreparedStatement����
	 */
	private PreparedStatement preState;

	/**
	 * ���������
	 */
	private ResultSet resultSet;

	/** 
	 * ���ݿ����������
	 */
	private Connection connection;

	/**
	 * Ĭ�Ϲ��캯��
	 */
	public TradeRecordDOA() {
		
		state = null;
		preState = null;
		resultSet = null;
		connection = null;
	}
	
	/**
	 * ��ȡ���� ���׼�¼
	 * 
	 * @return ��Ž��׼�¼������
	 */
	public ArrayList queryOrders() {

		ArrayList recordList = new ArrayList(); // ��ʼ��һ������

		try {

			connection = DBManager.getConnection();
			state = connection.createStatement();
			String sql = "select * from  traderecord";
			resultSet = state.executeQuery(sql); // ִ�� SQL ��ѯ����

			while (resultSet.next()) {

				TradeRecord record = new TradeRecord(resultSet.getInt(1),
											  resultSet.getInt(2),
											  resultSet.getInt(3),
											  resultSet.getInt(4),
											  resultSet.getInt(5));

				

				recordList.add(record); // ����װ�õ�order�����������
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		} finally {
			
			DBManager.closeAll(connection, state, resultSet);
		}
		return recordList;
	}
	
	/**
	 * �����ݿ��м��뽻�׼�¼,����ɹ������棬���򷵻ؼ�
	 * 
	 * @param tr ����Ҫ���뽻�׼�¼
	 * @return true �� false
	 */
	public boolean insertTradeRecord(TradeRecord tr) {
		
		connection = DBManager.getConnection(); // �õ����ݿ�����

		StringBuffer sqlState = new StringBuffer();
		sqlState.append("INSERT INTO traderecord(userId,bookId,tradeNum,status) VALUES(?,?,?,?)");

		try {

			preState = connection.prepareStatement(sqlState.toString()); // ����Ԥ����ʽ

			// ����ÿ��Ҫ����ĵ�����
			preState.setInt(1, tr.getUserId());
			preState.setInt(2, tr.getBookId());
			preState.setInt(3, tr.getTradeNum());
			preState.setInt(4, tr.getStatus());
			
			preState.execute("begin"); // ����ʼ
			preState.executeUpdate();
			preState.execute("commit"); // �ύ�������

			System.out.println(" insert success!");	

			return true;
		} catch (SQLException e) {

			try {

				preState.execute("rollback"); // �ع�
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
