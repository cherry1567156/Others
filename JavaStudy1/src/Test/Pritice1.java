package Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Pritice1 {
	/**
	 * 将文件内容转换成byte数组返回,如果文件不存在或者读入错误返回null
	 */
	public static byte[] file2buf(File file) 
	{
		byte[] buffer = null;  
        try  
        {  
            FileInputStream fis = new FileInputStream(file);  
            ByteArrayOutputStream bos = new ByteArrayOutputStream();  
            byte[] b = new byte[1024];  
            int n;  
            while ((n = fis.read(b)) != -1)  
            {  
                bos.write(b, 0, n);  
            }  
            fis.close();  
            bos.close();  
            buffer = bos.toByteArray();  
        }  
        catch (FileNotFoundException e)  
        {  
            e.printStackTrace();  
        }  
        catch (IOException e)  
        {  
            e.printStackTrace();  
        }  
        return buffer; 
	}
	public static void main(String args[])
	{
		String path="D:/1.txt";
        File file = new File(path);
		System.out.println(Arrays.toString(file2buf(file)));
	}
}
