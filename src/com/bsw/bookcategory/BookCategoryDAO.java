package com.bsw.bookcategory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.bsw.db.DBManager;

/**
 * 功能描述：
 * 封装所有对图书类别的操作
 * 
 * @author Student 
 * @version 1.0.0
 *
 */
public class BookCategoryDAO {

	/**
	 * Statement对象 
	 */
	private Statement state = null;

	/**
	 * PreparedStatement对象
	 */
	private PreparedStatement preState = null;

	/**
	 * 结果集对象
	 */
	private ResultSet resultSet = null;

	/** 
	 * 数据库连接类对象
	 */
	private Connection connection = null;
	
	/**
	 * 查询所有书的类别
	 * @return 存放查询所有书的类别的容器
	 */
	public ArrayList queryBookCategory(){
		
		ArrayList categoryList = new ArrayList();
		
		try {
			
			connection = DBManager.getConnection();
			state = connection.createStatement();
			String sql = "select * from  bookcategory";
			resultSet = state.executeQuery(sql); // 执行 SQL 查询操作
			
			while(resultSet.next()){
				
				BookCategory category = new BookCategory();
				
				// 查询所有书的类别
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
	 * 用给定的书类ID查询书类别
	 * 
	 * @param categoryID 定的书类ID
	 * @return 书类别对象
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
	 * 用给定书类别的名称增加图书类别
	 * @param name 给定书类别的名称
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
			
			preState.execute("begin"); // 事务开始
			preState.executeUpdate();
			preState.execute("commit"); // 提交插入操作
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBManager.closeAll(connection, preState, resultSet);
		}		
	}
	
	/**
	 * 删除图书类别，通过id着到类别，并删除类别下的所有图书
	 * @param id
	 */
	public boolean deleteBookCategory(int id){
		
		try {
			
			connection = DBManager.getConnection();
			state = connection.createStatement();
			String delBookSql = "delete from book where categoryId = "+id;// 删除该类别下的所有图书
			String delCategorySql = "delete from bookcategory where id = "+id;
			state.execute("begin"); // 事务
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
	 * 通过给定id修改和给定的类别名称修改给定的类别
	 * @param name 给定id
	 * @param id 给定id
	 * @return 真或假
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
	 *//*  测试
	public static void main(String[] args) {
		// TODO 自动生成方法存根
		BookCategoryDAO b = new BookCategoryDAO();
		//b.addBookCategory("wang");
		b.deleteBookCategory(2);
		b.modifyBookCategory("jizhongguo", 2);

	}*/

}
