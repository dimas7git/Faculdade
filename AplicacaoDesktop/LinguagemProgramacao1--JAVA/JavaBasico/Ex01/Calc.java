package Ex01;
import javax.swing.JOptionPane;

public class Calc {
  private double n1,n2,n3,p1,p2,p3,media;
    public void calcular (double n1,double n2,double n3,double p1,double p2,double p3){
    
       media  = ((n1*p1) + (n2*p2) + (n3*p3))/(p1 + p2 + p3);
    
    }
    public void mostrarCalc (double n1,double n2,double n3,double p1,double p2,double p3){
    
       JOptionPane.showMessageDialog(null,"A média é " + media);

    }
}
