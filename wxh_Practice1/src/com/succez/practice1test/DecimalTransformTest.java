package com.succez.practice1test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.succez.practice1.DecimalTransform;

/**
 * 这是IntToHex的测试类
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>succez</p>
 * @author wengxinh
 * @createdate 2017年11月4日
 */
public class DecimalTransformTest {

	@Test
	public void testIntToHex() {
		DecimalTransform s1 = new DecimalTransform();
		//测试0
		assertEquals("0x0", s1.intToHex(0));
		//测试负数
		assertEquals("-0xFF", s1.intToHex(-255));
		//测试正数
		assertEquals("0xFF", s1.intToHex(255));
		//测试大数
		assertEquals("0xF324F", s1.intToHex(999999));
	}

}
