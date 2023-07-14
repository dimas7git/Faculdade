package aula01.collections;

import java.util.HashMap;
import java.util.Map;

public class TestandoMaps {

	public static void main(String[] args) {

		String texto = "Dado uma string longa utilize um" + " map para contar quantas vezes determinada "
				+ "palavra aparece na string Considere que as" + "palavras sao separadas por um espaco em" + "branco";

		// int -> Integer
		// double -> Double

		Map<String, Integer> contaPalavras = new HashMap<>();

		String tx[] = texto.split(" ");
		for (String palavra : tx) {
			if (contaPalavras.get(palavra) == null) {
				contaPalavras.put(palavra, (1));
			} else {
				Integer vezes = contaPalavras.get(palavra);
				vezes = (vezes + 1);
				contaPalavras.put(palavra, vezes);
			}
		}
		System.out.println(contaPalavras);
	}
}
