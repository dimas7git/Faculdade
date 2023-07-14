package aula01.collections.filme;

public class Genero {
	String genero;

	public Genero() {
	}

	public Genero(String genero) {
		this.genero = genero;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public String toString() {
		return "Genero [genero=" + genero + "]";
	}

}
