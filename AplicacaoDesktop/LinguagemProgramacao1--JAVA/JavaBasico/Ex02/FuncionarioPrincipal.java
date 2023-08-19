package Ex02;
import javax.swing.JOptionPane;

public class FuncionarioPrincipal {

    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario();
        double sal, aumen;
        sal = Double.parseDouble(JOptionPane.showInputDialog("Informe o salario "));
        aumen = Double.parseDouble(JOptionPane.showInputDialog("Informe a porcentagem de aumento "));
       
        funcionario.calc(sal,aumen);
        funcionario.mostrar(sal, aumen);
    }
}
