package com.bsw.book;

import java.sql.Date;



/**
 * ��װbook������ݿ��ֶ�,�ֶ�����Ӧbook����ֶ���
 * 
 * @author Student
 * @version 1.0.0
 */
public class Book {

	/**
	 * ͼ��ı��
	 */
	private int id;

	/**
	 * ͼ�������
	 */
	private String name;

	/**
	 * ͼ�������
	 */
	private String author;

	/**
	 * ͼ��ĳ�����
	 */
	private String bookman;

	/**
	 * ͼ���״̬ 0ȱ�� 1�л� 2������
	 */
	private int status;

	/**
	 * ͼ��ĵ���
	 */
	private double price;

	/**
	 * ͼ�����ڵ�ͼ�����ı��
	 */
	private int categoryId;
	
	/**
	 * ͼ����ϼ�ʱ��
	 */
	private Date addTime;
	
	/**
	 * ͼ����������
	 */
	private int total;
	
	/**
	 * ͼ������п��
	 */
	private int currentNum;

	/**
	 * ͼ��ļ��
	 */
	private String introduction;
	
	/**
	 * �޲ι��캯��
	 */
	public Book() {}
	
	/**
	 * ���Գ�ʼ��Book����
	 * @param name ͼ�������
	 * @param author ͼ�������
	 * @param bookman ͼ��ĳ�����
	 * @param status ͼ���״̬
	 * @param price ͼ��ĵ���
	 * @param categoryId ͼ���������ı��
	 * @param introduction ͼ��ļ��
	 * @param addTime ͼ����ϼ�ʱ��
	 * @param total ͼ����������
	 * @param currentNum ͼ������п��
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
	 * ���ͼ�������
	 * @return ͼ�������
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * ����ͼ�������
	 * @param author ���������ֶ��趨Ϊָ����ֵ
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * ���ͼ��ĳ�����
	 * @return ͼ��ĳ�������Ϣ
	 */
	public String getBookman() {
		return bookman;
	}
	
	/**
	 * ����ͼ��ĳ�����
	 * @param bookman ���������ֶ���Ϊ������ֵ
	 */
	public void setBookman(String bookman) {
		this.bookman = bookman;
	}

	/**
	 * ���ͼ�����ڵ�ͼ����
	 * @return ͼ�����ڵ�ͼ����
	 */
	public int getCategoryId() {
		return categoryId;
	}

	/**
	 * ����ͼ�����ڵ�ͼ����
	 * @param categoryId ���������ֶ�����Ϊָ����ֵ
	 */
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * ���ͼ��ı��
	 * @return ͼ��ı��
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * ����ͼ��ı��
	 * @param id ���������ֶ���Ϊָ����ֵ
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * ���ͼ��ļ��
	 * @return ͼ��ļ��
	 */
	public String getIntroduction() {
		return introduction;
	}

	/**
	 * ����ͼ��ļ��
	 * @param introduction ���������ֶ�����Ϊָ����ֵ
	 */
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	/**
	 * ���ͼ�������
	 * @return ͼ�������
	 */
	public String getName() {
		return name;
	}

	/**
	 * ����ͼ�������
	 * @param name ���������ֶ���Ϊָ����ֵ
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * ���ͼ��ļ۸�
	 * @return ͼ��ļ۸�
	 */
	public double getPrice() {
		return price;
	}
 
	/**
	 * ����ͼ��ļ۸�
	 * @param price ���������ֶ���Ϊָ����ֵ
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * ���ͼ���״̬
	 * @return ͼ���״̬
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * ����ͼ���״̬
	 * @param status ���������ֶ���Ϊָ����ֵ
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * ����ϼ�ʱ��
	 * @return ͼ����ϼ�ʱ��
	 */
	public Date getAddTime() {
		return addTime;
	}

	/**
	 * ����ͼ����ϼ�ʱ��
	 * @param addTime �������ֶε�ֵ��Ϊ����ֵ
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	/**
	 * ���ͼ���������
	 * @return
	 */
	public int getTotal() {
		return total;
	}
	
	/**
	 * ����ͼ���������
	 * @param total
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * ������п������
	 * @return ���п������
	 */
	public int getCurrentNum() {
		return currentNum;
	}

	/**
	 * �������п������
	 * @param currentNum ���������ֶ���Ϊ������ֵ
	 */
	public void setCurrentNum(int currentNum) {
		this.currentNum = currentNum;
	}
	
}
