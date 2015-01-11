package com.savvis.hr.report;


public class Report {

	public static void main(String[] args) {

		Comparable<Entity> searchCriteria = new Comparable<Entity>() {
			@Override
			public int compareTo(Entity treeData) {
				if (treeData == null)
					return 1;
				boolean nodeOk = treeData.getName().contains("savvis");
				return nodeOk ? 0 : 1;
			}
		};

		Company company = new Company("savvis", 0);
		company.add(company);
		Department department1 = new Department("IT Development", 0);
		company.add(department1);
		Employee manager1 = new Manager("Manager A", 300);
		department1.add(manager1);
		Employee manager2 = new Manager("Manager B", 300);
		manager1.add(manager2);
		Developer developer1 = new Developer("Developer", 1000);
		Tester tester1 = new Tester("QA Tester", 500);
		manager2.add(developer1);
		manager2.add(tester1);

		Department department1x = new Department("DBA Development", 0);
		company.add(department1x);
		Employee manager1x = new Manager("Manager AA", 300);
		department1x.add(manager1x);
		Employee manager2x = new Manager("Manager BB", 300);
		manager1x.add(manager2x);
		Developer developer1x = new Developer("Developer2", 1000);
		Tester tester1x = new Tester("QA Tester2", 500);
		manager2x.add(developer1x);
		manager2x.add(tester1x);
		company.report();

		return;

	}

}
