package com.bsw.bookcategory;

/**
 * ����������
 * ���ڴ洢���е�ͼ�����
 * 
 * @author Student
 * @version 1.0.0   
 *
 */
public class BookCategory {
	
	/**
	 * �����
	 */
	private int id;
	/**
	 * �������
	 */
	private String name;

	/**
	 * ���췽�� 
	 * @param id
	 * @param name
	 */
	public BookCategory(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/**
	 * �޲����Ĺ��췽��
	 */
	public BookCategory() {
	}

	/**
	 * ��ȡ���ı��
	 * @return id;
	 */
	public int getId() {
		return id;
	}

	/**
	 * �������ı��
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * ��ȡ�������
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * �����������
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

}
