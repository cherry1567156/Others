package com.succez.webserver;

import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

/**
 * web服务器
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>succez</p>
 * @author wengxinh
 * @createdate 2017年11月8日
 */
public class WebServer {

	/**
	 * log4j 日志输出
	 */
	private static final Logger logger1 = Logger.getLogger(WebServer.class);

	/**
	 * 整个服务器的入口，开启服务器
	 * @param args
	 * @throws IOException I/O异常
	 */
	public static void main(String[] args) throws IOException {
		logger1.info("服务器启动");
		//创建线程池，默认大小10
		ExecutorService service = Executors.newFixedThreadPool(10);
		ServerSocket server = null;
		try {
			//使用8080端口提供服务
			server = new ServerSocket(8090);
			Socket s = null;
			while (true) {
				try {
					//创建一个线程来处理请求
					s = server.accept();
					WebThread webthread = new WebThread(s);
					//加入任务队列，等待执行
					service.execute(webthread);
				}
				catch (IOException e) {
					logger1.error("请求接收异常", e);
					throw e;
				}
			}
		}
		catch (Exception e) {
			logger1.error("scoket服务启动异常", e);
		}
	}
}
