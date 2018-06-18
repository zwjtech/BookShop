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
 * User���û��� ������
 * ���Դ����ݿ� ��ѯ�����룬ɾ�� ����
 * @author Student
 * @version 1.0.0
 * @see User
 *
 */
public class UserDAO {

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
	 * ���ݿ����ӵİ�װ�����
	 */
	private DBManager dbManager = null;

	/** 
	 * ���캯��
	 */
	public UserDAO() {
		//dbManager = new DBManager(); // �õ�һ�����ݿ�������
	}
	
	public ArrayList queryUser() {
		connection = DBManager.getConnection();
		String sqlState = "SELECT * FROM user";
		User user = new User();
		ArrayList arrayList = new ArrayList();
		try {

			state = connection.createStatement();
			resultSet = state.executeQuery(sqlState); // ִ��sql��ѯ
			
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
	 * �ø������û�����ѯ�û�
	 * 
	 * @param name ������name
	 * @return Ҫ��ѯ��User
	 */
	public User queryUser(String name) {

		connection = DBManager.getConnection();
		String sqlState = "SELECT * FROM user WHERE name = '" + name + "'";
		User user = null;
		try {

			state = connection.createStatement();
			resultSet = state.executeQuery(sqlState); // ִ��sql��ѯ
			
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
	 * �����ݿ����һ���û�
	 * �������ɹ� ���� true,���򷵻� false
	 * 
	 * @param order ����Ҫ�����order����
	 * @return true �� false
	 */
	public boolean insertUser(User user) {

		connection = DBManager.getConnection(); // �õ����ݿ�����

		StringBuffer sqlState = new StringBuffer();
		sqlState.append("INSERT INTO user(name,pass,role,");
		sqlState.append("realName,gender,age,phone,email,address,registerTime");
		sqlState.append(")VALUES(?,?,?,?,?,?,?,?,?,?)");
		System.out.println(sqlState);
		try {

			preState = connection.prepareStatement(sqlState.toString()); // ����Ԥ����ʽ

			preState.setString(1, user.getName()); // ����ÿ��Ҫ����ĵ�����
			preState.setString(2, user.getPass());
			preState.setInt(3, user.getRole());
			preState.setString(4, user.getRealName());
			preState.setString(5, user.getGender());
			preState.setInt(6, user.getAge());
			preState.setString(7, user.getPhone());
			preState.setString(8, user.getEmail());
			preState.setString(9, user.getAddress());
			preState.setDate(10, user.getRegisterTime());
			
		//	preState.execute("begin"); // ����ʼ
			preState.executeUpdate();
		//	preState.execute("commit"); // �ύ�������	
			return true;
		} catch (SQLException e) {

			/*try {
				preState.execute("rollback"); // �ع�
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
	 * ɾ��һ��ָ����ŵ��û�
	 * ���ɾ���ɹ�����true,���򷵻� false
	 * 
	 * @param id������User�ı��
	 * @return true��false
	 */
	public boolean deleteUser(int id) {

		try {
			connection = DBManager.getConnection(); // ���һ�����ݿ�����
			state = connection.createStatement();

			state.execute("begin"); // ����ʼ 
			state.executeUpdate("DELETE FROM user WHERE id='" + id+ "'");
			System.out.println(id);
			state.execute("commit"); // �ύ����
			return true;
		} catch (Exception e) {

			try {
				state.execute("rollback"); // ��������쳣���ݿ�ع�
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
		User user = new User("wang","wang",0,"wang",23,"��","88454060",
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
