package br.edu.ifsp.vtp.projetoteste;

public class Pessoas {

    int id;

    public Pessoas() {
    }

//    public Pessoas(int id, String nome, String email) {
//        this.id = id;
//    }
     public Pessoas(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "id="+id; //To change body of generated methods, choose Tools | Templates.
    }

    public void Pessoa(){
        System.out.println("to aqui!");
    } 
    
    public void Pessoa(String xxx){
        System.out.println("to aqui!");
    }
    
    public void metodo1() {
        int id = 1;
    }

    public void metodo2() {
        id = 2;
    }

    public void metodo3(int id) {
        id = 3;
        if (id <= 0) {
            boolean teste = false;
        }
//        if(teste)
//            System.out.println("Deu erro");
    }

}
