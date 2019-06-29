package com.succez.practice1test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import com.succez.practice1.FileUtil;

/**
 * 这是FileUtil的测试类
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>succez</p>
 * @author wengxinh
 * @createdate 2017年11月3日
 */

public class FileUtilTest {

	@Test
	//测试FileToBuf类中的file2buf方法
	public void testFile2buf() {
		FileUtil f1 = new FileUtil();
		//测试正确文件路径
		String path1 = "src\\1.txt";
		File file1 = new File(path1);
		byte[] out = f1.fileToBuf(file1);
		assertNotNull(out);
		//测试错误文件路径
		String path2 = "src\\2.txt";
		File file2 = new File(path2);
		out = f1.fileToBuf(file2);
		assertNull(out);
		//测试空文件路径
		String path3 = "";
		File file3 = new File(path3);
		out = f1.fileToBuf(file3);
		assertNull(out);
		//测试空路径
		out = f1.fileToBuf(null);
		assertNull(out);
		//测试不可读文件测试时将read.txt文件权限改为不可读
		String path4 = "src\\read.txt";
		File file4 = new File(path4);
		out = f1.fileToBuf(file4);
		//assertNull(out);
	}

}
