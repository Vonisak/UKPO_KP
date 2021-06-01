package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    // Тесты для функции gauss
    @Test
    void gauss3x3() {
        Assertions.assertArrayEquals(GaussCalc.gauss(new double[][] {{8,154},{12,56}}, new double[] {6,37},2),new double[] {3.83,-0.16},0.01);
    }

    @Test
    void gaussIncorrect() {
        Assertions.assertArrayEquals(GaussCalc.gauss(new double[][] {{8,154},{12,56}}, new double[] {6,37},2),new double[] {3.83,-0.16},0.01);
    }

    @Test
    void gauss2x2() {
        Assertions.assertArrayEquals(GaussCalc.gauss(new double[][] {{1,0,2},{3,0,5},{5,0,1}}, new double[] {12,56,87},3),new double[] {18.479,9.186,-5.4},0.01);
    }

    @Test
    public void testToArrayIndexOutOfBoundsException() {
        try {
            Assertions.assertArrayEquals(GaussCalc.gauss(new double[][] {{8,154,12},{12,56,34},{14,45,12},{56,18,65}}, new double[] {6,87,85,12},4),new double[] {3.83,-0.16,4.34,6.87},0.01);
        } catch (ArrayIndexOutOfBoundsException ex) {
        }
    }


    // Тесты для UI
    @Test
    void test1() {
        GaussCalc.main(null);
        GaussCalc.el00.setText("2");
        GaussCalc.el01.setText("4");
        GaussCalc.el02.setText("1");
        GaussCalc.el0.setText("36");
        GaussCalc.el10.setText("5");
        GaussCalc.el11.setText("2");
        GaussCalc.el12.setText("1");
        GaussCalc.el1.setText("47");
        GaussCalc.el20.setText("2");
        GaussCalc.el21.setText("3");
        GaussCalc.el22.setText("4");
        GaussCalc.el2.setText("37");
        GaussCalc.calc.setEnabled(true);
        GaussCalc.calc.doClick();
        Assertions.assertEquals("Ответ: x1 = 7.0 x2 = 4.999999999999999 x3 = 2.0", GaussCalc.answer.getText());
    }

    @Test
    void test2() {
        GaussCalc.main(null);
        GaussCalc.el00.setText("2");
        GaussCalc.el01.setText("4");
        GaussCalc.el02.setText("1");
        GaussCalc.el0.setText("36");
        GaussCalc.el10.setText("5");
        GaussCalc.el11.setText("2");
        GaussCalc.el12.setText("1");
        GaussCalc.el1.setText("47");
        GaussCalc.el20.setText("2");
        GaussCalc.el21.setText("3");
        GaussCalc.el22.setText("4");
        GaussCalc.el2.setText("37");
        GaussCalc.cancel.setEnabled(true);
        GaussCalc.cancel.doClick();
        Assertions.assertEquals( "",GaussCalc.el00.getText());
        Assertions.assertEquals( "",GaussCalc.el01.getText());
        Assertions.assertEquals( "",GaussCalc.el02.getText());
        Assertions.assertEquals( "",GaussCalc.el0.getText());
        Assertions.assertEquals( "",GaussCalc.el10.getText());
        Assertions.assertEquals( "",GaussCalc.el11.getText());
        Assertions.assertEquals( "",GaussCalc.el12.getText());
        Assertions.assertEquals( "",GaussCalc.el1.getText());
        Assertions.assertEquals( "",GaussCalc.el20.getText());
        Assertions.assertEquals( "",GaussCalc.el21.getText());
        Assertions.assertEquals( "",GaussCalc.el22.getText());
        Assertions.assertEquals( "",GaussCalc.el2.getText());
    }

    @Test
    void test3() {
        try {
            GaussCalc.main(null);
            GaussCalc.el00.setText("2");
            GaussCalc.el01.setText("4");
            GaussCalc.el02.setText("1");
            GaussCalc.el0.setText("36");
            GaussCalc.el10.setText("5");
            GaussCalc.el11.setText("2");
            GaussCalc.el12.setText("1");
            GaussCalc.el1.setText("каапва");
            GaussCalc.el20.setText("2");
            GaussCalc.el21.setText("3");
            GaussCalc.el22.setText("4");
            GaussCalc.el2.setText("37");
            GaussCalc.calc.doClick();
        } catch (NumberFormatException nfe){}
    }

    @Test
    void test4() {
        Assertions.assertFalse(GaussCalc.cancel.isEnabled());
    }

}




