package com.livvy.Junit.Charpter1;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2016/7/21 0021.
 */
public class TestRunner {
    @Test
    public void Charpter1Test() {
        Charpter1 charpter1 = new Charpter1();
        Assert.assertEquals(3, charpter1.CalculteNum(1, 2));
    }

}
