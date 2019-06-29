package com.succez.filesystem;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;

import org.apache.log4j.Logger;

public class StringTest {
	private static final Logger logger1 = Logger.getLogger(StringTest.class);
	public static void main(String[] args) {
		//String str = "<abcd efg>higklmnopq<rstu vwxyz";
		//System.out.println(str.substring(str.indexOf(">")+1, str.lastIndexOf("<")));
		//BufferedInputStream
		String root = System.getProperty("user.dir");
		String uri="/";
		String uri1="/project";
		String uri2="/project/index.html";
		String uri3="/project/123";
		String req="GET /webRoot/TNode.js HTTP/1.1";
		String a[]=req.split(":");
		String t=null;
		String b[]={"A","S","D","F","G","H"};		//System.out.println(t.endsWith("."));
		//System.out.println(a[0]+a[1]);
		//System.out.println(uri2.substring(8));
		//String fileend=uri2.substring(uri2.lastIndexOf("."));
		//System.out.println(fileend);
		//System.out.println(uri2.endsWith("/index.html"));
		//File file=new File(root+uri);
		//File file1=new File(root+uri1);
		//File file2=new File(root+uri2);
		//File file3=new File(root+uri3);
		//System.out.println(file.exists());
		//System.out.println(file.isDirectory());
		//System.out.println(file1.exists());
		//System.out.println(file1.isDirectory());
		//System.out.println(file2.exists());
		//System.out.println(file2.isDirectory());
		//System.out.println(file3.exists());
		//System.out.println(file3.isDirectory());
		//if(uri2.startsWith("/project"))
		//	System.out.println(uri.substring(1, uri.length())=="");
			//System.out.println("@"+"#");
		//System.out.println("@"+uri.substring(1, uri.length())+"#");
		//System.out.println(uri.substring(uri.indexOf("/")+1, uri.lastIndexOf("/")));
		//System.out.println(uri1.substring(uri1.indexOf("/")+1, uri1.lastIndexOf("/")));
		//System.out.println(uri2.substring(uri.indexOf("/")+1, uri2.lastIndexOf("/")));
		//System.out.println(uri3.substring(uri3.indexOf("/")+1, uri3.lastIndexOf("/")));
	}
}
