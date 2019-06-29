package com.succez.test2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;


public class Request {  
	private String method;// 请求方法  
	private String protocol;// 协议版本  
	private String requestURL;  
	private String requestURI;//请求的URI地址  在HTTP请求的第一行的请求方法后面  
	private String host;//请求的主机信息  
	private String Connection;//Http请求连接状态信息 对应HTTP请求中的Connection  
	private String agent;// 代理，用来标识代理的浏览器信息 ,对应HTTP请求中的User-Agent:  
	private String language;//对应Accept-Language  
	private String encoding;//请求的编码方式  对应HTTP请求中的Accept-Encoding  
	private String charset;//请求的字符编码  对应HTTP请求中的Accept-Charset  
	private String accept;// 对应HTTP请求中的Accept;  
	InputStream input;
	public Request(InputStream input)
	{
	    this.input=input;
	}
    public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getProtocol() {
		return protocol;
	}
	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	public String getRequestURL() {
		return requestURL;
	}
	public void setRequestURL(String requestURL) {
		this.requestURL = requestURL;
	}
	public String getRequestURI() {
		return requestURI;
	}
	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getConnection() {
		return Connection;
	}
	public void setConnection(String connection) {
		Connection = connection;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getEncoding() {
		return encoding;
	}
	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}
	public String getCharset() {
		return charset;
	}
	public void setCharset(String charset) {
		this.charset = charset;
	}
	public String getAccept() {
		return accept;
	}
	public void setAccept(String accept) {
		this.accept = accept;
	}
	
    public void getRequset(Socket client) {  
        try {  
            InputStream in = client.getInputStream();  
            InputStreamReader reader = new InputStreamReader(in);  
            BufferedReader bd = new BufferedReader(reader);//三重封装  
            String t = null;  
      
            while (( t = bd.readLine()) != null) {  
                System.out.println(t);  
                Log4jTest.logger1.info(t);
                parser(t);//解析每一句的方法  
                if(t.equals("")) break;
            } 
            Log4jTest.logger1.info("解析完毕");
        } catch (Exception ef) {  
            ef.printStackTrace();  
            System.out.println("getRequset error--->");  
        }  
    }  
    public void parser(String s) {  
        if (s.startsWith("GET")) {  
            String method = "GET";  
            setMethod(method);  
      
            int index = s.indexOf("HTTP");  
            System.out.println("index--->" + index);  
            String uri = s.substring(3 + 1, index - 1);// 用index-1可以去掉连接中的空格  
            System.out.println("uri--->" + uri);  
            setRequestURI(uri);  
      
            String protocol = s.substring(index);  
            System.out.println("protocol---->" + protocol);  
            setProtocol(protocol);  
        } else if (s.startsWith("POST")) {  
            String method = "POST";  
            setMethod(method);  
      
            int index = s.indexOf("HTTP");  
            System.out.println("index--->" + index);  
            String uri = s.substring(3 + 1, index - 1);// 用index-1可以去掉连接中的空格  
            System.out.println("uri--->" + uri);  
            setRequestURI(uri);  
      
            String protocol = s.substring(index);  
            System.out.println("protocol---->" + protocol);  
            setProtocol(protocol);  
      
        } else if (s.startsWith("Accept:")) {  
                String accept = s.substring("Accept:".length() + 1);  
            System.out.println("accept--->" + accept);  
            setAccept(accept);  
      
        } else if (s.startsWith("User-Agent:")) {  
            String agent = s.substring("User-Agent:".length() + 1);  
            System.out.println("agent--->" + agent);  
            setAgent(agent);  
      
        } else if (s.startsWith("Host:")) {  
            String host = s.substring("Host:".length() + 1);  
            System.out.println("host--->" + host);  
            setHost(host);  
      
        } else if (s.startsWith("Accept-Language:")) {  
            String language = s.substring("Accept-Language:".length() + 1);  
            System.out.println("language--->" + language);  
            setLanguage(language);  
      
        } else if (s.startsWith("Accept-Charset:")) {  
            String charset = s.substring("Accept-Charset:".length() + 1);  
            System.out.println("charset--->" + charset);  
            setCharset(charset);  
        } else if (s.startsWith("Accept-Encoding:")) {  
            String encoding = s.substring("Accept-Encoding:".length() + 1);  
            System.out.println("encoding--->" + encoding);  
            setEncoding(encoding);  
      
        } else if (s.startsWith("Connection:")) {  
            String connection = s.substring("Connection:".length() + 1);  
            System.out.println("connection--->" + connection);  
            setConnection(connection);  
        }  
      
    }  
}  