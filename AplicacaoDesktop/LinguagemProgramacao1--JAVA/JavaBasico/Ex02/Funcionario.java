package Ex02;
import javax.swing.JOptionPane;

public class Funcionario {
   private double sal,aumen,salf;
    public void calc (double sal, double aumen){
   
    salf = (sal * aumen)/100;
    salf = sal + salf;
    }
    public void mostrar (double sal, double aumen){
    JOptionPane.showMessageDialog(null,"O salario final é " + salf);
    }
}
