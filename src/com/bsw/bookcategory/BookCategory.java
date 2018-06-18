package com.bsw.bookcategory;

/**
 * 功能描述：
 * 用于存储所有的图书类别
 * 
 * @author Student
 * @version 1.0.0   
 *
 */
public class BookCategory {
	
	/**
	 * 类别编号
	 */
	private int id;
	/**
	 * 类别名称
	 */
	private String name;

	/**
	 * 构造方法 
	 * @param id
	 * @param name
	 */
	public BookCategory(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * 无参数的构造方法
	 */
	public BookCategory() {
	}

	/**
	 * 获取类别的编号
	 * @return id;
	 */
	public int getId() {
		return id;
	}

	/**
	 * 设置类别的编号
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 获取类别名称
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置类别名称
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
