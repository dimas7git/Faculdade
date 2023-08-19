package Ex06;
import javax.swing.JOptionPane;
public class NumPrincipal {
    public static void main(String[] args){
       Num num = new Num();
        int nume= 0,maior=0,menor=100000 ;     
        for (int cont = 1; cont <= 10; cont++) {
        nume = Integer.parseInt(JOptionPane.showInputDialog("Informe um numero"));       
        }
        num.verificar(nume);
        num.mostrar(nume);
    }
}
