package br.edu.ifsp.vtp.projetoteste;

import java.util.ArrayList;

public class Pessoas {

    int id;
    String nome;
    Status status;
    ArrayList<Telefone> telefones;

//    public Pessoas(int id, String nome, String email) {
//        this.id = id;
//    }

    public Pessoas() {
        this.id=0;
        this.nome = new String();
        this.status = new Status();
        this.telefones = new ArrayList<>();
    }

    
    public Pessoas(int id, String nome, Status status, ArrayList<Telefone> telefones) {
        this.id = id;
        this.nome = nome;
        this.status = status;
        this.telefones = telefones;
    }
 
    public void adicionarTelefone(Telefone telefone){
    telefones.add(telefone);
    }
    
    public void removerTelefone(Telefone telefone){
    telefones.remove(telefone);
    }

    public void removerTelefone(int posicao){
    telefones.remove(posicao);  
    }
    
    @Override
    public String toString() {
        return "id=" + id; //To change body of generated methods, choose Tools | Templates.
    }

    public void Pessoa() {
        System.out.println("to aqui!");
    }

    public void Pessoa(String xxx) {
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

    public ArrayList<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(ArrayList<Telefone> telefones) {
        this.telefones = telefones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    

}
