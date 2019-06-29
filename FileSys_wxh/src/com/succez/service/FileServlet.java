package com.succez.service;

import java.io.IOException;

import com.succez.exception.ServletsException;
import com.succez.interfaces.Servlet;
import com.succez.webserver.WebRequest;
import com.succez.webserver.WebResponse;

/**
 * FileServlet类 主要处理Method选择get/post
 * 				doGet方法
 * 				doPost方法
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>succez</p>
 * @author wengxinh
 * @createdate 2017年11月15日
 */
public class FileServlet implements Servlet {

	/**
	 * 通过Requset中Method判断是doGet/doPost
	 * @param request Request对象
	 * @param response Response对象
	 * @throws ServletsException 自定义servlet异常
	 * @throws IOException I/O异常
	 * @see com.succez.interfaces.Servlet#seclectMethod(com.succez.webserver.WebRequest, com.succez.webserver.WebResponse)
	 */
	@Override
	public void seclectMethod(WebRequest request, WebResponse response) throws ServletsException, IOException {
		if (request.getRequestMap().get("Method") != null) {
			if ("GET" == request.getRequestMap().get("Method")) {
				doGet(request, response);
			}
			else {
				doPost(request, response);
			}

		}
	}

	/**
	 * 处理doGet请求
	 * @param request Request对象
	 * @param response Response对象
	 * @throws ServletsException 自定义servlet异常
	 * @throws IOException I/O异常
	 * @see com.succez.interfaces.Servlet#doGet(com.succez.webserver.WebRequest, com.succez.webserver.WebResponse)
	 */
	@Override
	public void doGet(WebRequest request, WebResponse response) throws ServletsException, IOException {
		String uri = request.getRequestMap().get("Uri");
		FileSystem fSystem = new FileSystem();
		//处理显示目录
		fSystem.listDirectory(FileSystem.rootdirectory + uri.substring(8), request, response);
	}

	/**
	 * 处理doPost请求
	 * @param request Request对象
	 * @param response Response对象
	 * @throws ServletsException 自定义servlet异常
	 * @throws IOException I/O异常
	 * @see com.succez.interfaces.Servlet#doGet(com.succez.webserver.WebRequest, com.succez.webserver.WebResponse)
	 */
	@Override
	public void doPost(WebRequest request, WebResponse response) throws ServletsException, IOException {
		String uri = request.getRequestMap().get("Uri");
		FileSystem fSystem = new FileSystem();
		//处理显示目录
		fSystem.listDirectory(FileSystem.rootdirectory + uri.substring(8), request, response);
	}
}
