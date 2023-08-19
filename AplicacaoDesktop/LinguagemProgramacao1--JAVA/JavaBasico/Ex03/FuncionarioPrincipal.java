package Ex03;
import javax.swing.JOptionPane;

public class FuncionarioPrincipal {
     public static void main(String[] args) {
     Funcionario funcionario = new Funcionario();
       double sal,comi,salf,comif;
       sal = Double.parseDouble(JOptionPane.showInputDialog("Informe o salario fixo"));
       comi = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor de suas vendas"));
       
       funcionario.calc(sal,comi);
       funcionario.mostrar(sal,comi);
     }
}
