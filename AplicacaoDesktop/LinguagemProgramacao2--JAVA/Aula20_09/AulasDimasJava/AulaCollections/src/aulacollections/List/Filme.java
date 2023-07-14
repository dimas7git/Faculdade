package aulacollections.List;

import java.util.ArrayList;
import java.util.List;

public class Filme {

    String nomeFilme;
    Genero genero;
    List<Ator> atores;

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Filme() {
        atores = new ArrayList<Ator>();
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    @Override
    public String toString() {;
        String ret = nomeFilme + "," + genero.getGenero();
        for (Ator a : atores) {
            ret += ", " + a.getAtor();
        }
        return ret;
    }

//    @Override
//    public String toString() {
//        return "Filme{" + "nomeFilme=" + nomeFilme + ", genero=" + genero + ", atores=" + atores + '}';
//    }
    
    

    public static void main(String[] args) {
        Filme filme = new Filme();
        Genero genero = new Genero();
        filme.setNomeFilme("Filme: Sexta-feira 13");
        genero.setGenero("Genero: Suspense");
        filme.setGenero(genero);
        Ator at1 = new Ator("Ator: Leonardo DiCaprio");
        Ator at2 = new Ator("Carmen");
        Ator at3 = new Ator("Beto");
        
        filme.getAtores().add(at1);
        filme.getAtores().add(at2);
        filme.getAtores().add(at3);
            System.out.println(filme);
    }
}
