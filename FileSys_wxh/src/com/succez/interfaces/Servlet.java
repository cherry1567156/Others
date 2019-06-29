package com.succez.interfaces;

import java.io.IOException;

import com.succez.exception.ServletsException;
import com.succez.webserver.WebRequest;
import com.succez.webserver.WebResponse;

/**
 * Servlet接口定义
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>succez</p>
 * @author wengxinh
 * @createdate 2017年11月10日
 */
public interface Servlet {
	
	/**
	 * 通过Requset中Method判断是doGet/doPost
	 * @param request Request对象
	 * @param response Response对象
	 * @throws ServletsException 自定义servlet异常
	 * @throws IOException I/O异常
	 */
	public void seclectMethod(WebRequest request, WebResponse response) throws ServletsException, IOException;
	
	/**
	* 处理doGet请求
	 * @param request Request对象
	 * @param response Response对象
	 * @throws ServletsException 自定义servlet异常
	 * @throws IOException I/O异常
	 */
	public void doGet(WebRequest request, WebResponse response) throws ServletsException, IOException;

	/**
	 * 处理doPost请求
	 * @param request Request对象
	 * @param response Response对象
	 * @throws ServletsException 自定义servlet异常
	 * @throws IOException I/O异常
	 */
	public void doPost(WebRequest request, WebResponse response) throws ServletsException, IOException;
}
