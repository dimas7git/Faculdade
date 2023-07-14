package MVC;

import MVC.CalcularDTO;

public class CalcularCTR extends CalcularDTO {

    float indice = 0;

    public CalcularCTR(float peso, float altura, float indice) {
        super(peso, altura);
        this.indice = indice;

    }

    public float getIndice() {
        return indice;
    }

    public void setIndice(float indice) {
        this.indice = indice;
    }

    public void calculaIMC() {
        indice = peso / (altura * altura);
    }

    @Override
    public String toString() {
        return "CalcularCTR{" + "Indice=" + indice + '}';
    }

    public float Calcula(){
        indice = peso / (altura*altura);
        System.out.println(indice);
        return indice;
    }
}
