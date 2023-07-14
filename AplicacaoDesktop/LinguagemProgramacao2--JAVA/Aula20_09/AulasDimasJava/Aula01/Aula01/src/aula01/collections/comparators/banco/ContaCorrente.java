package aula01.collections.comparators.banco;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ContaCorrente {

	String codigo;
	double saldo;
	int tipo;

	public ContaCorrente(String codigo, double saldo, int tipo) {
		this.codigo = codigo;
		this.saldo = saldo;
		this.tipo = tipo;
	}

	public String getCodigo() {
		return codigo;
	}

	public double getSaldo() {
		return saldo;
	}

	public int getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "ContaCorrenteComparators [codigo=" + codigo + ", saldo=" + saldo + ", tipo=" + tipo + "]";
	}

	public static void main(String[] args) {

		ContaCorrente cc1 = new ContaCorrente("123", 100.0, 1);
		ContaCorrente cc2 = new ContaCorrente("144", 101.00, 2);
		ContaCorrente cc3 = new ContaCorrente("14", 11.0, 3);
		ContaCorrente cc4 = new ContaCorrente("44", 10.3, 1);
		ContaCorrente cc5 = new ContaCorrente("1144", 990.0, 2);

		List<ContaCorrente> contas = new ArrayList<>();
		contas.add(cc1);
		contas.add(cc2);
		contas.add(cc3);
		contas.add(cc4);
		contas.add(cc5);

		System.out.println("Lista RAW");
		for (ContaCorrente contaCorrente : contas) {
			System.out.println(contaCorrente);
		}

		System.out.println("Lista em ordem crescente");
		Collections.sort(contas, new TipoCcComparator());
		for (ContaCorrente contaCorrente : contas) {
			System.out.println(contaCorrente);
		}
	}
}
