package com.succez.test1;

import java.io.*;
public class Request {
    /*
     * 接收请求的信息，并返回资源（文件名）
     * */
    InputStream input;
    public Request(InputStream input)
    {
        this.input=input;
    }
    public String getUri() throws IOException
    {
        String content=null,str=null;
        StringBuffer request = new StringBuffer();  
        byte[] buffer = new byte[2048];  
        int i = 0;  
          
        try {  
            i = input.read(buffer);  //读取内容并存入buffer数组中，并返回读取的的字节数。
        } catch (IOException e) {  
            e.printStackTrace();  
            i = -1;  
        }  
        //将buffer数组转换为字符串
        for(int k = 0; k < i; k++) {  
            request.append((char)buffer[k]);  
        }  
        content=request.toString();
        if(content!=null)
        {
        	System.out.println("@"+content+"@");
        	System.out.println("#"+getFilename(content)+"#");
            return getFilename(content);
        }
        else return null;
    }
    /*提取文件名*/
    public String getFilename(String content)
    {
        int a,b;
        a=content.indexOf(' ');
        if(a!=-1)
        {
            b=content.indexOf('?',a+1);
            if(b==-1)
            	b=content.indexOf(' ',a+1);
            return content.substring(a+2,b);
        }
        return null;
    }
}
