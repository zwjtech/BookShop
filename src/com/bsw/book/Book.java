package com.bsw.book;

import java.sql.Date;



/**
 * 封装book表的数据库字段,字段名对应book表的字段名
 * 
 * @author Student
 * @version 1.0.0
 */
public class Book {

	/**
	 * 图书的编号
	 */
	private int id;

	/**
	 * 图书的姓名
	 */
	private String name;

	/**
	 * 图书的作者
	 */
	private String author;

	/**
	 * 图书的出版社
	 */
	private String bookman;

	/**
	 * 图书的状态 0缺货 1有货 2待出版
	 */
	private int status;

	/**
	 * 图书的单价
	 */
	private double price;

	/**
	 * 图书所在的图书类别的编号
	 */
	private int categoryId;
	
	/**
	 * 图书的上架时间
	 */
	private Date addTime;
	
	/**
	 * 图书的入库数量
	 */
	private int total;
	
	/**
	 * 图书的现有库存
	 */
	private int currentNum;

	/**
	 * 图书的简介
	 */
	private String introduction;
	
	/**
	 * 无参构造函数
	 */
	public Book() {}
	
	/**
	 * 用以初始化Book对象
	 * @param name 图书的书名
	 * @param author 图书的作者
	 * @param bookman 图书的出版社
	 * @param status 图书的状态
	 * @param price 图书的单价
	 * @param categoryId 图书所在类别的编号
	 * @param introduction 图书的简介
	 * @param addTime 图书的上架时间
	 * @param total 图书的入库数量
	 * @param currentNum 图书的现有库存
	 */
	public Book(String name, String author, String bookman, int status,
			double price, int categoryId, String introduction,
			Date addTime,int total) {
		this.name = name;
		this.author = author;
		this.bookman = bookman;
		this.status = status;
		this.price = price;
		this.categoryId = categoryId;
		this.introduction = introduction;
		this.addTime = addTime;
		this.total = total;
		this.currentNum = total; 
	}

	/**
	 * 获得图书的作者
	 * @return 图书的作者
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * 设置图书的作者
	 * @param author 将给定的字段设定为指定的值
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * 获得图书的出版社
	 * @return 图书的出版社信息
	 */
	public String getBookman() {
		return bookman;
	}
	
	/**
	 * 设置图书的出版社
	 * @param bookman 将给定的字段设为给定的值
	 */
	public void setBookman(String bookman) {
		this.bookman = bookman;
	}

	/**
	 * 获得图书所在的图书编号
	 * @return 图书所在的图书编号
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * 设置图书所在的图书编号
	 * @param categoryId 将给定的字段设置为指定的值
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * 获得图书的编号
	 * @return 图书的编号
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * 设置图书的编号
	 * @param id 将给定的字段设为指定的值
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * 获得图书的简介
	 * @return 图书的简介
	 */
	public String getIntroduction() {
		return introduction;
	}

	/**
	 * 设置图书的简介
	 * @param introduction 将给定的字段设置为指定的值
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	/**
	 * 获得图书的名称
	 * @return 图书的名称
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置图书的名称
	 * @param name 将给定的字段设为指定的值
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * 获得图书的价格
	 * @return 图书的价格
	 */
	public double getPrice() {
		return price;
	}
 
	/**
	 * 设置图书的价格
	 * @param price 将给定的字段设为指定的值
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * 获得图书的状态
	 * @return 图书的状态
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * 设置图书的状态
	 * @param status 将给定的字段设为指定的值
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * 获得上架时间
	 * @return 图书的上架时间
	 */
	public Date getAddTime() {
		return addTime;
	}

	/**
	 * 设置图书的上架时间
	 * @param addTime 将给定字段的值设为给定值
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	/**
	 * 获得图书的总数量
	 * @return
	 */
	public int getTotal() {
		return total;
	}
	
	/**
	 * 设置图书的总数量
	 * @param total
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * 获得现有库存数量
	 * @return 现有库存数量
	 */
	public int getCurrentNum() {
		return currentNum;
	}

	/**
	 * 设置现有库存数量
	 * @param currentNum 将给定的字段设为给定的值
	 */
	public void setCurrentNum(int currentNum) {
		this.currentNum = currentNum;
	}
	
}
