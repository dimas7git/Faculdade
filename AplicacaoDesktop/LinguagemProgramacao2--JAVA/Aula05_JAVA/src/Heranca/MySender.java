package Heranca;


public class MySender extends AbstratoClass {

    public String encode(String mensagem) {
        String ret = mensagem;
        return ret;
    }

    public static void main(String[] args) {
        AbstratoClass sender = new MySender();
        sender.sendMessage("Ola mundo!!");

        AbstratoClass otherSender = new AbstratoClass() {
            public String encode(String mensagem) {
                String ret = mensagem;
                return ret;
            }
        };
        
        otherSender.sendMessage("Ola mundo pela segnuda vez!!");
        
        System.out.println(sender.getClass());
        System.out.println(otherSender.getClass());
    }
}
