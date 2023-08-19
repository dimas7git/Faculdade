package Ex07;
import javax.swing.JOptionPane;

public class Principal {
     public static void main(String args[]) {
        String letra;
        Verificar verificar = new Verificar();

        letra = JOptionPane.showInputDialog("Informe a letra");

         while (!letra.equals("0")) {
          verificar.verificar(letra);
          letra = JOptionPane.showInputDialog("Informe a letra ");
        }
        JOptionPane.showMessageDialog(null, verificar.mostra());
    }
}
