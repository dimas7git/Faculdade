package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FilesOps2 {

	public FilesOps2() {

	}

	public static void read() throws FileNotFoundException {

		File file = new File("./dados.csv");
		Scanner sc = null;
		try {
			sc = new Scanner(file);

			while (sc.hasNextLine()) {

				System.out.println(sc.nextLine());
			}
		} catch (

		IOException e) {
			System.out.println(e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
		}

	}
}