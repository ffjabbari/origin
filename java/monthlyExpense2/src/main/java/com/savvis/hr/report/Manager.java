package com.savvis.hr.report;

import org.apache.log4j.Logger;

public class Manager extends AbstractEntity implements Employee {
	static final Logger logger = Logger.getLogger(Manager.class);

	public Manager(String name, double allocation) {
		super(name, allocation);
	}

	@Override
	public void add(Entity entity) {
		super.add(this, entity);
		logger.info("adding Manager");
	}

	@Override
	public String toString() {
		String additionalData = "";
		double totalAllocation = super.calculateTotalAllocation();
		int depth = super.calculateTotalDepth();
		if (depth > 1 && totalAllocation > 0) {
			additionalData = " Total Allocation is: " + totalAllocation;
		}

		return super.toString() + additionalData;
	}
}