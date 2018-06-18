package com.bsw.book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
 
import com.bsw.db.DBManager;


/**
 * 这给类封装图书的数据库操作
 * @author Student
 * @version 1.0.0  
 */
public class BookDAO  {

	// 供数据库连接的变量  
	private Connection connection = null;
	private ResultSet resultSet = null;
	private PreparedStatement preState = null;
	private Statement state = null;
	
	
	/**
	 * 无参构造函数
	 *
	 */
	public BookDAO(){}
	
	/**
	 * 插入Book对象到数据库中
	 * @param book 将要插入的Book对象
	 * @return 是否插入成功
	 */
	public boolean insertBook(Book book){
		
		// 获得数据库的连接对象
		connection = DBManager.getConnection();
		
		// 生成SQL代码
		StringBuffer sqlState = new StringBuffer();
		sqlState.append("INSERT INTO book(name,author,bookman,");
		sqlState.append("status,price,categoryId,introduction,total,currentNum,addTime)");
		sqlState.append(" VALUES(?,?,?,?,?,?,?,?,?,?)");
		
		// 设置数据库的字段值
		try {
			
			preState = connection.prepareStatement(sqlState.toString());
			preState.setString(1, book.getName());
			preState.setString(2, book.getAuthor());
			preState.setString(3, book.getBookman());
			preState.setInt(4, book.getStatus());
			preState.setDouble(5, book.getPrice());
			preState.setInt(6, book.getCategoryId());
			preState.setString(7, book.getIntroduction());
			preState.setInt(8, book.getTotal());
			preState.setInt(9, book.getCurrentNum());
			preState.setDate(10, book.getAddTime());
			//System.out.println(sqlState);
			// 设置事务的开始，并更新数据库，最后提交事务
			preState.execute("begin");
			preState.executeUpdate();
			preState.execute("commit");
			return true;
		} catch (SQLException e) {
			
			// 插入失败则回滚
			try {
				preState.execute("rollback");
			} catch (SQLException e1) {
				e1.printStackTrace();
				return false;
			}
			e.printStackTrace();
		} finally {
			DBManager.closeAll(connection, state, resultSet);
		}
		return false;
	}
	
	/**
	 * 删除给定ID的书
	 * 
	 * @param bookID 给定的书ID
	 * @return 真或假
	 */
	public boolean deleteBook(int bookID){
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try{
			
		    conn=DBManager.getConnection();
			stmt=conn.createStatement();
			String sqlStr="delete from book where id="+bookID;
			
			stmt.execute("begin"); // 事务保证删除成功
			stmt.executeUpdate(sqlStr);
			stmt.execute("commit");
			//System.out.println("delete success!");
			return true;
		}catch(SQLException e){
			
			try{
				
				stmt.execute("rollback"); // 回滚
			}catch(SQLException e1){
				e1.printStackTrace();
			}
			e.printStackTrace();
			return false;
		}finally{
			DBManager.closeAll(conn,stmt,rs);
		}
		
		
	}
	
	/**
	 * 查询所有书
	 * @return 存放全部书的容器
	 */
	public ArrayList queryBook(){
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList al = new ArrayList();
		
		
		try{
			
			conn=DBManager.getConnection();
			stmt=conn.createStatement();
			String sqlStr="select * from book";
			rs=stmt.executeQuery(sqlStr);
			
			while(rs.next()){
				
				// 封装数据库字段到对象
				Book book=new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setBookman(rs.getString("bookman"));
				book.setStatus(rs.getInt("status"));
				book.setPrice(rs.getDouble("price"));
				book.setCategoryId(rs.getInt("categoryId"));
				book.setAddTime(rs.getDate("addTime"));
				book.setTotal(rs.getInt("total"));
				book.setIntroduction(rs.getString("introduction"));
				
				al.add(book); // 加到容器
			}
            return al;
		}catch(Exception e){
			
			e.printStackTrace();
			return null;
		}finally{
			DBManager.closeAll(conn,stmt,rs);
		}
	}
	
	/**
	 * 用给定的书ID查询书对象
	 * 
	 * @param bookID 给定书的ID
	 * @return 一个book对象
	 */
	public Book queryBook(int bookID){
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		Book book=new Book();
		
		try {
			
			conn=DBManager.getConnection();
			stmt=conn.createStatement();
			String sqlStr="select * from book where id="+bookID;
			rs=stmt.executeQuery(sqlStr);
			
			while(rs.next()){
			
				//封装数据库字段到对象	
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setAuthor(rs.getString("author"));
				book.setBookman(rs.getString("bookman"));
				book.setStatus(rs.getInt("status"));
				book.setPrice(rs.getDouble("price"));
				book.setCategoryId(rs.getInt("categoryId"));
				book.setAddTime(rs.getDate("addTime"));
				book.setTotal(rs.getInt("total"));
				book.setIntroduction(rs.getString("introduction"));
				book.setCurrentNum(rs.getInt("currentNum"));
			
			}
            return book;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}finally{
			DBManager.closeAll(conn,stmt,rs);
		}
	}
	
	/**
	 * 用给定的对象更新数据库与所给定对象ID号相同记录
	 * 
	 * @param book 给定书的对象
	 * @return 真或假
	 */
	public boolean updateBook(Book book){
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		StringBuffer sqlStr=new StringBuffer();
		sqlStr.append("UPDATE book SET name=?,author=?");
		sqlStr.append(",bookman=?,status=?,price=?,categoryId=?,");
		sqlStr.append("addTime=?,currentNum=?,introduction=?");
		sqlStr.append("WHERE id=?");
		//System.out.println(sqlStr);
		
		try{
			
			conn=DBManager.getConnection();
			pstmt=conn.prepareStatement(sqlStr.toString());
			pstmt.setString(1, book.getName());
			pstmt.setString(2,book.getAuthor());
			pstmt.setString(3, book.getBookman());
			pstmt.setInt(4, book.getStatus());
			pstmt.setDouble(5, book.getPrice());
			pstmt.setInt(6, book.getCategoryId());
			pstmt.setDate(7, book.getAddTime());
			pstmt .setInt(8, book.getCurrentNum());
			pstmt.setString(9,book.getIntroduction());
			pstmt.setInt(10, book.getId());
			pstmt.execute("begin"); // 事务保证更新成功
			pstmt.executeUpdate();
			pstmt.execute("commit");
			//System.out.println("update success!!");
			return true;
			
		}catch(SQLException e){
			
			try{
				pstmt.execute("rollback");
			}catch(Exception e2){
				e2.printStackTrace();	
			}
			e.printStackTrace();
			return false;
			}finally{
				DBManager.closeAll(conn, pstmt, rs);
		}
	}
	
	/**
	 * 查询一个图书类别的所有图书
	 * @param categoryID 图书类别的编号
	 * @return 给定图书类别的所有图书列表
	 */
	public ArrayList queryByCategory(int categoryID){
		
		// 取得数据库连接
		connection = DBManager.getConnection();
		
		// SQL查询语句
		String sqlState = "SELECT * FROM book WHERE categoryId = " + categoryID;
		ArrayList books = new ArrayList();
		try {
			state = connection.createStatement();
			resultSet = state.executeQuery(sqlState);
			
			// 设置Book对象的属性
			while(resultSet.next()){
				
				Book book = new Book();
				book.setId(resultSet.getInt("id"));
				book.setName(resultSet.getString("name"));
				book.setAuthor(resultSet.getString("author"));
				book.setBookman(resultSet.getString("bookman"));
				book.setCategoryId(resultSet.getInt("categoryId"));
				book.setPrice(resultSet.getDouble("price"));
				book.setStatus(resultSet.getInt("status"));
				book.setIntroduction(resultSet.getString("introduction"));
				book.setAddTime(resultSet.getDate("addTime"));
				book.setTotal(resultSet.getInt("total"));
				book.setCurrentNum(resultSet.getInt("currentNum"));
				
				books.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBManager.closeAll(connection, state, resultSet);
		}
		return books;
	}
	
	
	/**
	 * 查询最新的书
	 * @return 存放最新书的容器
	 */
	public ArrayList queryNewBooks(){
		
		connection = DBManager.getConnection();
		ArrayList books = new ArrayList();
		
		// 根据书加入的时间排序（降序排列）
		String sqlState = "SELECT * FROM book ORDER BY addTime DESC";
		int total = 0;
		
		try {
			
			state = connection.createStatement();
			resultSet = state.executeQuery(sqlState);
			
			while(resultSet.next()){
				
				Book book = new Book();
				
				book.setId(resultSet.getInt("id"));
				book.setName(resultSet.getString("name"));
				book.setAuthor(resultSet.getString("author"));
				book.setBookman(resultSet.getString("bookman"));
				book.setCategoryId(resultSet.getInt("categoryId"));
				book.setPrice(resultSet.getDouble("price"));
				book.setStatus(resultSet.getInt("status"));
				book.setIntroduction(resultSet.getString("introduction"));
				book.setAddTime(resultSet.getDate("addTime"));
				book.setTotal(resultSet.getInt("total")); 
				book.setCurrentNum(resultSet.getInt("currentNum"));
				
				total += 1;
				books.add(book);
				
				if(total == 5){ // 取最新5本为最新的书
					break;
				}
			}
			return books; 
		} catch (SQLException e) {
			
			e.printStackTrace();
			return null;
		} finally {
			DBManager.closeAll(connection, state, resultSet);
		}
	}
	
	/**
	 * 用给定库存量更新给定ID 的现有库存量
	 * 
	 * @param num 给定库存量
	 * @param id 给定ID
	 * @return
	 */
	public boolean updateCurrentNum(int num,int id){
		
		connection = DBManager.getConnection();
		
		try {
			
			state = connection.createStatement();
			String sqlState = "update book set currentNum =  currentNum +"
					+ num + " where id =  " + id;
			state.execute(sqlState);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}finally{
			DBManager.closeAll(connection, state, resultSet);
		}
	}
	

	////////////测试//////////////////
/*	public static void main(String[] args) {
	BookDAO bookDAO = new BookDAO();
		Book book = new Book();
		book.setName("liyazhou");
		book.setAuthor("liyazhou");
		book.setCategoryId(1);
		book.setIntroduction("liyazhou");
		book.setPrice(0.1);
		book.setStatus(1);
		book.setBookman("liyazhou");
		book.setCurrentNum(10);
		book.setTotal(10);
		bookDAO.insertBook(book);
		//ArrayList books = bookDAO.queryByCategory(1);
		//System.out.println(books.size());
		ArrayList books = bookDAO.queryNewBooks();
		System.out.println(books.size());
		for(int i = 0; i < books.size(); i++){
			System.out.println(((Book)books.get(i)).getAddTime());
			
		}
		//bookDAO.updateCurrentNum(4, 1);
		
	}*/
}
