
package MVC;

public class CalcularDTO {
   protected float altura, peso;

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public CalcularDTO(float altura, float peso) {
        this.altura = altura;
        this.peso = peso;
    }

   
}
