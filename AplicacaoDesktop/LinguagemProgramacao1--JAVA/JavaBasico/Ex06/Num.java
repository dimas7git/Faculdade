package Ex06;
import javax.swing.JOptionPane;

public class Num {
     private int maior,menor=100000;

    public void verificar(int nume) {
       
        for (int cont = 1; cont <= 10; cont++) {
           if(nume>maior)
             maior = nume;
            
           if(menor>nume)
             menor = nume;
        }
    }

    public void mostrar(int nume) {
        JOptionPane.showMessageDialog(null, "O menor numero é " + menor + " O maior numero é" + maior);
    }
    
}
