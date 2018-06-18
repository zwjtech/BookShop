package com.bsw.bookcategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bsw.db.DBManager;

/**
 * ����������
 * ��װ���ж�ͼ�����Ĳ���
 * 
 * @author Student 
 * @version 1.0.0
 *
 */
public class BookCategoryDAO {

	/**
	 * Statement���� 
	 */
	private Statement state = null;

	/**
	 * PreparedStatement����
	 */
	private PreparedStatement preState = null;

	/**
	 * ���������
	 */
	private ResultSet resultSet = null;

	/** 
	 * ���ݿ����������
	 */
	private Connection connection = null;
	
	/**
	 * ��ѯ����������
	 * @return ��Ų�ѯ���������������
	 */
	public ArrayList queryBookCategory(){
		
		ArrayList categoryList = new ArrayList();
		
		try {
			
			connection = DBManager.getConnection();
			state = connection.createStatement();
			String sql = "select * from  bookcategory";
			resultSet = state.executeQuery(sql); // ִ�� SQL ��ѯ����
			
			while(resultSet.next()){
				
				BookCategory category = new BookCategory();
				
				// ��ѯ����������
				category.setId(resultSet.getInt("id"));
				category.setName(resultSet.getString("name"));
				
				categoryList.add(category);
			}
			return categoryList;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			DBManager.closeAll(connection, state, resultSet);
		}
	}
	
	/**
	 * �ø���������ID��ѯ�����
	 * 
	 * @param categoryID ��������ID
	 * @return ��������
	 */
	public BookCategory queryByID(int categoryID){
		
		connection = DBManager.getConnection();
		String sql = "select * from  bookcategory WHERE id = " + categoryID;
		
		try {
			
			state = connection.createStatement();
			resultSet = state.executeQuery(sql);
			BookCategory category = new BookCategory();
			
			while(resultSet.next()){
				category.setName(resultSet.getString("name"));
			}
			return category;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
	}
	
	/**
	 * �ø�����������������ͼ�����
	 * @param name ��������������
	 */
	public void addBookCategory(String name){
		
		BookCategory bookCategory = new BookCategory();
		bookCategory.setName(name);
		
		try {
			
			connection = DBManager.getConnection();
			state = connection.createStatement();
			String sql = "insert into bookcategory(name) values(?);";
			preState = connection.prepareStatement(sql);
			preState.setString(1, name);
			
			preState.execute("begin"); // ����ʼ
			preState.executeUpdate();
			preState.execute("commit"); // �ύ�������
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.closeAll(connection, preState, resultSet);
		}		
	}
	
	/**
	 * ɾ��ͼ�����ͨ��id�ŵ���𣬲�ɾ������µ�����ͼ��
	 * @param id
	 */
	public boolean deleteBookCategory(int id){
		
		try {
			
			connection = DBManager.getConnection();
			state = connection.createStatement();
			String delBookSql = "delete from book where categoryId = "+id;// ɾ��������µ�����ͼ��
			String delCategorySql = "delete from bookcategory where id = "+id;
			state.execute("begin"); // ����
			state.execute(delBookSql);
			state.execute(delCategorySql);
			state.execute("commit");
			return true;
			
		} catch (Exception e) {
			
			try {
				state.execute("rollback");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
			
		}finally{
			DBManager.closeAll(connection, preState, resultSet);
		}		
	}
	/**
	 * ͨ������id�޸ĺ͸�������������޸ĸ��������
	 * @param name ����id
	 * @param id ����id
	 * @return ����
	 */
	public boolean modifyBookCategory(String name , int id){
		
		try {
			connection = DBManager.getConnection();
			state = connection.createStatement();
			String delBookSql = "update bookcategory set name = '"+ name +"' where id = " + id;
			state.execute(delBookSql);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			DBManager.closeAll(connection, preState, resultSet);
		}		
	}
	/**
	 * @param args
	 *//*  ����
	public static void main(String[] args) {
		// TODO �Զ����ɷ������
		BookCategoryDAO b = new BookCategoryDAO();
		//b.addBookCategory("wang");
		b.deleteBookCategory(2);
		b.modifyBookCategory("jizhongguo", 2);

	}*/

}
