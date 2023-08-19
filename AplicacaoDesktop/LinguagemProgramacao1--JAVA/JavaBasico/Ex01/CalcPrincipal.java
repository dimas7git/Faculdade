package Ex01;

import javax.swing.JOptionPane;

public class CalcPrincipal {

    public static void main(String[] args) {
        Calc calc = new Calc();
        double n1, n2, n3, p1, p2, p3;
        n1 = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota 1 "));
        p1 = Double.parseDouble(JOptionPane.showInputDialog("Informe a peso da nota 1 "));

        n2 = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota 2 "));
        p2 = Double.parseDouble(JOptionPane.showInputDialog("Informe a peso da nota 2 "));

        n3 = Double.parseDouble(JOptionPane.showInputDialog("Informe a nota 3 "));
        p3 = Double.parseDouble(JOptionPane.showInputDialog("Informe a peso da nota 3 "));

        calc.calcular(n1, n2, n3, p1, p2, p3);
        calc.mostrarCalc(n1, n2, n3, p1, p2, p3);
    }
}
