package aula01.collections;

import java.util.ArrayList;
import java.util.Collections;

public class TestandoLists {
	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		
		list.add("a");
		list.add("a");
		list.add("a");
		list.add(null);
		list.add("b");
		list.add("c");
		list.add(null);
		
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
	}
}
