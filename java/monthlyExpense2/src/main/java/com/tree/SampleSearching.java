package com.tree;

import com.savvis.hr.report.Entity;

class SampleSearching {

	public static void main(String[] args) {

		Comparable<Entity> searchCriteria = new Comparable<Entity>() {
			@Override
			public int compareTo(Entity treeData) {
				if (treeData == null)
					return 1;
				boolean nodeOk = treeData.getName().contains("210");
				return nodeOk ? 0 : 1;
			}
		};

		TreeNode<Entity> treeRoot = SampleData.getSet1();
		TreeNode<Entity> found = treeRoot.findTreeNode(searchCriteria);

		System.out.println("Found: " + found);
	}

}