package aula01.heranca;

public class Aluno extends Pessoa {
	String ra;
	int numDisciplinas;

	public Aluno(String nome, String ra, int numDisciplinas) {
		super(nome);
		this.ra = ra;
		this.numDisciplinas = numDisciplinas;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}

	public int getNumDisciplinas() {
		return numDisciplinas;
	}

	public void setNumDisciplinas(int numDisciplinas) {
		this.numDisciplinas = numDisciplinas;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getNome() + "," + ra + "," + numDisciplinas;
	}
}
