package multiplas;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;;

class Teste {

	@Test
	void test01() {
		
		ClasseD<Classe> classeD = new ClasseD<Classe>();
		Classe testeTexto = new Classe();
		
		System.out.println("Provando o uso das interfaces e da classe genérica para tipo String}:" + "\n");
		testeTexto.setTexto("Abobrinha");
		System.out.println(classeD.retornaA(testeTexto));
		System.out.println(classeD.retornaB(testeTexto));
		System.out.println(classeD.retornaC(testeTexto));
	}

	@Test
	void test02() {
		
		ClasseD<Classe> classeD = new ClasseD<Classe>();
		Classe testeNumero = new Classe();
		
		System.out.println("Provando o uso das interfaces e da classe genérica para tipo Int}:" + "\n");
		testeNumero.setNumero(120);
		System.out.println("\n " + "Número inicial" + classeD.retornaNumeroA(testeNumero));
		System.out.println("Adicionando + 1 = " + classeD.retornaNumeroB(testeNumero));
		System.out.println("Adicionando + 2 = " + classeD.retornaNumeroC(testeNumero));
	}
}