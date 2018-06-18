package com.bsw.user;

import java.sql.Date;
/**
 * @author Student
 *
 */
public class User {
	
	/**
	 * 用户id
	 */
	private int id;
	
	/**
	 * 用户名
	 */
	private String name;
	
	/**
	 * 用户密码
	 */
	private String pass;
	
	/**
	 * 角色：0为管理员，1为普通用户
	 */
	private int role;
	
	/**
	 * 用户真实姓名
	 */
	private String realName;
	
	/**
	 * 用户年龄
	 */
	private int age;
	
	/**
	 * 用户性别
	 */
	private String gender;
	
	/**
	 * 用户电话
	 */
	private String phone;
	
	/**
	 * 用户电子邮件
	 */
	private String email;
	
	/**
	 * 用户地址
	 */
	private String address;
	
	/**
	 * 用户邮编
	 */
	private String postcode;
	
	/**
	 * 用户注册时间
	 */
	private Date registerTime;
	/**
	 * User的无参构造函数
	 */
	public User(){}
	
	/**
	 * User的有参构造函数
	 * @param name 用户名
	 * @param pass 用户密码
	 * @param role 角色：0为管理员，1为普通用户
	 * @param realName 用户真实姓名
	 * @param age 用户年龄
	 * @param gender 用户性别
	 * @param phone 用户电话
	 * @param email 用户电子邮件
	 * @param address 用户地址
	 * @param postcode 用户邮编
	 * @param registerTime 用户注册时间
	 */
	public User(String name, String pass, int role, 
			String realName, int age, String gender, String phone, String email, 
			String address, String postcode, Date registerTime) {
		this.name = name;
		this.pass = pass;
		this.role = role;
		this.realName = realName;
		this.age = age;
		this.gender = gender;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.postcode = postcode;
		this.registerTime = registerTime;
	}

	/**
	 * 返回用户地址
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置用户地址
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 返回用户邮箱
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 设置用户邮箱
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 获得用户id
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置用户id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获得用户的姓名
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置用户姓名
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获得用户密码
	 * @return pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * 设置用户密码
	 * @param pass
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * 获得用户电话号码
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 设置用户电话号码
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 获得用户年龄
	 * @return pID
	 */
	public int getAge() {
		return age;
	}

	/**
	 * 设置用户年龄
	 * @param pid
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * 获得用户性别
	 * @return sex
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * 设置用户性别
	 * @param sex
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * 获得用户的邮编
	 * @return postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * 设置用户的邮编
	 * @param postcode
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * 获得用户真实姓名
	 * @return realName
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * 设置用户真实姓名
	 * @param realName
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * 获得用户角色
	 * @return role
	 */ 
	public int getRole() {
		return role;
	}

	/**
	 * 设置用户角色
	 * @param role
	 */
	public void setRole(int role) {
		this.role = role;
	}
	
	/**
	 * 获得用户注册时间
	 */
	public Date getRegisterTime() {
		return registerTime;
	}
	
	/**
	 * 设置用户注册时间
	 */
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
}
