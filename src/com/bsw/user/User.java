package com.bsw.user;

import java.sql.Date;
/**
 * @author Student
 *
 */
public class User {
	
	/**
	 * �û�id
	 */
	private int id;
	
	/**
	 * �û���
	 */
	private String name;
	
	/**
	 * �û�����
	 */
	private String pass;
	
	/**
	 * ��ɫ��0Ϊ����Ա��1Ϊ��ͨ�û�
	 */
	private int role;
	
	/**
	 * �û���ʵ����
	 */
	private String realName;
	
	/**
	 * �û�����
	 */
	private int age;
	
	/**
	 * �û��Ա�
	 */
	private String gender;
	
	/**
	 * �û��绰
	 */
	private String phone;
	
	/**
	 * �û������ʼ�
	 */
	private String email;
	
	/**
	 * �û���ַ
	 */
	private String address;
	
	/**
	 * �û��ʱ�
	 */
	private String postcode;
	
	/**
	 * �û�ע��ʱ��
	 */
	private Date registerTime;
	/**
	 * User���޲ι��캯��
	 */
	public User(){}
	
	/**
	 * User���вι��캯��
	 * @param name �û���
	 * @param pass �û�����
	 * @param role ��ɫ��0Ϊ����Ա��1Ϊ��ͨ�û�
	 * @param realName �û���ʵ����
	 * @param age �û�����
	 * @param gender �û��Ա�
	 * @param phone �û��绰
	 * @param email �û������ʼ�
	 * @param address �û���ַ
	 * @param postcode �û��ʱ�
	 * @param registerTime �û�ע��ʱ��
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
	 * �����û���ַ
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * �����û���ַ
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * �����û�����
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * �����û�����
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * ����û�id
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * �����û�id
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * ����û�������
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * �����û�����
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ����û�����
	 * @return pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * �����û�����
	 * @param pass
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * ����û��绰����
	 * @return phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * �����û��绰����
	 * @param phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * ����û�����
	 * @return pID
	 */
	public int getAge() {
		return age;
	}

	/**
	 * �����û�����
	 * @param pid
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * ����û��Ա�
	 * @return sex
	 */
	public String getGender() {
		return gender;
	}
	
	/**
	 * �����û��Ա�
	 * @param sex
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	 * ����û����ʱ�
	 * @return postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * �����û����ʱ�
	 * @param postcode
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * ����û���ʵ����
	 * @return realName
	 */
	public String getRealName() {
		return realName;
	}

	/**
	 * �����û���ʵ����
	 * @param realName
	 */
	public void setRealName(String realName) {
		this.realName = realName;
	}

	/**
	 * ����û���ɫ
	 * @return role
	 */ 
	public int getRole() {
		return role;
	}

	/**
	 * �����û���ɫ
	 * @param role
	 */
	public void setRole(int role) {
		this.role = role;
	}
	
	/**
	 * ����û�ע��ʱ��
	 */
	public Date getRegisterTime() {
		return registerTime;
	}
	
	/**
	 * �����û�ע��ʱ��
	 */
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
}
