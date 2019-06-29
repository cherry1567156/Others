package com.succez.filesystem;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
 
public class jsonTest {
 
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("msg", "yes");//map里面装有yes
        String json =new Gson().toJson(map); 
        System.out.println(json); 
    }
 
}