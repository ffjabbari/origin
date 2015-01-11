package com.savvis.hr.report;

import org.apache.log4j.Logger;

import com.tree.TreeNode;

public class Company extends AbstractEntity {
	static final Logger logger = Logger.getLogger(AbstractEntity.class);

	public Company(String name, double allocation) {
		super(name, allocation);
		// LogManager.getRootLogger().setLevel(Level.INFO);
	}

	@Override
	public void add(Entity entity) {
		if (getDataGraph() == null) {
			setDataGraph(new TreeNode<Entity>(this));
			logger.info("adding Company as root");
		} else {
			if (entity.getType().indexOf("Department") != -1) {
				super.add(this, entity);
			} else {
				super.add(this, entity);
			}
		}
	}

}
