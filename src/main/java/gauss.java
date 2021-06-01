
import java.awt.event.*;
import javax.swing.*;

class GaussCalc extends JFrame {
    public static JLabel answer = new JLabel("Ответ: ");
    public static JButton calc = new JButton("Решить методом Гаусса");
    public static JButton cancel = new JButton("Очистить поля");
    public static JTextField el00 = new JTextField(4);
    public static JTextField el01 = new JTextField(4);
    public static JTextField el02 = new JTextField(4);
    public static JTextField el0 = new JTextField(4);
    public static JTextField el10 = new JTextField(4);
    public static JTextField el11 = new JTextField(4);
    public static JTextField el12 = new JTextField(4);
    public static JTextField el1 = new JTextField(4);
    public static JTextField el20 = new JTextField(4);
    public static JTextField el21 = new JTextField(4);
    public static JTextField el22 = new JTextField(4);
    public static JTextField el2 = new JTextField(4);

    public GaussCalc(){
        super("Gauss Calculator");
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 350,300);
        final JPanel panel = new JPanel();
        frame.add(panel);
        calc.setEnabled(false);
        cancel.setEnabled(false);

        
        panel.add(el00);
        panel.add(new JLabel("x1 + "));
        panel.add(el01);
        panel.add(new JLabel("x2 + "));
        panel.add(el02);
        panel.add(new JLabel("x3 ="));
        panel.add(el0);
        panel.add(el10);
        panel.add(new JLabel("x1 + "));
        panel.add(el11);
        panel.add(new JLabel("x2 + "));
        panel.add(el12);
        panel.add(new JLabel("x3 ="));
        panel.add(el1);
        panel.add(el20);
        panel.add(new JLabel("x1 + "));
        panel.add(el21);
        panel.add(new JLabel("x2 + "));
        panel.add(el22);
        panel.add(new JLabel("x3 ="));
        panel.add(el2);
        panel.add(calc);
        panel.add(cancel);
        panel.add(answer);

        frame.setVisible(true);

        el00.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calc.setEnabled(block());
                cancel.setEnabled(blockCancel());
            }
        });

        el01.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calc.setEnabled(block());
                cancel.setEnabled(blockCancel());

            }
        });

        el02.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calc.setEnabled(block());
                cancel.setEnabled(blockCancel());
            }
        });

        el0.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calc.setEnabled(block());
                cancel.setEnabled(blockCancel());
            }
        });

        el10.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calc.setEnabled(block());
                cancel.setEnabled(blockCancel());
            }
        });

        el11.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calc.setEnabled(block());
                cancel.setEnabled(blockCancel());
            }
        });

        el12.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calc.setEnabled(block());
                cancel.setEnabled(blockCancel());
            }
        });

        el1.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calc.setEnabled(block());
                cancel.setEnabled(blockCancel());
            }
        });

        el20.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calc.setEnabled(block());
                cancel.setEnabled(blockCancel());
            }
        });

        el21.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calc.setEnabled(block());
                cancel.setEnabled(blockCancel());
            }
        });

        el22.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calc.setEnabled(block());
                cancel.setEnabled(blockCancel());
            }
        });

        el2.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calc.setEnabled(block());
                cancel.setEnabled(blockCancel());
            }
        });

        cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                el00.setText("");
                el01.setText("");
                el02.setText("");
                el0.setText("");
                el10.setText("");
                el11.setText("");
                el12.setText("");
                el1.setText("");
                el20.setText("");
                el21.setText("");
                el22.setText("");
                el2.setText("");
                answer.setText("Ответ: ");
                panel.updateUI();
            }
        });

        calc.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {

                double[][] matrix = new double[][]{{Double.parseDouble(String.valueOf(el00.getText())), Double.parseDouble(String.valueOf(el01.getText())), Double.parseDouble(String.valueOf(el02.getText()))},
                        {Double.parseDouble(String.valueOf(el10.getText())), Double.parseDouble(String.valueOf(el11.getText())), Double.parseDouble(String.valueOf(el12.getText()))},
                        {Double.parseDouble(String.valueOf(el20.getText())), Double.parseDouble(String.valueOf(el21.getText())), Double.parseDouble(String.valueOf(el22.getText()))}};
                double[] y = new double[]{Double.parseDouble(String.valueOf(el0.getText())), Double.parseDouble(String.valueOf(el1.getText())), Double.parseDouble(String.valueOf(el2.getText()))};
                double[] x = gauss(matrix, y, 3);

                answer.setText("Ответ: " + "x1 = " + x[0] + " x2 = " + x[1] + " x3 = " + x[2]);
            }
        });
    }

    public static boolean blockCancel () {
        if (((el00.getText().equals("")
                && el01.getText().equals("")
                && el02.getText().equals("")
                && el0.getText().equals("")
                && el10.getText().equals("")
                && el11.getText().equals("")
                && el12.getText().equals("")
                && el1.getText().equals("")
                && el20.getText().equals("")
                && el21.getText().equals("")
                && el22.getText().equals("")
                && el2.getText().equals("")))) {
            return false;
        }else return true;
    }

    public static boolean block () {
        if ((el00.getText().equals("")
                || el01.getText().equals("")
                || el02.getText().equals("")
                || el0.getText().equals("")
                || el10.getText().equals("")
                || el11.getText().equals("")
                || el12.getText().equals("")
                || el1.getText().equals("")
                || el20.getText().equals("")
                || el21.getText().equals("")
                || el22.getText().equals("")
                || el2.getText().equals(""))
                || (el00.getText().equals("")
                && el01.getText().equals("")
                && el02.getText().equals("")
                && el0.getText().equals("")
                && el10.getText().equals("")
                && el11.getText().equals("")
                && el12.getText().equals("")
                && el1.getText().equals("")
                && el20.getText().equals("")
                && el21.getText().equals("")
                && el22.getText().equals("")
                && el2.getText().equals(""))) {
            return false;
        } else {
            return true;
        }
    }

    public static int findMax(double[][] matrix, int n, int k) {  //Поиск строки с максимальным matrix[i][k]
        double max = Math.abs(matrix[k][k]);
        int index = k;
        for (int i = k + 1; i < n; i++) {
            if (Math.abs(matrix[i][k]) > max) {
                max = Math.abs(matrix[i][k]);
                index = i;
            }
        }
        return index;
    }

    public static double[] gauss(double[][] matrix, double[] y, int n) {
        double[] x;
        double max;
        int k, index;
        double eps = 0.00001;
        x = new double[n];
        k = 0;
        while (k < n) {
            index = findMax(matrix,n,k);
            //Перетасовка строк
            if (matrix[index][k] < eps) {
                //Нет нулевых диагональных элементов
                System.out.print("Решение получить невозможно из-за нулевого столбца " + index + " матрицы\n");
                break;
            }
            for (int j = 0; j < n; j++) {
                double temp = matrix[k][j];
                matrix[k][j] = matrix[index][j];
                matrix[index][j] = temp;
            }
            double temp = y[k];
            y[k] = y[index];
            y[index] = temp;
            //Нормализация уровней
            for (int i = k; i < n; i++) {
                double temp1 = matrix[i][k];
                if (Math.abs(temp1) < eps) continue; // для нулевого коэффициента пропустить
                for (int j = 0; j < n; j++)
                    matrix[i][j] = matrix[i][j] / temp1;
                y[i] = y[i] / temp1;
                if (i == k)  continue; // уравнение не вычитать само из себя
                for (int j = 0; j < n; j++)
                    matrix[i][j] = matrix[i][j] - matrix[k][j];
                y[i] = y[i] - y[k];
            }
            k++;
        }
        //Обратная подстановка
        for (k = n - 1; k >= 0; k--) {
            x[k] = y[k];
            for (int i = 0; i < k; i++)
                y[i] = y[i] - matrix[i][k] * x[k];
        }
        return x;
    }

    public static void main(String[] args) {
        GaussCalc app = new GaussCalc();
    }
}
