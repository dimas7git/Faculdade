package aula01.heranca;

public class Test extends Pessoa {
	int test;
	String cargo;

	public Test(String nome, int test, String cargo) {
		super(nome);
		this.test = test;
		this.cargo = cargo;
	}

	public int getTest() {
		return test;
	}

	public void setTest(int test) {
		this.test = test;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Test [ nome =" + getNome() + ", test=" + test + ", cargo=" + cargo + "]";
	}

	public static void main(String[] args) {
		Test t = new Test("Ricardo Conde", 777, "Mestre");

		System.out.println(t);
	}

}
