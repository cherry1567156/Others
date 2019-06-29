package com.succez.practice1;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * 这是File工具类
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>succez</p>
 * @author wengxinh
 * @createdate 2017年11月3日
 */
public class FileUtil {
	private static final Logger logger1 = Logger.getLogger(FileUtil.class);

	/**
	 * fileToBuf:将文件内容转换成byte数组返回，如果文件不存在或者读入错误返回null
	 * @param file file对象
	 * @return byte[] 返回字节数组
	 */
	public byte[] fileToBuf(File file) {
		//文件为空,返回null
		if (file == null) {
			logger1.error("文件为空");
			return null;
		}
		//不可读文件，返回null
		if (!file.canRead()) {
			logger1.error("文件不可读");
			return null;
		}
		//文件超过最大值,返回null
		if (file.length() > Integer.MAX_VALUE) {
			logger1.error("文件过大");
			return null;
		}
		byte[] buffer = null;
		FileInputStream fis = null;
		ByteArrayOutputStream bos = null;
		//BufferedInputStream bis = null;
		try {
			fis = new FileInputStream(file);
			bos = new ByteArrayOutputStream((int)file.length());
			byte[] b = new byte[1024];
			int n;
			//循环读文件
			while (-1 != (n = fis.read(b))) {
				bos.write(b, 0, n);
			}
			buffer = bos.toByteArray();
		}
		catch (FileNotFoundException e) {
			logger1.error("系统找不到指定的文件：" + e.getMessage());
		}
		catch (IOException e) {
			logger1.error("IO流创建失败" + e.getMessage());
		}
		finally {
			if (fis != null) {
				try {
					//关闭文件流
					fis.close();
				}
				catch (IOException e) {
					e.printStackTrace();
					logger1.error("文件流关闭失败" + e.getMessage());

				}
				finally {
					if (bos != null) {
						try {
							//关闭字节流
							bos.close();
						}
						catch (IOException e) {
							logger1.error("IO流关闭失败" + e.getMessage());
						}
					}
				}
			}

		}
		//返回byte数组
		return buffer;
	}
}
