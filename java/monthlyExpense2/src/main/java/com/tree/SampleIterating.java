package com.tree;

import com.savvis.hr.report.Entity;

class SampleIterating {

	public static void main(String[] args) {
		TreeNode<Entity> treeRoot = SampleData.getSet1();
		for (TreeNode<Entity> node : treeRoot) {
			String indent = createIndent(node.getLevel());
			System.out.println(indent + node.data);
		}
	}

	private static String createIndent(int depth) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			sb.append(' ');
		}
		return sb.toString();
	}

}