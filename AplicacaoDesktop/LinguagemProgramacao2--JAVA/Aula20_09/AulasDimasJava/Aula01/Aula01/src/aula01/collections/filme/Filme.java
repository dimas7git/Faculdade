package aula01.collections.filme;

import java.util.ArrayList;
import java.util.List;

public class Filme {
	String nomeFilme;
	Genero genero;
	List<Ator> atores;

	public Filme() {
		atores = new ArrayList<Ator>();
	}

	public List<Ator> getAtores() {
		return atores;
	}

	public void setAtores(List<Ator> atores) {
		this.atores = atores;
	}

	public String getNomeFilme() {
		return nomeFilme;
	}

	public void setNome(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		String ret = nomeFilme + "," + genero.getGenero();
		for (Ator a : atores) {
			ret += ", " + a.getAtor();
		}
		return ret;
	}

	public static void main(String[] args) {

		Filme filme = new Filme();
		filme.setNome("Sexta-Feira 13");
		Genero genero = new Genero();
		genero.setGenero("Terror");
		filme.setGenero(genero);

		Ator at1 = new Ator("Joao da Silva");
		Ator at2 = new Ator("Maria Souza");

		filme.getAtores().add(at1);
		filme.getAtores().add(at2);
		System.out.println(filme);
	}
}
