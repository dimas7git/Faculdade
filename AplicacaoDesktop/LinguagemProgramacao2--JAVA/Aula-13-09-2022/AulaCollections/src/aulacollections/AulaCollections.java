
package aulacollections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class AulaCollections {

    public static void main(String[] args) {
           // Set<String> set = new HashSet<>(); ///////não deixa ordenado
           //Set<String> set = new LinkedHashSet<>(); /////// ordem de inserção
            Set<String> set = new TreeSet<>(); ///// ordena pelo metodo compareTo()
            System.out.println(set.size());
            System.out.println(set.isEmpty());
            set.add("Dimas");
            set.add("Pero");
            set.add("Heitor");
            set.add("Andre");
            System.out.println(set.size());
            System.out.println(set.isEmpty());
            System.out.println(set);
            set.add("Carlos");
            System.out.println(set);
            set.remove("Heitor");
            System.out.println(set);
    }
   
}
