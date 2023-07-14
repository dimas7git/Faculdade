package aula01.collections.comparables.banco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContaCorrente implements Comparable<ContaCorrente> {
	String codigo;
	double saldo;

	public ContaCorrente(String codigo, double saldo) {
		this.codigo = codigo;
		this.saldo = saldo;
	}

	public String getCodigo() {
		return codigo;
	}

	public double getSaldo() {
		return saldo;
	}

	@Override
	public int compareTo(ContaCorrente cc) {
		if (this.saldo < cc.getSaldo())
			return -1;
		if (this.saldo > cc.getSaldo())
			return 1;
		else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "ContaCorrenteComparables [codigo=" + codigo + ", saldo=" + saldo + "]";
	}

	public static void main(String[] args) {

		ContaCorrente cc1 = new ContaCorrente("123", 1000.0);
		ContaCorrente cc2 = new ContaCorrente("144", 100.3);
		ContaCorrente cc3 = new ContaCorrente("14", 11.0);
		ContaCorrente cc4 = new ContaCorrente("44", 11.0);
		ContaCorrente cc5 = new ContaCorrente("1144", 990.0);

		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(cc1);
		contas.add(cc2);
		contas.add(cc3);
		contas.add(cc4);
		contas.add(cc5);

		System.out.println("Lista RAW");
		for (ContaCorrente contaCorrente : contas) {
			System.out.println(contaCorrente.toString());
		}
		System.out.println("      ");
		System.out.println("Lista Crescente");
		Collections.sort(contas);
		for (ContaCorrente contaCorrente : contas) {
			System.out.println(contaCorrente.toString());
		}

		System.out.println("      ");
		System.out.println("Lista Decrescente");
		Collections.sort(contas, Collections.reverseOrder());
		for (ContaCorrente contaCorrente : contas) {
			System.out.println(contaCorrente.toString());
		}

		System.out.println("      ");
		System.out.println(cc1.compareTo(cc2));
		System.out.println(cc2.compareTo(cc3));
		System.out.println(cc3.compareTo(cc4));
		System.out.println(cc4.compareTo(cc5));
	}
}
