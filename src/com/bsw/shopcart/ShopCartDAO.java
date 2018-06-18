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
 * 这个类实现购物车的逻辑操作的封装
 * @author Student
 * @version 1.0.0
 */
public class ShopCartDAO {

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
	 * 查询用户购物车里的商品信息
	 * @param userId 用户的编号
	 * @return 由用户书集构成的集合
	 */
	public ArrayList queryBook(int userId){
		connection = DBManager.getConnection();
		ArrayList list = new ArrayList();
		String sql = "select * from shopcart where userId = "+userId;
		try{
			state = connection.createStatement();
			resultSet = state.executeQuery(sql);
			while(resultSet.next()){
				// 设置购物车项的属性
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
			// 关闭数据库连接
			DBManager.closeAll(connection, state, resultSet);
		}
	}
	
	/**
	 * 根据编号查询具体的购物车项
	 * @param id 购物车项的编号
	 * @return 购物车项
	 */
	public ShopCart queryByID(int id){
		connection = DBManager.getConnection();
		String sql = "select * from shopcart where id = "+id;
		ShopCart shopCart = null;
		try{ 
			state = connection.createStatement();
			resultSet = state.executeQuery(sql);
			
			if(resultSet.next()){
				
				// 设置购物车项的属性
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
			// 关闭数据库连接
			DBManager.closeAll(connection, state, resultSet);
		}
	}
	
	/**
	 * 向购物车中加入书集
	 * @param shopcart 购物车项
	 * @return 一个特定的购物车项
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
					
					// 事务的开始
					preState.execute("begin");
					preState.executeUpdate();
					
					// 提交事务
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
	 * 更新一个购物车项
	 * @param shopcart 一个特定的购物车项
	 * @return 是否更新成功
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
			// TODO 自动生成 catch 块
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
	 * 删除一个购物车项
	 * @param id 要删除的购物车项的编号
	 * @return 是否删除成功
	 */
	public boolean deleteItem(int id){
		
		connection = DBManager.getConnection();
		String sqlState = "DELETE FROM shopcart WHERE id = " + id ;
		try {
			state = connection.createStatement();
			// 事物的开始
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
	 * 修改一个购物车项
	 * @param id 要修改的购物车项的编号
	 * @param num 购物车项的数量
	 * @return 是否更新成功
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
