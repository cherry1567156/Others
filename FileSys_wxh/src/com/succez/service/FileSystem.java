package com.succez.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.succez.webserver.WebRequest;
import com.succez.webserver.WebResponse;

/**
 * 文件管理类 将URI目录下文件信息封装成json数据,
 * 	如果是文件 则下载
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>succez</p>
 * @author wengxinh
 * @createdate 2017年11月9日
 */
public class FileSystem {

	/**
	 * log4j 日志输出
	 */
	private static final Logger logger1 = Logger.getLogger(FileSystem.class);

	/**
	 * 设置文件管理系统根目录
	 */
	public static final String rootdirectory = System.getProperty("user.dir") + "\\FileRoot";

	/**
	 * 根据path生成一个文件file对象，判断路径是否存在，
	 * 如果是目录，则返回Json文件信息，文件则直接下载。
	 * @param path 文件路径
	 * @param request Request对象
	 * @param response Response对象
	 * @throws IOException I/O异常
	 */
	public void listDirectory(String path, WebRequest request, WebResponse response) throws IOException {
		File f = new File(path);
		if (f.exists()) {
			ArrayList<Map<String, String>> flist = new ArrayList<Map<String, String>>(10);
			if (f.isDirectory()) {
				File[] files = f.listFiles();
				if (files != null) {
					File temp = null;
					for (int i = 0, len = files.length; i < len; i++) {
						temp = files[i];
						Map<String, String> map = new HashMap<String, String>(1);
						map.put("fileName", temp.getName());
						map.put("fileLastModify", String.valueOf(temp.lastModified()));
						if (temp.isDirectory()) {
							map.put("fileType", "dir");
						}
						else {
							map.put("fileSize", String.valueOf(temp.length()));
							map.put("fileType", "file");
						}
						map.put("filePath", "/project" + temp.getPath().substring(rootdirectory.length()));
						flist.add(map);
					}
				}
				Gson gson = new Gson();
				String json = gson.toJson(flist);
				response.setHeader("HTTP/1.1 200 OK \r\n");
				response.setContenType("Content-Type: application/json;charset=\"UTF-8\"\r\n\r\n");
				response.sendJson(json.toString());
			}
			else if (f.isFile()) {
				response.setHeader("HTTP/1.1 200 OK \r\nContent-Disposition: attachment;filename=" + f.getName() + "\r\n");
				response.setContenType("Content-Type: text/html;charset=\"UTF-8\"\r\n\r\n");
				logger1.info(f.getName() + "文件开始下载！");
				response.response(f);
			}
		}
		else {
			response.responseNull(404);
		}
	}
}