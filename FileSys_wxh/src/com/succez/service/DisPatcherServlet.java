package com.succez.service;

import java.io.File;
import java.io.IOException;

import com.succez.exception.ServletsException;
import com.succez.webserver.WebRequest;
import com.succez.webserver.WebResponse;

/**
 * 服务器根据请求的URI确定调用的servlet
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>succez</p>
 * @author wengxinh
 * @createdate 2017年11月10日
 */
public class DisPatcherServlet {

	/**
	 * 通过url判断请求类型，判断是静态文件请求还是文件信息请求，继而做出相应的响应
	 * @param request Request对象
	 * @param response Response对象
	 * @throws ServletsException 自定义servlet异常
	 * @throws IOException I/O异常
	 */
	public void ServletChoose(WebRequest request, WebResponse response) throws ServletsException, IOException {
		String uri = request.getRequestMap().get("Uri");
		//首次请求，加载系统首页
		if (uri == null) {
			response.responseNull(404);
		}
		else if (uri.startsWith("/project")) {
			//处理显示根目录,调用fileservlet
			FileServlet fServlet = new FileServlet();
			fServlet.seclectMethod(request, response);
		}
		else if ("/index.html".equals(uri) || "/favicon.ico".equals(uri)) {
			response.setHeader("HTTP/1.1 200 OK \r\n");
			response.setContenType("Content-Type: text/html;charset=\"UTF-8\"\r\n\r\n");
			File file = new File(System.getProperty("user.dir") + uri);
			response.response(file);
		}
		else if (uri.startsWith("/webRoot")) {
			//加载html中其他元素：img,js等文件
			response.setHeader("HTTP/1.1 200 OK \r\n");
			String fileend = uri.substring(uri.lastIndexOf("."));
			response.setContenType("Content-Type: " + WebResponse.contentypeList.get(fileend) + "\r\n\r\n");
			File file = new File(System.getProperty("user.dir") + uri);
			response.response(file);
		}
		else {
			response.responseNull(404);
		}
	}
}
