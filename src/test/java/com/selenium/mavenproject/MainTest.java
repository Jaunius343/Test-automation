package com.selenium.mavenproject;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * A simple unit test
 */
public class MainTest 
{
    /**
     * Rigorous Test :-)
     */
	public static User user;
	String fileName1 = "data1.txt";
	String fileName2 = "data2.txt";
	
	@BeforeAll
	public static void initializeData() {
		Lab4_User createUser = new Lab4_User();
		user = createUser.run();
	}
	
	@Test
	public void test_scenario_1 () {
		Lab4_Test test = new Lab4_Test();
		test.run(user, fileName2);
	}
	
	@Test
	public void test_scenario_2() {
		Lab4_Test test = new Lab4_Test();
		test.run(user, fileName2);
	}
	
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
