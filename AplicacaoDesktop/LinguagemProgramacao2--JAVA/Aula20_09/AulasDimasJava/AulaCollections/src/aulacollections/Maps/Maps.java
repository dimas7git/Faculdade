package aulacollections.Maps;

import java.util.HashMap;
import java.util.Map;

public class Maps {

    public static void main(String[] args) {
        String texto = "Exemplo de texto para utilizar um novo comando aprendido em aula o comando é hashmaps que conta quantas vezes vai aparecer tal palavra";

        Map<String, Integer> contaPalavras = new HashMap();

        String tx[] = texto.split(" ");
        for(String palavra : tx){
            if(contaPalavras.get(palavra) == null){
                contaPalavras.put(palavra, (1));
            }else{
                Integer vezes = contaPalavras.get(palavra);
                vezes = (vezes+1);
                contaPalavras.put(palavra, vezes);
            }
        }
        System.out.println(contaPalavras);
    }
}
