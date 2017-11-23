package com.korfax.simple_servlet.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Korfax on 2017-11-22.
 */
public class MainControllerTest {

    private static final Logger log = LoggerFactory.getLogger(MainControllerTest.class);

    MainController mc;

    @BeforeClass
    public void setup() {
        mc = new MainController();
    }

    @Test
    public void test1() throws NoSuchFieldException, IllegalAccessException {
        ArrayList<String> testList = new ArrayList<String>();
        testList.add("test1");
        log.debug(Arrays.toString(testList.toArray()));

        Field linesField = mc.getClass().getDeclaredField("lines");
        linesField.setAccessible(true);
        linesField.set(mc, testList);
        log.debug(Arrays.toString(((ArrayList) linesField.get(mc)).toArray()));

        Assert.assertEquals(((ArrayList) linesField.get(mc)).size(), 1);
    }

}