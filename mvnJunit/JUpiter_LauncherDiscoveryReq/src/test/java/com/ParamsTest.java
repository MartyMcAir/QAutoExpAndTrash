package com;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParamsTest {

    @ParameterizedTest
    @ValueSource(strings = {"val1", "val2"})
    public void stringToUpperCaseTest1(String val) {
        System.out.println(val);
    }

    @ParameterizedTest
    @CsvFileSource(resources = {"/some.csv"})
    public void stringToUpperCaseTest2(String val) {
        System.out.println(val);
    }

}