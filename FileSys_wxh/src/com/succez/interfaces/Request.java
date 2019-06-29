package com.succez.interfaces;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Request接口设计
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>succez</p>
 * @author wengxinh
 * @createdate 2017年11月8日
 */
public interface Request {

	/**
	 * 解析request
	 */
	public void parserRequest() throws IOException;

	/**
	 * 解析http请求头部
	 * @param s Request请求头部
	 */
	public void parserHead(String s);

	/**
	 * 获取输入流
	 * @return InputStream
	 */
	public InputStream getInputStream();

	/**
	 * 获取解析后的RequestMap
	 * @return Map(解析后的Request)
	 */
	public Map<String, String> getRequestMap();

	/**
	 * 设置请求头部，存放到Map中
	 * @param key
	 * @param value
	 */
	public void setRequestMap(String key, String value);
}
