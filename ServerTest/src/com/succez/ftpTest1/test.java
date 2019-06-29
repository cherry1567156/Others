package com.succez.ftpTest1;


import com.succez.ftpTest1.FtpUtil;  
  
public class test {  
    public static void main(String args[]) {
          
        String ftpHost = "127.0.0.1";  
        String ftpUserName = "zyf";  
        String ftpPassword = "zyf";  
        int ftpPort = 21;  
        String ftpPath = "ftpdir/";  
        String localPath = "H:/download";  
        String fileName = "11.txt";  
        FtpUtil.downloadFtpFile(ftpHost, ftpUserName, ftpPassword, ftpPort, ftpPath, localPath, fileName);  
    }  
}  