package com.succez.webserver;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.succez.interfaces.Response;

/**
 * FileResponse类
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>succez</p>
 * @author wengxinh
 * @createdate 2017年11月8日
 */
public class WebResponse implements Response {
	/**
	 * log4j 日志输出
	 */
	private static final Logger logger1 = Logger.getLogger(WebResponse.class);

	/**
	 * 输出流
	 */
	public OutputStream output;

	/**
	 * 响应头
	 */
	private String header;

	/**
	 * http协议版本
	 */
	private String protocol;

	/**
	 * http状态码
	 */
	private int statuscode;

	/**
	 * 文档编码格式
	 */
	private String contentencoding;

	/**
	 * 文档类型
	 */
	private String contenttype;

	/**
	 * 文档长度
	 */
	private int contentlength;

	/**
	 * 正文的字符编码
	 */
	private String characterencoding;

	/**
	 * Response中文件映射表
	 */
	public static Map<String, String> contentypeList = new HashMap<String, String>(10);

	public WebResponse(OutputStream output) {
		this.output = output;
	}

	/**
	 * 初始化Response中文件映射表
	 */
	public static void initContentType() {
		contentypeList.put(".png", "image/png");
		contentypeList.put(".jpg", "image/jpg");
		contentypeList.put(".jpg", "image/jpg");
		contentypeList.put(".ico", "image/ico");
		contentypeList.put(".jpeg", "image/jpeg");
		contentypeList.put(".css", "text/css");
		contentypeList.put(".html", "text/html");
		contentypeList.put(".json", "application/json");
		contentypeList.put(".js", "application/javascript");
		contentypeList.put(".txt", "text/plain");
		contentypeList.put(".xml", "text/xml");
		contentypeList.put(".mp3", "audio/mp3");
		contentypeList.put(".mp4", "audio/mp4");
	}

	/**
	 * 响应静态文件
	 * @param file file对象
	 * @throws IOException I/O异常
	 * @see com.succez.interfaces.Response#response(java.io.File)
	 */
	@Override
	public void response(File file) throws IOException {
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		try {
			byte[] buffer = new byte[1024];
			int ch;
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			output.write(this.header.getBytes());
			output.write(this.contenttype.getBytes());
			ch = bis.read(buffer);
			while (ch != -1) {
				output.write(buffer, 0, ch);
				ch = bis.read(buffer, 0, 1024);
			}
		}
		finally {
			if (fis != null) {
				try {
					fis.close();
				}
				catch (IOException e) {
					logger1.error("IO流关闭失败" + e.getMessage());
				}
				finally {
					if (bis != null) {
						try {
							bis.close();
						}
						catch (IOException e) {
							logger1.error("IO流关闭失败" + e.getMessage());
						}
					}
				}
			}

		}

	}

	/**
	 * 响应空请求/错误请求
	 * @param sc http状态码（404）
	 * @throws IOException I/O异常
	 * @see com.succez.interfaces.Response#responseNull(int)
	 */
	@Override
	public void responseNull(int sc) throws IOException {
		//返回404
		String protocol = "HTTP/1.1 200 OK \r\n";
		String contentType = "Content-Type: text/html;";
		String charEncoding = "charset=\"UTF-8\"\r\n\r\n";
		output.write(protocol.getBytes());
		output.write((contentType).getBytes());
		output.write((charEncoding).getBytes());
		output.write(String.valueOf(sc).getBytes());
		output.write(" File/Dir Not Found !".getBytes());
	}

	/**
	 * 响应json格式数据
	 * @param json json字符串
	 * @throws IOException I/O异常
	 * @see com.succez.interfaces.Response#sendJson(java.lang.String)
	 */
	@Override
	public void sendJson(String json) throws IOException {
		//返回json
		String protocol = "HTTP/1.1 200 OK \r\n";
		String contentType = "Content-Type: application/json\r\n\r\n";
		output.write((protocol).getBytes());
		output.write((contentType).getBytes());
		output.write(json.getBytes());
	}

	@Override
	public void setStatusCode(int sc) {
		this.statuscode = sc;
	}

	@Override
	public int getStatusCode() {
		return this.statuscode;
	}

	@Override
	public String getContentEncoding() {
		return this.contentencoding;
	}

	@Override
	public void setContenEncoding(String ce) {
		this.contentencoding = ce;
	}

	@Override
	public int getContenLength() {
		return this.contentlength;
	}

	@Override
	public void setContenLength(int cl) {
		this.contentlength = cl;
	}

	@Override
	public String getContenType() {
		return this.contenttype;
	}

	@Override
	public void setContenType(String ct) {
		this.contenttype = ct;
	}

	@Override
	public void setCharacterEncoding(String charset) {
		this.characterencoding = charset;
	}

	@Override
	public String getCharacterEncoding() {
		return this.characterencoding;
	}

	@Override
	public OutputStream getOutputStream() {
		return this.output;
	}

	@Override
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	@Override
	public String getProtocol() {
		return this.protocol;
	}

	@Override
	public String getHeader() {
		return this.header;
	}

	@Override
	public void setHeader(String header) {
		this.header = header;
	}
}
