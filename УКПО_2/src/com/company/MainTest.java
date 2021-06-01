package com.company;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

import static org.junit.jupiter.api.Assertions.*;



class MainTest {

    @Test
    void gauss3x3() {
        Assert.assertArrayEquals(Main.gauss(new double[][] {{8,154},{12,56}}, new double[] {6,37},2),new double[] {3.83,-0.16},0.01);
    }

    @Test
    void gaussIncorrect() {
        Assert.assertArrayEquals(Main.gauss(new double[][] {{8,154},{12,56}}, new double[] {6,37},2),new double[] {3.83,-0.16},0.01);
    }

    @Test
    void gauss2x2() {
        Assert.assertArrayEquals(Main.gauss(new double[][] {{1,0,2},{3,0,5},{5,0,1}}, new double[] {12,56,87},3),new double[] {18.479,9.186,-5.4},0.01);
    }

    @Test
    public void testToArrayIndexOutOfBoundsException() {
        try {
            Assert.assertArrayEquals(Main.gauss(new double[][] {{8,154,12},{12,56,34},{14,45,12},{56,18,65}}, new double[] {6,87,85,12},4),new double[] {3.83,-0.16,4.34,6.87},0.01);
        } catch (ArrayIndexOutOfBoundsException ex) {
        }
    }

}




