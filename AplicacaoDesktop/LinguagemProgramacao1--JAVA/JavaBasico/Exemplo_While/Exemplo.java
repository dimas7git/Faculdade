package Exemplo_While;

public class Exemplo {

    private String letra;
    private int qtd;

    public void verificar(String letra) {
        this.letra = letra;
        if (letra.equalsIgnoreCase("x")) {
            this.qtd++;
        }
    }
    
    public int mostra(){
    return this.qtd;
    }
}
