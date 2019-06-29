package com.succez.practice1test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.succez.practice1.TNode;

/**
 * 这是TNode测试类
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>succez</p>
 * @author cherry
 * @createdate 2017年11月4日
 */
public class TNodeTest {

	@Test
	//测试TreeLevel方法
	public void testTreeLevel() {
		TNode root = new TNode();
		TNode root1 = new TNode();
		String[] a = { "A", "B", "G", "#", "#", "H", "#", "#", "D", "C", "#", "#", "F", "#", "#" };
		String[] b = {"#"};
		root=root.createBiTree(root, a, TNode.counter);
		root1=root1.createBiTree(root1, b, TNode.counter);
		//测试树的-1层
		assertNull(root.treeLevel(root, -1));
		//测试树的第0层
		assertNull(root.treeLevel(root, 0));
		//测试树的第1层
		assertEquals("A", root.treeLevel(root, 1));
		//测试树的第2层
		assertEquals("B-D", root.treeLevel(root, 2));
		//测试树的第3层
		assertEquals("G-H-C-F", root.treeLevel(root, 3));
		//测试树的第4层
		assertNull(root.treeLevel(root, 4));
		//测试level=-1
		assertNull(root1.treeLevel(root1, -1));
		//测试空树
		assertNull(root1.treeLevel(root1, 0));
		//测试空树
		assertNull(root1.treeLevel(root1, 1));
		//测试空树
		assertNull(root1.treeLevel(root1, 2));
		//测试空树
		assertNull(root1.treeLevel(root1, 3));
	}
}
