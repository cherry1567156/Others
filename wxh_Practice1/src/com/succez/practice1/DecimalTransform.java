package com.succez.practice1;

/**
 * 这是进制转换类
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>succez</p>
 * @author wengxinh
 * @createdate 2017年11月3日
 */
public class DecimalTransform {

	/**
	 * 将十进制转换成16进制，返回一个16进制数字的字符串
	 * @param int x  十进制数
	 * @return String hex 16进制字符串
	 */
	public String intToHex(int x) {
		String t = null;
		StringBuffer s = new StringBuffer(16);
		if (x < 0) {
			x = -x;
			t = "-";
			//如果是负数，先将‘-’存入StringBuffer中
			s.append(t);
		}
		s.append("0x");
		//0x为16进制数前缀
		if (x == 0)
			s.append("0");
		while (x > 0) {
			int temp = x & 15;
			//将x与1111按位与运算
			if (temp > 9) {
				char a = (char) (temp - 10 + 'A');
				s.append(a);
			}
			else
				s.append(temp);
			//x右移动4位，继续与运算
			x = x >>> 4;
		}
		return s.toString();
	}
}
