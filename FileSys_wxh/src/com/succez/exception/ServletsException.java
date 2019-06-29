package com.succez.exception;

import org.apache.log4j.Logger;

/**
 * 自定义servlet异常
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>succez</p>
 * @author wengxinh
 * @createdate 2017年11月9日
 */
public class ServletsException extends Exception {
	
	/**
	 * log4j 日志输出
	 */
	private static final Logger logger1 = Logger.getLogger(ServletsException.class);

	private static final long serialVersionUID = 1L;

	public ServletsException(String msg) {
		ServletsException.logger1.error("servlet执行异常" + msg);
	}
}
