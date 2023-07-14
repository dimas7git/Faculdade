package secretaria;

import java.util.Scanner;

public class Main {

	public static void main(String args[]) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Digite seu nome: ");
		String nome = entrada.nextLine();
		System.out.print("Digite sua primeira nota: ");
		double n1 = Double.parseDouble(entrada.next());
		System.out.print("Digite sua segunda nota: ");
		double n2 = Double.parseDouble(entrada.next());
		double nf = (n1 + n2) / 2;
		System.out.println(nome);
		System.out.println("Sua note final é:" + nf);

		if (nf > 8) {
			System.out.println("Seu conceito é A");
		} else if ((nf <= 8) && (nf >= 7)) {
			System.out.println("Seu conceito é B");
		}

		else if ((nf < 7) && (nf >= 6)) {
			System.out.println("Seu conceito é C");
		}

		else if ((nf <= 6) && (nf >= 5)) {
			System.out.println("Seu conceito é D");
		}

		else {
			System.out.println("Seu conceito é E");
		}
		entrada.close();
	}

}
