package Ex04;
import javax.swing.JOptionPane;

public class SoloPrincipal {
    public static void main(String args[]){
       Solo solo = new Solo();
       int ponto;
        
       JOptionPane.showMessageDialog(null,solo.Calcular(Integer.parseInt(JOptionPane.showInputDialog("Informe o ponto da agua"))));
    }
}
