package com.savvis.hr.report;

import org.apache.log4j.Logger;

public class Department extends AbstractEntity {
	static final Logger logger = Logger.getLogger(Department.class);

	public Department(String name, double allocation) {
		super(name, allocation);

	}

	@Override
	public void add(Entity entity) {
		super.add(this, entity);
		logger.info("adding Department");
	}

	@Override
	public String toString() {
		String additionalData = "";
		double totalAllocation = super.calculateTotalAllocation();
		if (totalAllocation > 0) {
			additionalData = " Total Allocation is: " + totalAllocation;
		}

		return super.toString() + additionalData;
	}
}