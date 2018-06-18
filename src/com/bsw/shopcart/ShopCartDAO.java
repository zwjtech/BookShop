package com.bsw.shopcart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bsw.book.Book;
import com.bsw.book.BookDAO;
import com.bsw.db.DBManager;

/**
 * �����ʵ�ֹ��ﳵ���߼������ķ�װ
 * @author Student
 * @version 1.0.0
 */
public class ShopCartDAO {

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
	 * ��ѯ�û����ﳵ�����Ʒ��Ϣ
	 * @param userId �û��ı��
	 * @return ���û��鼯���ɵļ���
	 */
	public ArrayList queryBook(int userId){
		connection = DBManager.getConnection();
		ArrayList list = new ArrayList();
		String sql = "select * from shopcart where userId = "+userId;
		try{
			state = connection.createStatement();
			resultSet = state.executeQuery(sql);
			while(resultSet.next()){
				// ���ù��ﳵ�������
				ShopCart shopCart = new ShopCart();
				shopCart.setId(resultSet.getInt("id"));
				shopCart.setNum(resultSet.getInt("num"));
				shopCart.setBookName(resultSet.getString("bookName"));
				shopCart.setPrice(resultSet.getDouble("price"));
				shopCart.setBookID(resultSet.getInt("bookId"));
				list.add(shopCart);
			}
			return list;
		}catch(Exception e){
			return null;
		}finally{
			// �ر����ݿ�����
			DBManager.closeAll(connection, state, resultSet);
		}
	}
	
	/**
	 * ���ݱ�Ų�ѯ����Ĺ��ﳵ��
	 * @param id ���ﳵ��ı��
	 * @return ���ﳵ��
	 */
	public ShopCart queryByID(int id){
		connection = DBManager.getConnection();
		String sql = "select * from shopcart where id = "+id;
		ShopCart shopCart = null;
		try{ 
			state = connection.createStatement();
			resultSet = state.executeQuery(sql);
			
			if(resultSet.next()){
				
				// ���ù��ﳵ�������
				shopCart = new ShopCart();
				shopCart.setId(resultSet.getInt("id"));
				shopCart.setNum(resultSet.getInt("num"));
				shopCart.setBookName(resultSet.getString("bookName"));
				shopCart.setBookID(resultSet.getInt("bookId"));
				shopCart.setPrice(resultSet.getDouble("price"));
			}
			return shopCart;
		}catch(Exception e){
			return null;
		}finally{
			// �ر����ݿ�����
			DBManager.closeAll(connection, state, resultSet);
		}
	}
	
	/**
	 * ���ﳵ�м����鼯
	 * @param shopcart ���ﳵ��
	 * @return һ���ض��Ĺ��ﳵ��
	 */
	public boolean insertItem(ShopCart shopcart){
			connection = DBManager.getConnection(); 
			try {
				state = connection.createStatement();
				String sql = "select * from shopcart where bookName = '"+shopcart.getBookName() + "'";
				resultSet = state.executeQuery(sql);
				if(resultSet.next()){
					shopcart.setId(resultSet.getInt("id"));
					this.upDateItem(shopcart);
					return true;
				} else {
					String sqlState = "INSERT INTO shopcart(userId,num,bookName,price,bookId) VALUES(?,?,?,?,?)";
					preState = connection.prepareStatement(sqlState);
					preState.setInt(1, shopcart.getUserId());
					preState.setInt(2, shopcart.getNum()); 
					preState.setString(3, shopcart.getBookName());
					preState.setDouble(4,shopcart.getPrice());
					preState.setInt(5, shopcart.getBookID());
					
					// ����Ŀ�ʼ
					preState.execute("begin");
					preState.executeUpdate();
					
					// �ύ����
					preState.execute("commit");
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			} finally {
				DBManager.closeAll(connection, state, resultSet);
			}
		}
	
	/**
	 * ����һ�����ﳵ��
	 * @param shopcart һ���ض��Ĺ��ﳵ��
	 * @return �Ƿ���³ɹ�
	 */
	public boolean upDateItem(ShopCart shopcart){
		connection = DBManager.getConnection();
		String sql = "select num from shopcart where id = " + shopcart.getId();
		int num = 0;
		try {
			state = connection.createStatement();
			resultSet = state.executeQuery(sql);
			resultSet.first();
			num = resultSet.getInt("num");
		} catch (SQLException e2) {
			// TODO �Զ����� catch ��
			e2.printStackTrace();
		}
		num += shopcart.getNum();
		String sqlState = "UPDATE shopcart SET num = " + num;
		sqlState += " WHERE id=" + shopcart.getId();
		System.out.println(sqlState); 
		boolean success = false;
		try {
			state = connection.createStatement();
			state.execute("begin");
			state.executeUpdate(sqlState);
			state.execute("commit");
			success = true;
		} catch (SQLException e) {
			try {
				state.execute("rollback");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return success;
	}
	
	/**
	 * ɾ��һ�����ﳵ��
	 * @param id Ҫɾ���Ĺ��ﳵ��ı��
	 * @return �Ƿ�ɾ���ɹ�
	 */
	public boolean deleteItem(int id){
		
		connection = DBManager.getConnection();
		String sqlState = "DELETE FROM shopcart WHERE id = " + id ;
		try {
			state = connection.createStatement();
			// ����Ŀ�ʼ
			state.execute("begin");
			state.executeUpdate(sqlState);
			state.execute("commit");
			return true;
		} catch (SQLException e) {
			try {
				state.execute("rollback");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		} finally {
			DBManager.closeAll(connection, state, resultSet);
		}
	}
	
	/**
	 * �޸�һ�����ﳵ��
	 * @param id Ҫ�޸ĵĹ��ﳵ��ı��
	 * @param num ���ﳵ�������
	 * @return �Ƿ���³ɹ�
	 */
	public boolean modifyNum(int id,int num){
		connection = DBManager.getConnection();
		String sqlState = "update shopcart set num = " + num +" where id = " + id ;
		try {
			state = connection.createStatement();
			state.execute("begin");
			state.executeUpdate(sqlState);
			state.execute("commit");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			DBManager.closeAll(connection, state, resultSet);
		}		
	}
}
