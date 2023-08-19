package Ex03;

import javax.swing.JOptionPane;

public class Funcionario {

    private double salf, comif;

    public void calc(double sal, double comi) {
        comif = comi * 0.04;
        salf = comif + sal;
    }

    public void mostrar(double sal, double comi) {
        JOptionPane.showMessageDialog(null, "O salario final é " + salf + " e a caomissao é " + comif);
    }
}
