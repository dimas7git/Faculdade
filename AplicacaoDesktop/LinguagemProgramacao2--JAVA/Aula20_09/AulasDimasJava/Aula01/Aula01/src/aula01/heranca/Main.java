package aula01.heranca;

public class Main {

	public static void main(String[] args) {

		/* Testando classe Pessoa */
		Pessoa p = new Pessoa("Magneto");
		System.out.println(p.getNome());
		System.out.println("----------------------");
		
		Pessoa p2 = new Pessoa("MAgneto");
		System.out.println(p2.getNome());
		System.out.println("----------------------");
		
		System.out.println(p.getNome().equals(p2.getNome()));
		
		System.out.println(p.getNome().hashCode());
		System.out.println(p2.getNome().hashCode());

		/* Testando classe Funcionário */
		Funcionario f = new Funcionario("Pica Pau", 123, 10000.00);
		System.out.println(f.getNome());
		System.out.println(f.getNumMatricula());
		System.out.println(f.getSalario());
		System.out.println("----------------------");

		/* Testando classe Professor */
		Professor t = new Professor("Pica Pau", 123, 10000.00, "Doctor");
		System.out.println(t.getNome());
		System.out.println(t.getNumMatricula());
		System.out.println(t.getSalario());
		System.out.println(t.getTitulo());
		System.out.println("----------------------");

		/* Testando classe Aluno */
		Aluno a = new Aluno("Santos Dumont", "N77", 18);
		System.out.println(a.getNome());
		System.out.println(a.getRa());
		System.out.println(a.getNumDisciplinas());

	}

}
