package com.succez.filesystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MapTest {

	public static void main(String[] args) {
		Map<String,List> coll = new HashMap<String,List>();
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		coll.put("1",list);
		List<String> results = (List<String>)coll.get("1");
		System.out.println(coll);//这里的s就是map中的key，map.get(s)就是key对应的value。
	}

}
