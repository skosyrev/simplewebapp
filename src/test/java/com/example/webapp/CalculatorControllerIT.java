package com.example.webapp;

import org.testng.annotations.Test;

import static org.testng.Assert.*;


public class CalculatorControllerIT {

    @Test
    public void testMultiply() throws Exception {
        assertEquals(HTTPRequestTestHelper.getResponse("http://localhost:8080/calc/multiply?a=13&b=3"), "39");
    }

    @Test
    public void testDivide() throws Exception {
        assertEquals(HTTPRequestTestHelper.getResponse("http://localhost:8080/calc/divide?a=33&b=3"), "11");
    }

    @Test
    public void testAdd() throws Exception {
        assertEquals(HTTPRequestTestHelper.getResponse("http://localhost:8080/calc/add?a=13&b=3"), "16");
    }

    @Test
    public void testSubstract() throws Exception {
        assertEquals(HTTPRequestTestHelper.getResponse("http://localhost:8080/calc/substract?a=13&b=3"), "10");
    }
}