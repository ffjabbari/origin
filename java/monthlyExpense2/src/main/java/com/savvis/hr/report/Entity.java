package com.savvis.hr.report;

import java.util.List;

public interface Entity {

	public String getName();

	public void setName(String name);

	public double getAllocation();

	public void setAllocation(double allocation);

	public String toString();

	public List<Entity> report();

	public List<Entity> getExpenseDetail();

	public List<Entity> getExpenseSummary();

	public void add(Entity entity);

	public void add(Entity currNode, Entity newNode);

	public void remove(Entity entity);

	public Entity getChild(int i);

	public String getType();

	public void printChildren(List<Entity> lstEntity);

	public double calculateTotalAllocation();

	public int calculateTotalDepth();
}
