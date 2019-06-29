package com.succez.test2;

import java.io.*;
import java.net.*;

import com.google.gson.Gson;

public class WebServer implements Runnable{

    /**
     * web服务器：实现200和404操作
     * 原理：
     * 服务器监听一个端口，并读取浏览器的请求信息，从该信息提取出访问的资源（这里为文件名）。并在工作目录下查找是否有该资源，有则输出资源内容，否则返回404
     * 测试方法：
     * 1、用String path=System.getProperty("user.dir");获取当前的工作目录，并在该目录下放要测试的文件
     * 2、访问127.0.0.1:8080/test.html
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WebServer wServer=new WebServer();
        wServer.run();
    }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ServerSocket server = null;
        Socket s=null;
        try
        {
            server=new ServerSocket(8080,3,InetAddress.getByName("127.0.0.1"));
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        while(true)
        {
            try{
                s=server.accept();
                OutputStream output=s.getOutputStream();
                InputStream input=s.getInputStream();
                
                //接收请求信息
                Request request=new Request(input);
                request.getRequset(s);
                //String filename=request.getUri();
                //System.out.println(filename);
                
                //处理并响应请求信息
                //Response response=new Response(output,filename);
                //response.response();

            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }
	}

}