package com.succez.webserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.succez.interfaces.Request;

/**
 * FileRequest类
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>succez</p>
 * @author wengxinh
 * @createdate 2017年11月8日
 */
public class WebRequest implements Request {

	/**
	 * log4j 日志输出
	 */
	private static final Logger logger1 = Logger.getLogger(WebRequest.class);

	/**
	 * 输入流
	 */
	public InputStream input;

	/**
	 * 存储解析后的Request请求
	 */
	private Map<String, String> requestMap;

	public WebRequest(InputStream input) {
		this.input = input;
		this.requestMap = new HashMap<String, String>(10);
	}

	public Map<String, String> getRequestMap() {
		return this.requestMap;
	}

	/**
	 * 获取Request请求体并解析，存放到Map中
	 * @see com.succez.interfaces.Request#getRequest()
	 */
	@Override
	public void parserRequest() throws IOException {
		try {
			InputStreamReader reader = new InputStreamReader(input);
			BufferedReader bd = new BufferedReader(reader);
			String t = null;
			while ((t = bd.readLine()) != null) {
				String temp = URLDecoder.decode(t, "utf-8");
				//解析每一句的方法
				logger1.info(temp);
				if (temp.startsWith("GET") || temp.startsWith("POST")) {
					parserHead(temp);
				}
				else if (temp.equals(""))
					break;
				else {
					String a[] = temp.split(":");
					String key = a[0];
					String value = a[1];
					if (value == null) {
						value = "";
					}
					this.requestMap.put(key, value);
				}
			}
			String uri = this.requestMap.get("Uri");
			if (uri.endsWith("?")) {
				this.getRequestMap().put("Uri", uri.substring(0, uri.length() - 1));
			}
			logger1.info("解析结束");
		}
		catch (IOException e) {
			logger1.error("request请求解析异常", e);
			throw e;
		}
	}

	/**
	 * 解析Request请求头部
	 * @param s Request请求头部字符串
	 * @see com.succez.interfaces.Request#parserHead(java.lang.String)
	 */
	@Override
	public void parserHead(String s) {
		if (s.startsWith("GET")) {
			String method = "GET";
			this.requestMap.put("Method", method);
			int index = s.indexOf("HTTP");
			String uri = s.substring(3 + 1, index - 1);
			this.requestMap.put("Uri", uri);
			String protocol = s.substring(index);
			this.requestMap.put("Protocol", protocol);
		}
		else if (s.startsWith("POST")) {
			String method = "POST";
			this.requestMap.put("Method", method);
			int index = s.indexOf("HTTP");
			String uri = s.substring(3 + 1, index - 1);
			this.requestMap.put("Uri", uri);
			String protocol = s.substring(index);
			this.requestMap.put("Protocol", protocol);
		}
	}

	/**
	 * 获取InputStream
	 * @return this.input
	 * @see com.succez.interfaces.Request#getInputStream()
	 */
	@Override
	public InputStream getInputStream() {
		return this.input;
	}

	/**
	 * 根据key-value将Request中信息存放到Map中
	 * @param key Request中每行的key
	 * @param value Request中每行的value
	 * @see com.succez.interfaces.Request#setRequestMap(java.lang.String, java.lang.String)
	 */
	@Override
	public void setRequestMap(String key, String value) {
		this.requestMap.put(key, value);
	}
}