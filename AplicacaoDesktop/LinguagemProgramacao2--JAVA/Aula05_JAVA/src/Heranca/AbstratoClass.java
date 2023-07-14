package Heranca;


public abstract class AbstratoClass {

        public void sendMessage(String mensagem) {
            System.out.println("Primeira mensagem codificada");
            String encoded = encode(mensagem);
            System.out.println("Enviando menssagem...");
            System.out.println(encoded);
            System.out.println("Mensagem enviada.");
        }

        public abstract String encode(String mensagem);

    }
