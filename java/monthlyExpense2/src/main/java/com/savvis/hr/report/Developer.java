package com.savvis.hr.report;

import org.apache.log4j.Logger;

public class Developer extends AbstractEntity implements Employee {
	static final Logger logger = Logger.getLogger(Developer.class);

	public Developer(String name, double salary) {
		super(name, salary);
		logger.info("adding Developer");

	}

	@Override
	public void add(Entity entity) {
		super.add(this, entity);
	}
}
