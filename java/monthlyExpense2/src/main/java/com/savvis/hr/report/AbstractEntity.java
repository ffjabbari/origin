package com.savvis.hr.report;

import java.util.List;

import com.tree.TreeNode;

public abstract class AbstractEntity implements Entity {
	private String name;
	private double allocation;
	public static TreeNode<Entity> dataGraph;

	public AbstractEntity(String name, double allocation) {
		this.name = name;
		this.allocation = allocation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getAllocation() {
		return allocation;
	}

	public void setAllocation(double allocation) {
		this.allocation = allocation;
	}

	public String toString() {

		StringBuffer buf = new StringBuffer();
		buf.append("Name:" + getName());
		buf.append(" Type: " + getType());
		buf.append(" Allocation: " + getAllocation());

		return buf.toString();
	}

	public List<Entity> report() {

		TreeNode<Entity> treeRoot = dataGraph;
		for (TreeNode<Entity> node : treeRoot) {
			String indent = createIndent(node.getLevel());
			System.out.println(indent + node.getLevel() + " " + node.data);
		}

		return null;
	}

	private static String createIndent(int depth) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < depth; i++) {
			sb.append(' ');
		}

		return sb.toString();
	}

	public List<Entity> getExpenseDetail() {
		return null;
	}

	public void printChildren(List<Entity> lstEntity) {
		for (Entity entity : lstEntity) {
			System.out.println(entity.toString());
		}
	}

	public void printChildren() {

	}

	public List<Entity> getExpenseSummary() {
		return null;
	}

	public void add(Entity entity) {
		getDataGraph().addChild(entity);
	}

	public void add(final Entity currNode, Entity newNode) {

		Comparable<Entity> searchCriteria = new Comparable<Entity>() {
			@Override
			public int compareTo(Entity treeData) {
				if (treeData == null)
					return 1;
				boolean nodeOk = treeData.getName()
						.contains(currNode.getName());
				return nodeOk ? 0 : 1;
			}
		};

		TreeNode<Entity> currNodex = getDataGraph()
				.findTreeNode(searchCriteria);

		System.out.println("Found: " + currNodex);

		currNodex.addChild(newNode);

	}

	public TreeNode<Entity> findNode(final String searchArg) {

		Comparable<Entity> searchCriteria = new Comparable<Entity>() {
			@Override
			public int compareTo(Entity treeData) {
				if (treeData == null)
					return 1;
				boolean nodeOk = treeData.getName().contains(searchArg);
				return nodeOk ? 0 : 1;
			}
		};

		TreeNode<Entity> currNodex = getDataGraph()
				.findTreeNode(searchCriteria);

		return currNodex;

	}

	public void remove(Entity entity) {

	}

	public Entity getChild(int i) {

		return null;

	}

	public List<Entity> getLstChildren() {
		return null;
	}

	public String getType() {
		String simpleClassName = "";
		String fullClassName = this.getClass().getName();
		int lastDot = fullClassName.lastIndexOf('.');
		if (lastDot != -1) {
			lastDot++;
			simpleClassName = fullClassName.substring(lastDot);
		}

		return simpleClassName;
	}

	public TreeNode<Entity> getDataGraph() {
		return dataGraph;
	}

	public void setDataGraph(TreeNode<Entity> dataGraph) {
		this.dataGraph = dataGraph;
	}

	@Override
	public double calculateTotalAllocation() {
		double totalAlloc = 0;
		for (TreeNode<Entity> node : findNode(name)) {
			totalAlloc = totalAlloc + node.data.getAllocation();
		}

		return totalAlloc;

	}

	@Override
	public int calculateTotalDepth() {
		int levelOriginal = findNode(name).getLevel();
		int levelCurrent = -1;
		int depth = -1;
		for (TreeNode<Entity> node : findNode(name)) {
			levelCurrent = node.getLevel();
		}

		depth = levelCurrent - levelOriginal;

		return depth;
	}

}
