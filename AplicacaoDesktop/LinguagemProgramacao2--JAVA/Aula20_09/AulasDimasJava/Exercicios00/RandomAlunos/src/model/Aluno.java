package model;

public class Aluno {

	String nome, cf;
	double n1, n2, nf;

	public Aluno() {
	}

	public Aluno(String nome, String cf, double n1, double n2, double nf) {
		super();
		this.nome = nome;
		this.cf = cf;
		this.n1 = n1;
		this.n2 = n2;
		this.nf = nf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getN1() {
		return n1;
	}

	public void setN1(double n1) {
		this.n1 = n1;
	}

	public double getN2() {
		return n2;
	}

	public void setN2(double n2) {
		this.n2 = n2;
	}

	public double getNf() {
		return nf;
	}

	public void setNf(double nf) {
		this.nf = nf;
	}

	public String getConceito() {
		return cf;
	}

	public void setConceito(String cf) {
		this.cf = cf;
	}

	@Override
	public String toString() {
		return "Aluno [nome=" + nome + ", cf=" + cf + ", n1=" + n1 + ", n2=" + n2 + ", nf=" + nf + "]";
	}

}
