package com.succez.practice1;

import org.apache.log4j.Logger;

/**
 * 这是二叉树类
 * <p>Copyright: Copyright (c) 2017</p>
 * <p>succez</p>
 * @author wengxinh
 * @createdate 2017年11月3日
 */
public class TNode {
	/**
	 * log4j 日志输出
	 */
	public static Logger logger1 = Logger.getLogger(TNode.class);

	private String data;

	private TNode left;

	private TNode right;

	public TNode() {
		this.data = null;
		this.left = null;
		this.right = null;
	}

	public TNode(String v) {
		this.data = v;
	}

	public TNode(String v, TNode l, TNode r) {
		this.data = v;
		this.left = l;
		this.right = r;
	}

	/**
	 * 定义一个静态计数变量
	 */
	public static int counter = 0;

	/**
	 * 创建二叉树的方法
	 * @param root 二叉树根节点
	 * @param a 二叉树先序遍历字符串
	 * @param i 节点数目
	 * @return 一个二叉树对象
	 */
	public TNode createBiTree(TNode root, String[] a, int i) {
		if (i < a.length) {
			if ("#" == a[i]) {
				return root;
			}
			else {
				TNode lchild = new TNode();
				TNode rchild = new TNode();
				root.data = a[i];
				root.left = createBiTree(lchild, a, ++counter);
				root.right = createBiTree(rchild, a, ++counter);
			}
		}
		return root;
	}

	/**
	 * 返回二叉树第level层的数据
	 * @param tree 树根节点
	 * @param level 需要访问的层数
	 * @return 返回level层的所有节点数据
	 */
	public String treeLevel(TNode tree, int level) {
		//如果树为空返回null
		if (tree.data == null) {
			logger1.error("空树");
			return null;
		}
		//如果大于树的深度，返回null
		else if (level > tree.getDepth(tree) || level < 1) {
			logger1.error("level输入有误:level超出树的范围");
			return null;
		}
		else {
			StringBuffer s = new StringBuffer();
			treeLevelDo(tree, level, s);
			return s.toString();
		}
	}

	/**
	 * 获取二叉树节点的value并存到StringBuffer中
	 * @param tree 树的根节点
	 * @param level 树的第level层
	 * @param b 传入一个StringBuffer，用来存储节点数据
	 */
	public void treeLevelDo(TNode tree, int level, StringBuffer b) {
		if (tree != null) {
			if (1 == level) {
				if (b.length() == 0) {
					b.append(tree.data);
				}
				else
					b.append("-" + tree.data);
			}
			level--;
			treeLevelDo(tree.left, level, b);
			treeLevelDo(tree.right, level, b);
		}
	}

	/**
	 * 获取该树的深度的方法
	 * @param root 树的根节点
	 * @return 返回树的高度
	 */
	public int getDepth(TNode root) {
		if (root.data == null) {
			return 0;
		}
		else {
			int left = getDepth(root.left);
			int right = getDepth(root.right);
			return 1 + Math.max(left, right);
		}
	}
}
