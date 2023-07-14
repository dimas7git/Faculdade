package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVReader {

	public CSVReader() {

	}

	public static void read() throws FileNotFoundException {
		File csvFile = new File("./dados.csv");
		try (Scanner scanner = new Scanner(csvFile)) {
			while (scanner.hasNext()) {
				String[] line = scanner.nextLine().split(",");
				String nome = line[0];
				String cf = line[1];
				String n1 = line[2];
				String n2 = line[3];
				String nf = line[4];

				System.out.println(nome + "," + cf + "," + n1 + "," + n2 + "," + nf);		
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
