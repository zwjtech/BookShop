package com.bsw.traderecord;

/**
 * ���׼�¼�࣬���ͼ��������Ϣ
 * 
 * @author Student
 * @version 1.0.0
 */
public class TradeRecord {

	/* ���ױ�� */
	private int id;
	
	/* �û���� */
	private int userId;
	
	/* ͼ���� */
	private int bookId;
	
	/* �������� */
	private int tradeNum;
	
	/* ״̬��0 δ�ĳ���1�Ѽĳ��� */
	private int status;

	public TradeRecord() {}
	/**
	 * ���캯�����ø����Ĳ�������һ�����׼�¼����
	 * 
	 * @param id �����Ľ��ױ��
	 * @param userId �������û����
	 * @param bookId ������ͼ����
	 * @param tradeNum �����Ľ�������
	 * @param status ������״̬
	 */
	public TradeRecord(int id, int userId, int bookId, int tradeNum, int status) {
		
		this.id = id;
		this.userId = userId;
		this.bookId = bookId;
		this.tradeNum = tradeNum;
		this.status = status;
	}

	/**
	 * ����ͼ����
	 * @return bookId ͼ���� 
	 */
	public int getBookId() {
		return bookId;
	}

	/**
	 * �ø�����ͼ��������ͼ����
	 * @param bookId ������ͼ����
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	/**
	 * ���ؽ��ױ��
	 * @return ���ױ��
	 */
	public int getId() {
		return id;
	}

	/**
	 * �ø����Ľ��ױ�����ý��ױ��
	 * @param id �����Ľ��ױ��
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * ���ؽ���״̬
	 * @return ����״̬
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * �ø����Ľ���״̬���ý���״̬
	 * @param status �����Ľ���״̬
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * ���ؽ�������
	 * @return ��������
	 */
	public int getTradeNum() {
		return tradeNum;
	}

	/**
	 * �ø����Ľ����������ý�������
	 * @param tradeNum �����Ľ�������
	 */
	public void setTradeNum(int tradeNum) {
		this.tradeNum = tradeNum;
	}

	/**
	 * �����û����
	 * @return userId �û����
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * �ø������û���������û����
	 * @param userId �������û����
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
