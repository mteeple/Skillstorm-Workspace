package com.skillstorm.test;

import com.skillstorm.code.ApplicationComponent;

//junit.framework is deprecated for Assert so we will use. May not work as expected because deprecated
//org.junit instead for the Assert import. Will work as expected unlike junit.framework

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*; //import all static methods

//with Maven Build you can set how far in the lifecycle you want the file to build. 
//You can also clean the files before it with something like clean package in the build directory

// src/test/code this is our testing code
// JavaCoco (Java Code Coverage is a useful tool)
// in src/test/java files ending with *Test get run by Maven
public class ExampleTest { 
	
	static ApplicationComponent component;
	
	//before all my tests - run this setup method
	@BeforeClass
	public static void setupBeforeAll() {
		component = new ApplicationComponent();
	}
	
	
	@Test //tells Junit that this is a test method (Test case)
	public void testCheckId() {
		//ApplicationComponent component = new ApplicationComponent(); // remove this and put it in BeforeClass
		boolean actual = component.checkId(25); //expect to get true
		boolean expected = true;
		
		//Assert methods - if (expected == actual) else throw new AssertionException
		assertEquals(expected, actual);
	}
	
	@Test 
	public void testUnder18() {
		assertEquals(false, component.checkId(12));
	}
	
	//negative testing - testing invalid inputs
	//expected == fail the test if the exception is not thrown
	@Test(expected = IllegalArgumentException.class) //unhandled exceptions will FAIL test method
	public void testUnderZero() {
		component.checkId(-1);
	}
	
	//TDD - Write Tests first
	//testing now for alcohol age of 21
	@Test
	public void testUnder21() {
		assertEquals(false, component.checkId(20, "beer"));
	}
	@Test
	public void testOver21() {
		assertEquals(true, component.checkId(21, "beer"));
	}
	
}
