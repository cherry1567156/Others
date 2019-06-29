package com.succez.filesystem;

import java.io.File;

import org.omg.PortableInterceptor.USER_EXCEPTION;

public class Test {
    static int dirs = 0;//定义的变量用于存放统计出来的目录数量和文件数量
    static int files = 0;
    static long dirLength = 0 ;//定义的变量用于存放统计出来的目录大小和文件大小
    static long fileLength = 0;
    static String preStr = "";//定义缩进量，用于以树形结构展现层级
    File f = null;
    public Test(File f){
        this.f = f;
    }

    public void tree(File f, int level) {
        /**
         * 由于全局变量在程序销毁之前，
        变量就会一直保存在内存中，这样就会导致上一次运算的值保留了下来，
        再次执行方法的时候就会将值累加，
        这样会导致即使在同一级目录下的文件也会呈现树形分级,
        因此，此处要定义一个局部变量，
        每次执行的时候更新相应的全局变量，因为局部变量在方法每次执行完的时候被销毁，
        也就是说每次执行该方法的时，这个局部变量都不一定是相同的值，这样就避免了累加
        */

        String preStr = "";
        this.preStr=preStr;

        for (int i = 0; i < level; i++) {

            //判断level的层级数，每多一层就添加一个间隔
            preStr +="\t";
        }

        //定义文件数组，用存放获取到的文件目录和文件
        File[] childs = f.listFiles();

        for (int i = 0; i < childs.length; i++) {
        	
            //用for 循环一个个取出来
            //childs[i].isDirectory()用于判断取取出来的file是文件还是目录，然后执行相应的操作
            if (childs[i].isDirectory()) {

                dirs++;//获取一个目录就自加一次，记录数量           

            }else {

                files++;//获取一个文件就自加一次，记录数量
                fileLength=childs[i].length();//该文件的大小（字节数）
                dirLength += childs[i].length();//将获取到的每个文件的大小（字节数）加起来，记录整个目录字节数
            }

            if (!childs[i].isDirectory()) {
                //打印搜索出的文件和目录,如果是文件就显示文件字节数

                System.out.println(preStr + childs[i].getName()+"\t"+fileLength+"字节");    
            }else{

                System.out.println(preStr + childs[i].getName());
                System.out.println(preStr +"-------------------------");
            }

            if (childs[i].isDirectory()) {
                //判断是否为目录，如果是，再次执行tree（）方法，将子目录里面的文件再次遍历出来
                tree(childs[i], level + 1);
            }
        }

    }

    public static void main(String[] args) {

        //给出指定目录
        //File f = new File("D:/DownLoad");
    	String root=System.getProperty("user.dir"); 
    	String uri="";
    	File f = new File(root+uri);

        Test t = new Test(f);
        System.out.println(t.getClass().toString());
        //打印指定目录，即最顶层目录
        System.out.println("目标目录："+f.getName());

        //开始遍历目录
        t.tree(f, 1);
        System.out.println("==============================");
        //打印目录数量和字节数
        System.out.println("这个目录中共:"+dirs+"个目录");
        //打印文件数量和字节数
        System.out.println("这个目录中有:"+files+"个文件"+"  "+"共"+dirLength+"字节");
        //System.out.println("==============================");
    }




}
