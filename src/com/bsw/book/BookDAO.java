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
 * ������װͼ������ݿ����
 * @author Student
 * @version 1.0.0  
 */
public class BookDAO  {

	// �����ݿ����ӵı���  
	private Connection connection = null;
	private ResultSet resultSet = null;
	private PreparedStatement preState = null;
	private Statement state = null;
	
	
	/**
	 * �޲ι��캯��
	 *
	 */
	public BookDAO(){}
	
	/**
	 * ����Book�������ݿ���
	 * @param book ��Ҫ�����Book����
	 * @return �Ƿ����ɹ�
	 */
	public boolean insertBook(Book book){
		
		// ������ݿ�����Ӷ���
		connection = DBManager.getConnection();
		
		// ����SQL����
		StringBuffer sqlState = new StringBuffer();
		sqlState.append("INSERT INTO book(name,author,bookman,");
		sqlState.append("status,price,categoryId,introduction,total,currentNum,addTime)");
		sqlState.append(" VALUES(?,?,?,?,?,?,?,?,?,?)");
		
		// �������ݿ���ֶ�ֵ
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
			// ��������Ŀ�ʼ�����������ݿ⣬����ύ����
			preState.execute("begin");
			preState.executeUpdate();
			preState.execute("commit");
			return true;
		} catch (SQLException e) {
			
			// ����ʧ����ع�
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
	 * ɾ������ID����
	 * 
	 * @param bookID ��������ID
	 * @return ����
	 */
	public boolean deleteBook(int bookID){
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try{
			
		    conn=DBManager.getConnection();
			stmt=conn.createStatement();
			String sqlStr="delete from book where id="+bookID;
			
			stmt.execute("begin"); // ����֤ɾ���ɹ�
			stmt.executeUpdate(sqlStr);
			stmt.execute("commit");
			//System.out.println("delete success!");
			return true;
		}catch(SQLException e){
			
			try{
				
				stmt.execute("rollback"); // �ع�
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
	 * ��ѯ������
	 * @return ���ȫ���������
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
				
				// ��װ���ݿ��ֶε�����
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
				
				al.add(book); // �ӵ�����
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
	 * �ø�������ID��ѯ�����
	 * 
	 * @param bookID �������ID
	 * @return һ��book����
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
			
				//��װ���ݿ��ֶε�����	
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
	 * �ø����Ķ���������ݿ�������������ID����ͬ��¼
	 * 
	 * @param book ������Ķ���
	 * @return ����
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
			pstmt.execute("begin"); // ����֤���³ɹ�
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
	 * ��ѯһ��ͼ����������ͼ��
	 * @param categoryID ͼ�����ı��
	 * @return ����ͼ����������ͼ���б�
	 */
	public ArrayList queryByCategory(int categoryID){
		
		// ȡ�����ݿ�����
		connection = DBManager.getConnection();
		
		// SQL��ѯ���
		String sqlState = "SELECT * FROM book WHERE categoryId = " + categoryID;
		ArrayList books = new ArrayList();
		try {
			state = connection.createStatement();
			resultSet = state.executeQuery(sqlState);
			
			// ����Book���������
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
	 * ��ѯ���µ���
	 * @return ��������������
	 */
	public ArrayList queryNewBooks(){
		
		connection = DBManager.getConnection();
		ArrayList books = new ArrayList();
		
		// ����������ʱ�����򣨽������У�
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
				
				if(total == 5){ // ȡ����5��Ϊ���µ���
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
	 * �ø�����������¸���ID �����п����
	 * 
	 * @param num ���������
	 * @param id ����ID
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
	

	////////////����//////////////////
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
