package Ex05;
import javax.swing.JOptionPane;

public class Num {

    private int nume,maior=0,menor=0;

    public void calcular(int nume) {
        this.nume = nume;
        for (int cont = 1; cont <= 10; cont++) {
            this.nume++;
        }
    }

    public void mostrar(int nume) {
        JOptionPane.showMessageDialog(null, "O resultado é" + this.nume);
    }
}
