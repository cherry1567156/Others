package com.succez.interfaces;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Response接口设计
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>succez</p>
 * @author wengxinh
 * @createdate 2017年11月8日
 */
public interface Response {

	/**
	 * 响应请求文件
	 * @param file
	 * @throws IOException
	 */
	public void response(File file) throws IOException;

	/**
	 * 发送Json
	 * @param json
	 * @throws IOException
	 */
	public void sendJson(String json) throws IOException;

	/**
	 * 响应异常请求
	 * @param sc
	 * @throws IOException
	 */
	public void responseNull(int sc) throws IOException;

	/**
	 * 响应头
	 * @return
	 */
	public String getHeader();

	/**
	 * 设置响应头
	 * @param header
	 */
	public void setHeader(String header);

	/**
	 * http协议版本
	 * @param protocol
	 */
	public void setProtocol(String protocol);

	/**
	 * http协议版本
	 * @return
	 */
	public String getProtocol();

	/**
	 * 设置http状态码
	 * @param sc
	 */
	public void setStatusCode(int sc);

	/**
	 * 返回http状态码
	 * @return
	 */
	public int getStatusCode();

	/**
	 * 获取文档编码格式
	 * @return
	 */
	public String getContentEncoding();

	/**
	 * 设置文档编码格式
	 * @param ce
	 */
	public void setContenEncoding(String ce);

	/**
	 * 获取内容长度
	 * @return
	 */
	public int getContenLength();

	/**
	 * 设置内容长度
	 * @param cl
	 */
	public void setContenLength(int cl);

	/**
	 * 获取文档类型
	 * @return
	 */
	public String getContenType();

	/**
	 * 设置文档类型
	 * @param ct
	 */
	public void setContenType(String ct);

	/**
	 * 设置响应正文的字符编码，响应正文的默认字符编码为ISO-8859-1
	 * @param charset
	 */
	public void setCharacterEncoding(String charset);

	/**
	 * 返回响应正文的字符编码
	 * @return
	 */
	public String getCharacterEncoding();

	/**
	 * 获取输出流
	 * @return
	 */
	public OutputStream getOutputStream();
}
