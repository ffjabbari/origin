package com.savvis.hr.report;

import java.util.List;

public interface Entity {

	/**
	 * @return
	 */
	public String getName();

	/**
	 * @param name
	 */
	public void setName(String name);

	/**
	 * @return
	 */
	public double getAllocation();

	/**
	 * @param allocation
	 */
	public void setAllocation(double allocation);

	/**
	 * @return
	 */
	public String toString();

	/**
	 * @return
	 */
	public List<Entity> report();

	/**
	 * @return
	 */
	public List<Entity> getExpenseDetail();

	/**
	 * @return
	 */
	public List<Entity> getExpenseSummary();

	/**
	 * @param entity
	 */
	public void add(Entity entity);

	/**
	 * @param currNode
	 * @param newNode
	 */
	public void add(Entity currNode, Entity newNode);

	/**
	 * @param entity
	 */
	public void remove(Entity entity);

	/**
	 * @param i
	 * @return
	 */
	public Entity getChild(int i);

	/**
	 * @return
	 */
	public String getType();

	/**
	 * @param lstEntity
	 */
	public void printChildren(List<Entity> lstEntity);

	/**
	 * @return
	 */
	public double calculateTotalAllocation();

	/**
	 * @return
	 */
	public int calculateTotalDepth();
}
