package com.myStudy.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.myStudy.main.ProjectHelper;

class ProjectHelperTest {
	ProjectHelper helper = null;

	// @BeforeEach same as below it came in junit version 5
	// @Before @After are available in JUnit 4
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("setUp() .. called");
		helper = new ProjectHelper();
	}

	// @AfterEach same as below it came in junit version 5
	// @After
	@AfterEach
	void tearDown() throws Exception {
		System.out.println("tearDown() .. called");
	}

	@BeforeClass
	public void testBeforeClass() {
		System.out.println("Testing before class......");
	}

	@AfterClass
	public void testAfterClass() {
		System.out.println("Testing before class......");
	}

	@Test
	public void testTruncateAInFirst2Positions_AinFirstTwoPositions() {
		assertEquals("CD", helper.truncateAInFirstTwoPositions("AACD"));
	}

	@Test
	public void testTruncateAInFirst2Positions2_AinFirstPosition() {
		assertEquals("CD", helper.truncateAInFirstTwoPositions("ACD"));
	}

   //ABCD - > false , ABAB --> true,  AB--> true, A--> false,
	@Test
	public void testFirstAndLastTwoCharAreSame() {
		boolean actualVal = helper.firstAndLastTwoCharTheSame("ABCD");
		// 1. way to do assert
		assertEquals(false, actualVal);
//Second way to do assert
		assertFalse("CommonString", actualVal);
		// assertFalse("This condition has failed.", true);

	}

	@Test
	public void testAreFirstandLastTwoCharAreSame_2Condition() {
		boolean actualVal = helper.firstAndLastTwoCharTheSame("ABAB");
		assertEquals(true, actualVal);
		assertTrue("CommonString", actualVal);
	}

	@Test
	public void testAreFirstandLastTwoCharAreSame_3Condition() {
		boolean actualVal = helper.firstAndLastTwoCharTheSame("AB");
		assertEquals(true, actualVal);
		assertTrue("CommonString", actualVal);
	}

	@Test
	public void testAreFirstandLastTwoCharAreSame_4Condition() {
		boolean actualVal = helper.firstAndLastTwoCharTheSame("A");
		assertEquals(false, actualVal);
		assertFalse("CommonString", actualVal);

	}

	@Test
	public void arrayTest() {
		int[] actual = { 20, 30, 7 };
		int[] expectedArray = { 7, 20, 30 };
		Arrays.sort(actual);

		// assertEquals(expectedArray, actual);
		assertArrayEquals(expectedArray, actual);
	}

	@Test
	public void arrayExceptionTest() {
		int[] actual = { 20, 30, 7 };
		//Implementation of Executable (Functional interface)  execute method
		Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
			System.out.println(actual[3]);
		});

	}

	@Test()
	public void arrayTimeOutTest() {
		int[] actual = { 20, 30, 7 };

	}
	@Test
	void testExpectedException() {

		Assertions.assertThrows(NumberFormatException.class, () -> {
			Integer.parseInt("One");
		});
	}

	@Test
	void testExpectedExceptionWithSuperType() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Integer.parseInt("One");
		});
	}

	@Test
	void testExpectedExceptionFail() {

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			Integer.parseInt("1");
		});
	}
	
	@Test
	void timeoutNotExceeded() 
	{
	    //The following assertion succeeds.
	    assertTimeout(Duration.ofMinutes(2), () -> {
	        // Perform task that takes less than 2 minutes.
	    	System.out.println("timeout with junit 5");
	    });
	}
	 
	@Test
	void timeoutExceeded() 
	{
	    // The following assertion fails with an error message similar to:
	    // execution exceeded timeout of 10 ms by 91 ms
	    assertTimeout(Duration.ofMillis(10), () -> {
	        // Simulate task that takes more than 10 ms.
	        Thread.sleep(100);
	    });
	}
}
