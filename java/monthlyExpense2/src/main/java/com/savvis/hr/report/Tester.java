package com.savvis.hr.report;

import org.apache.log4j.Logger;


public class Tester extends AbstractEntity implements Employee {
	static final Logger logger = Logger.getLogger(Tester.class);
	public Tester(String name, double salary) {
		super(name, salary);
		logger.info("adding Tester");
	}

	@Override
	public void add(Entity entity) {
		super.add(this, entity);
	}
}
