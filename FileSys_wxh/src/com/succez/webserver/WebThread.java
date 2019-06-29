package com.succez.webserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

import com.succez.exception.ServletsException;
import com.succez.service.DisPatcherServlet;

/**
 * webserver线程 一个客户端发出请求分配一个线程
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>succez</p>
 * @author wengxinh
 * 
 * @createdate 2017年11月9日
 */
public class WebThread extends Thread {

	/**
	 * log4j 日志输出
	 */
	private static final Logger logger1 = Logger.getLogger(WebThread.class);

	private Socket sk;

	WebThread(Socket sk) {
		this.sk = sk;
	}

	/**
	 * 服务器对于请求创建的线程
	 * @see java.lang.Thread#run()
	 */
	public void run() {
		try {
			InputStream input = null;
			OutputStream output = null;
			input = sk.getInputStream();
			output = sk.getOutputStream();
			//接收来自客户端的请求。
			WebRequest request = new WebRequest(input);
			request.parserRequest();
			WebResponse response = new WebResponse(output);
			DisPatcherServlet ds = new DisPatcherServlet();
			try {
				ds.ServletChoose(request, response);
			}
			catch (ServletsException e) {
				logger1.error("servlet路由选择异常", e);
			}
		}
		catch (IOException e) {
			logger1.error("scoket I/O流异常", e);
		}
		finally {
			logger1.info("关闭连接");
			//最后释放资源
			try {
				sk.close();
			}
			catch (IOException e) {
				logger1.error("scoket 关闭失败", e);
			}
		}
	}
}
