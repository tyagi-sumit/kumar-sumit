package com.myStudy.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.myStudy.main.Calculator;

class JUnit5AnnotationTest
{
  /**
   * @BeforeAll The annotated method will be run before all test methods in the
   *            test class. This method must be static.
   */

  @BeforeAll
  static void setup()
  {
    System.out.println("@BeforeAll executed");
  }

  /**
   * @BeforeEach The annotated method will be run before each test method in the
   *             test class.
   * @BeforeEach annotated method MUST NOT be a static method otherwise it will
   *             throw runtime error.
   * 
   *             org.junit.platform.commons.JUnitException: @BeforeEach method
   *             'public static void
   *             com.myStudy.JUnit5AnnotationsTest.setupThis()' must not be
   *             static.
   * 
   */
  @BeforeEach
  void setupThis()
  {
    System.out.println("@BeforeEach executed");
  }

  /**
   * @Tag Mark test methods or test classes with tags for test discovering and
   *      filtering
   */
  @Tag("DEV")
  /**
   * @Test It is used to mark a method as junit test
   */
  @Test
  @DisplayName("Add operation test")
  void testCalcOne()
  {
    System.out.println("======TEST ONE EXECUTED=======");
    Assertions.assertEquals(4, Calculator.add(2, 2));
  }

  @Tag("PROD")
  /**
   * @Disabled It is used to disable or ignore a test class or method from test
   *           suite.
   */
  //@Disabled
  @Test
  void testCalcTwo()
  {
    System.out.println("======TEST TWO EXECUTED=======");
    Assertions.assertEquals(6, Calculator.add(2, 4));
  }
  /**
   * @AfterEach The annotated method will be run after each test method in the
   *            test class.
   */
  @AfterEach
  void tearThis()
  {
    System.out.println("@AfterEach executed");
  }

  /**
   * @AfterAll The annotated method will be run after all test methods in the
   *           test class. This method must be static.
   */
  @AfterAll
  static void tear()
  {
    System.out.println("@AfterAll executed");
  }
  
  @DisplayName("Add operation test (1,1)")
  @RepeatedTest(2)
  void addNumber() {
      Assertions.assertEquals(2, Calculator.add(1, 1), "1 + 1 should equal 2");
  }
}
