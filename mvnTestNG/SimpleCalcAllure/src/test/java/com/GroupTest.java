package com;

import org.testng.annotations.Test;

// https://www.lambdatest.com/blog/grouping-test-cases-in-testng/
// https://howtodoinjava.com/testng/testng-test-groups/
// https://howtodoinjava.com/testng/testng-test-groups/
// https://www.guru99.com/introduction-testng-groups.html
public class GroupTest {

    @Test(groups = {"group1"}, priority = 111)
    public void someTest() {
        System.out.println("group1: someTest1");
    }

    @Test(groups = {"group1"}, priority = 10)
    public void someTest2() {
        System.out.println("group1: someTest2");
    }


    @Test(groups = {"group2"})
    public void someTest3() {
        System.out.println("group2: someTest1");
    }

    @Test(groups = "group2")
    public void someTest4() {
        System.out.println("group2: someTest2");
    }

}