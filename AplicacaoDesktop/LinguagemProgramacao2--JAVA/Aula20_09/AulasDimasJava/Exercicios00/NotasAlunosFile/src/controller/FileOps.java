package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileOps {

	
	public FileOps() {
		
	}
	
	public static void read() throws FileNotFoundException{
		try {
			File file = new File("./dados.csv");
			BufferedReader bf = new BufferedReader(new FileReader(file));
			String line = null;
			int i = 0;
			while ((line = bf.readLine()) != null) {
				++i;
				System.out.println(i + ":" + line);					
				
			}
			bf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
