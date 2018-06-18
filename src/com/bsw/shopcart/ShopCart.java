package com.bsw.shopcart;

/**
 * �����ʵ�ֹ��ﳵ��ķ�װ
 * @author Student
 * @version 1.0.0
 */
public class ShopCart {
	
	/**
	 * ���ﳵ����ı��
	 */
	private int id;
	
	/**
	 * ���ﳵ��ĳ��Ʒ������
	 */
	private int num;
	
	/**
	 * ���ﳵ����û����
	 */
	private int userId;
	
	/**
	 * ����
	 */
	private String bookName;
	
	/**
	 * ��ļ�Ǯ
	 */
	private double price;
	
	/**
	 * ��ı��
	 */
	private int bookID;
	
	/**
	 * ���캯������ʼ�����ﳵ���ֶ�ֵ
	 * @param num �������
	 * @param userId �û��ı��
	 * @param bookName �������
	 * @param price ��ĵ���
	 * @param bookID ��ı��
	 */
	public ShopCart(int num,int userId,String bookName,double price,int bookID) {
		this.num = num;
		this.userId=userId;
		this.bookName = bookName;
		this.price = price;
		this.bookID = bookID;
	}
	
	/** �޲ι��캯�� */
	public ShopCart() {}
	
	/**
	 * ��ñ��
	 * @return ���
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * ������ı��
	 * @param id ���������ֶ�ֵ��Ϊ����ֵ
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * �������
	 * @return �������
	 */
	public int getNum() {
		return num;
	}
	
	/**
	 * �����������
	 * @param num	���������ֶ�ֵ��Ϊ����ֵ
	 */
	public void setNum(int num) {
		this.num = num;
	}
	
	/**
	 * ����û��ı��
	 * @return �û��ı��
	 */
	public int getUserId() {
		return userId;
	}
	
	/**
	 * �����û��ı��
	 * @param userId �û��ı��
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	/**
	 * ����������
	 * @return �������
	 */
	public String getBookName() {
		return bookName;
	}
	
	/**
	 * �����������
	 * @param bookName ���������ֶ�ֵ��Ϊ����ֵ
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	/**
	 * �����ļ�Ǯ
	 * @return ��ļ�Ǯ
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * ������ļ�Ǯ
	 * @param price �������ֶε�ֵ��Ϊ����ֵ
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * ������ı��
	 * @return ��ı��
	 */
	public int getBookID() {
		return bookID;
	}
	
	/**
	 * ������ı��
	 * @param bookID �Ӹ������ֶ���Ϊ����ֵ
	 */
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
}
