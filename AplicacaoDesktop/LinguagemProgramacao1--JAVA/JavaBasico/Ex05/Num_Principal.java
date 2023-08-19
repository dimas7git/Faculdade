package Ex05;
import javax.swing.JOptionPane;
public class Num_Principal {
    public static void main(String[] args){
       Num num = new Num();
        int nume = 0;     
        for (int cont = 1; cont <= 10; cont++) {
        nume = Integer.parseInt(JOptionPane.showInputDialog("Informe um numero"));       
        }
        num.calcular(nume);
        num.mostrar(nume);
    }
}
