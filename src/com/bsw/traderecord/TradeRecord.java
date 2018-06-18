package com.bsw.traderecord;

/**
 * 交易记录类，存放图书销售信息
 * 
 * @author Student
 * @version 1.0.0
 */
public class TradeRecord {

	/* 交易编号 */
	private int id;
	
	/* 用户编号 */
	private int userId;
	
	/* 图书编号 */
	private int bookId;
	
	/* 交易数量 */
	private int tradeNum;
	
	/* 状态（0 未寄出，1已寄出） */
	private int status;

	public TradeRecord() {}
	/**
	 * 构造函数，用给定的参数构造一个交易记录对象
	 * 
	 * @param id 给定的交易编号
	 * @param userId 给定的用户编号
	 * @param bookId 给定的图书编号
	 * @param tradeNum 给定的交易数量
	 * @param status 给定的状态
	 */
	public TradeRecord(int id, int userId, int bookId, int tradeNum, int status) {
		
		this.id = id;
		this.userId = userId;
		this.bookId = bookId;
		this.tradeNum = tradeNum;
		this.status = status;
	}

	/**
	 * 返回图书编号
	 * @return bookId 图书编号 
	 */
	public int getBookId() {
		return bookId;
	}

	/**
	 * 用给定的图书编号设置图书编号
	 * @param bookId 给定的图书编号
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	/**
	 * 返回交易编号
	 * @return 交易编号
	 */
	public int getId() {
		return id;
	}

	/**
	 * 用给定的交易编号设置交易编号
	 * @param id 给定的交易编号
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 返回交易状态
	 * @return 交易状态
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * 用给定的交易状态设置交易状态
	 * @param status 给定的交易状态
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * 返回交易数量
	 * @return 交易数量
	 */
	public int getTradeNum() {
		return tradeNum;
	}

	/**
	 * 用给定的交易数量设置交易数量
	 * @param tradeNum 给定的交易数量
	 */
	public void setTradeNum(int tradeNum) {
		this.tradeNum = tradeNum;
	}

	/**
	 * 返回用户编号
	 * @return userId 用户编号
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * 用给定的用户编号设置用户编号
	 * @param userId 给定的用户编号
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

}
