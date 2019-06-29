package test;

import java.util.HashMap;
import java.util.Map;

public class test {

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();
		map.put("aa", 1);
		map.put("bb", 2);
		map.put("cc", 3);
		map.put("dd", 4);
		Map<String, Object> map1 = new HashMap<>();
		map1.put("bb", 2);
		map1.put("cc", 3);
		map1.put("dd", 4);
		map.putAll(map1);
		System.out.println(map1.size());
	}

}
