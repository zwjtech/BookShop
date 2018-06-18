package com.bsw.user;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Locale;

import com.bsw.db.DBManager;
/**
 * User（用户） 管理类
 * 可以从数据库 查询，插入，删除 订单
 * @author Student
 * @version 1.0.0
 * @see User
 *
 */
public class UserDAO {

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
	 * 数据库连接的包装类对象
	 */
	private DBManager dbManager = null;

	/** 
	 * 构造函数
	 */
	public UserDAO() {
		//dbManager = new DBManager(); // 得到一个数据库管理对象
	}
	
	public ArrayList queryUser() {
		connection = DBManager.getConnection();
		String sqlState = "SELECT * FROM user";
		User user = new User();
		ArrayList arrayList = new ArrayList();
		try {

			state = connection.createStatement();
			resultSet = state.executeQuery(sqlState); // 执行sql查询
			
			while (resultSet.next()) {
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setPass(resultSet.getString("pass"));
				user.setRole(resultSet.getInt("role"));
				user.setRealName(resultSet.getString("realName"));
				user.setAge(resultSet.getInt("age"));
				user.setGender(resultSet.getString("gender"));
				user.setPhone(resultSet.getString("phone"));
				user.setEmail(resultSet.getString("email"));
				user.setAddress(resultSet.getString("address"));
				user.setRegisterTime(resultSet.getDate("registerTime"));
				arrayList.add(user);
			}
			return arrayList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBManager.closeAll(connection, state, resultSet);
		}
	}
	/**
	 * 用给定的用户名查询用户
	 * 
	 * @param name 给定的name
	 * @return 要查询的User
	 */
	public User queryUser(String name) {

		connection = DBManager.getConnection();
		String sqlState = "SELECT * FROM user WHERE name = '" + name + "'";
		User user = null;
		try {

			state = connection.createStatement();
			resultSet = state.executeQuery(sqlState); // 执行sql查询
			
			while (resultSet.next()) {
				user = new User();
				user.setId(resultSet.getInt("id"));
				user.setName(resultSet.getString("name"));
				user.setPass(resultSet.getString("pass"));
				user.setRole(resultSet.getInt("role"));
				user.setRealName(resultSet.getString("realName"));
				user.setAge(resultSet.getInt("age"));
				user.setGender(resultSet.getString("gender"));
				user.setPhone(resultSet.getString("phone"));
				user.setEmail(resultSet.getString("email"));
				user.setAddress(resultSet.getString("address"));
				user.setRegisterTime(resultSet.getDate("registerTime"));
			}
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally {
			DBManager.closeAll(connection, state, resultSet);
		}
	}
	
	/**
	 * 向数据库插入一个用户
	 * 如果插入成功 返回 true,否则返回 false
	 * 
	 * @param order 给定要插入的order对象
	 * @return true 或 false
	 */
	public boolean insertUser(User user) {

		connection = DBManager.getConnection(); // 得到数据库连接

		StringBuffer sqlState = new StringBuffer();
		sqlState.append("INSERT INTO user(name,pass,role,");
		sqlState.append("realName,gender,age,phone,email,address,registerTime");
		sqlState.append(")VALUES(?,?,?,?,?,?,?,?,?,?)");
		System.out.println(sqlState);
		try {

			preState = connection.prepareStatement(sqlState.toString()); // 采用预处理方式

			preState.setString(1, user.getName()); // 设置每个要插入的的属性
			preState.setString(2, user.getPass());
			preState.setInt(3, user.getRole());
			preState.setString(4, user.getRealName());
			preState.setString(5, user.getGender());
			preState.setInt(6, user.getAge());
			preState.setString(7, user.getPhone());
			preState.setString(8, user.getEmail());
			preState.setString(9, user.getAddress());
			preState.setDate(10, user.getRegisterTime());
			
		//	preState.execute("begin"); // 事务开始
			preState.executeUpdate();
		//	preState.execute("commit"); // 提交插入操作	
			return true;
		} catch (SQLException e) {

			/*try {
				preState.execute("rollback"); // 回滚
			} catch (SQLException e1) {
				e1.printStackTrace();
			}*/
			e.printStackTrace();
			return false;
		} finally {
			DBManager.closeAll(connection, preState, resultSet);
		}
	}
	
	/**
	 * 删除一个指定编号的用户
	 * 如果删除成功返回true,否则返回 false
	 * 
	 * @param id给定的User的编号
	 * @return true或false
	 */
	public boolean deleteUser(int id) {

		try {
			connection = DBManager.getConnection(); // 获得一个数据库连接
			state = connection.createStatement();

			state.execute("begin"); // 事务开始 
			state.executeUpdate("DELETE FROM user WHERE id='" + id+ "'");
			System.out.println(id);
			state.execute("commit"); // 提交事务
			return true;
		} catch (Exception e) {

			try {
				state.execute("rollback"); // 如果出现异常数据库回滚
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
	 * @param args
	 * @throws ParseException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws ParseException {
		//Calendar.getInstance().getTimeInMillis();
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.FRANCE);
		DateFormat d = DateFormat.getDateInstance();
		Date date = new Date(d.parse("2007-06-3").getTime());
		//Date date = new Date(Calendar."2007-06-3");
//		(String name, String pass, int role, 
//				String realName, int age, String gender, String phone, String email, 
//				String address, String postcode, Date registerTime)		
		User user = new User("wang","wang",0,"wang",23,"男","88454060",
				"wwangli","nwpu","710065",date);
		UserDAO userDAO = new UserDAO();
		
		userDAO.insertUser(user);
		Date address = ((User)(userDAO.queryUser().get(0))).getRegisterTime();
		
		System.out.println(address);
		//userDAO.queryUser(2);
		//boolean b = userDAO.deleteOrder(1);
		System.out.println("fadf");
	}

}
