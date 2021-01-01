package com.qa;

import com.qa.base.DriverFactory;
import com.qa.utils.ReadProperties;
import org.junit.Test;

public class MyTestRunner {

    @Test
    public void testmethod(){

        System.out.println("Test");
        DriverFactory factory=DriverFactory.getInstance();
        factory.initDriver();
        DriverFactory factory1=DriverFactory.getInstance();
        factory1.getDriver().get(ReadProperties.getProperties("url"));
        System.out.println(factory.hashCode());
        System.out.println(factory1.hashCode());
        System.out.println(factory==factory1);
    }
}
