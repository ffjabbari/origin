package com.tree;

import com.savvis.hr.report.Developer;
import com.savvis.hr.report.Entity;

class SampleData {

	public static TreeNode<Entity> getSet1() {
		TreeNode<Entity> root = new TreeNode<Entity>(new Developer("root", -1));
		{
			TreeNode<Entity> node0 = root.addChild(new Developer("node0", 0));
			TreeNode<Entity> node1 = root.addChild(new Developer("node1", 1));
			TreeNode<Entity> node2 = root.addChild(new Developer("node2", 2));
			{
				TreeNode<Entity> node20 = node2.addChild(null);
				TreeNode<Entity> node21 = node2.addChild(new Developer(
						"node21", 21));
				{
					TreeNode<Entity> node210 = node21.addChild(new Developer(
							"node210", 210));
					TreeNode<Entity> node211 = node21.addChild(new Developer(
							"node211", 211));
				}
			}
			TreeNode<Entity> node3 = root.addChild(new Developer("node3", 3));
			{
				TreeNode<Entity> node30 = node3.addChild(new Developer(
						"node30", 30));
			}
		}

		return root;
	}

	public static TreeNode<Entity> getSetSOF() {
		TreeNode<Entity> root = new TreeNode<Entity>(new Developer("root", -1));
		{
			TreeNode<Entity> node0 = root.addChild(new Developer("node0", 0));
			TreeNode<Entity> node1 = root.addChild(new Developer("node1", 1));
			TreeNode<Entity> node2 = root.addChild(new Developer("node2", 2));
			{
				TreeNode<Entity> node20 = node2.addChild(null);
				TreeNode<Entity> node21 = node2.addChild(new Developer(
						"node21", 21));
				{
					TreeNode<Entity> node210 = node20.addChild(new Developer(
							"node210", 210));
				}
			}
		}

		return root;
	}
}