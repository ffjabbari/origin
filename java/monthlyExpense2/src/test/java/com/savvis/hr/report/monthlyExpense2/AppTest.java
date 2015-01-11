package com.savvis.hr.report.monthlyExpense2;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

import com.savvis.hr.report.Company;
import com.savvis.hr.report.Department;
import com.savvis.hr.report.Developer;
import com.savvis.hr.report.Employee;
import com.savvis.hr.report.Entity;
import com.savvis.hr.report.Manager;
import com.savvis.hr.report.Tester;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
        //PropertyConfigurator.configure("log4j.properties");
       // BasicConfigurator.configure();
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
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
		assertTrue("testFailed",manager1.calculateTotalAllocation() == 2100);
        
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
		
		assertTrue("testFailed",manager1x.calculateTotalAllocation() == 2100);
        assertTrue( true );
    }
    
}
