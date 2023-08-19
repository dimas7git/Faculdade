package Ex07;
import javax.swing.JOptionPane;
public class Verificar {
     private String letra;
    private int a,e,i,o,u,soma;

    public void verificar(String letra) {
        this.letra = letra;
        if (letra.equalsIgnoreCase("a")) {
            this.a++;
        }
        if (letra.equalsIgnoreCase("e")) {
            this.e++;
        }
        if (letra.equalsIgnoreCase("i")) {
            this.i++;
        }
        if (letra.equalsIgnoreCase("o")) {
            this.o++;
        }
        if (letra.equalsIgnoreCase("u")) {
            this.u++;
        }
        soma = a+e+i+o+u;
    }
    
    public int mostra(){
       JOptionPane.showMessageDialog(null,"A quantidade de vogal A foi " + this.a + "A quantidade de vogal E foi " + this.e + "A quantidade de vogal I foi " + this.i + "A quantidade de vogal O foi " + this.o +"A quantidade de vogal U foi " + this.u );
    return soma;
    }
}
