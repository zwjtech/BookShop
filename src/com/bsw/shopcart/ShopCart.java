package com.bsw.shopcart;

/**
 * 这个类实现购物车类的封装
 * @author Student
 * @version 1.0.0
 */
public class ShopCart {
	
	/**
	 * 购物车里书的编号
	 */
	private int id;
	
	/**
	 * 购物车里某商品的数量
	 */
	private int num;
	
	/**
	 * 购物车里的用户编号
	 */
	private int userId;
	
	/**
	 * 书名
	 */
	private String bookName;
	
	/**
	 * 书的价钱
	 */
	private double price;
	
	/**
	 * 书的编号
	 */
	private int bookID;
	
	/**
	 * 构造函数，初始化购物车的字段值
	 * @param num 书的数量
	 * @param userId 用户的编号
	 * @param bookName 书的名称
	 * @param price 书的单价
	 * @param bookID 书的编号
	 */
	public ShopCart(int num,int userId,String bookName,double price,int bookID) {
		this.num = num;
		this.userId=userId;
		this.bookName = bookName;
		this.price = price;
		this.bookID = bookID;
	}
	
	/** 无参构造函数 */
	public ShopCart() {}
	
	/**
	 * 获得编号
	 * @return 编号
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 设置书的编号
	 * @param id 将给定的字段值设为给定值
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 获得数量
	 * @return 书的数量
	 */
	public int getNum() {
		return num;
	}
	
	/**
	 * 设置书的数量
	 * @param num	将给定的字段值设为给定值
	 */
	public void setNum(int num) {
		this.num = num;
	}
	
	/**
	 * 获得用户的编号
	 * @return 用户的编号
	 */
	public int getUserId() {
		return userId;
	}
	
	/**
	 * 设置用户的编号
	 * @param userId 用户的编号
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	/**
	 * 获得书的名称
	 * @return 书的名称
	 */
	public String getBookName() {
		return bookName;
	}
	
	/**
	 * 设置书的名称
	 * @param bookName 将给定的字段值设为给定值
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
	/**
	 * 获得书的价钱
	 * @return 书的价钱
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * 设置书的价钱
	 * @param price 将给定字段的值设为给定值
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * 获得数的编号
	 * @return 书的编号
	 */
	public int getBookID() {
		return bookID;
	}
	
	/**
	 * 设置书的编号
	 * @param bookID 加给定的字段设为给定值
	 */
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
}
