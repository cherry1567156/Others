package com.succez.test1;

import java.io.*;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class Response {
	/**
	 * 响应并处理请求信息
	 */
	public OutputStream output;
	public String filename;

	private static final int BUFFER_SIZE = 1024;

	public Response(OutputStream output, String filename) {
		this.output = output;
		this.filename = filename;
	}

	public void response() throws IOException {
		String path = System.getProperty("user.dir");//获取当前的工作目录
		byte[] buffer = new byte[BUFFER_SIZE];
		int ch;
		FileInputStream fis = null;
		//System.out.println(path+File.separator+filename);
		//if (path != null && filename != null) {
			File file = new File(path, "index.html");
			String str = "";
			String str1 = "";
			/*必须添加响应头，否则无法以html格式显示内容*/
			if (file.exists()) {
			//if (true) {
				fis = new FileInputStream(file);
				//str = "HTTP/1.1 200 OK \r\n" + "Content-Type: text/html;charset=\"UTF-8\"\r\n"+ "\r\n";
				
				StringBuffer sb=new StringBuffer(16);
				
				output.write(str.getBytes());
				//sb.append("<html><head><title>文件管理系统</title></head>");
				//sb.append("<meta charset=\"UTF-8\">");
				//sb.append("<body>");
			    //sb.append("<div align='center'>");
			    //sb.append("<h1>文件管理系统</h1>");
			    //sb.append("<a href=\"http://www.baidu.com\">"+path+"</a>");
			   // sb.append("</div>");
			    //sb.append("</body></html>");
				output.write(sb.toString().getBytes());
				//File f = new File("D:/test");
				//Test t = new Test(f);
				ch = fis.read(buffer);
				while (ch != -1) {
					output.write(buffer, 0, ch);
					ch = fis.read(buffer, 0, BUFFER_SIZE);
				}
			}
			else {
				str = "HTTP/1.1 404 File Not Found \r\n" + "Content-Type: text/html\r\n" + "Content-Length: 100\r\n"
						+ "\r\n" + "<h1>404 File Not Found!</h1>";
				output.write(str.getBytes());
			}
		//}
		output.close();
	}
}