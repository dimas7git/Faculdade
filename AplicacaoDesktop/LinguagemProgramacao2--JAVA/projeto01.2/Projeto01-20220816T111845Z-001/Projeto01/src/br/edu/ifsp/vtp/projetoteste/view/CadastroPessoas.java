package br.edu.ifsp.vtp.projetoteste.view;

import br.edu.ifsp.vtp.projetoteste.Pessoas;
import javax.swing.JOptionPane;

public class CadastroPessoas {

    public static void main(String[] args) {
        Pessoas obj1 = new Pessoas();
        System.out.println(obj1.toString());
        obj1.metodo1();
        obj1.metodo2();
        obj1.metodo3(3);
        obj1.Pessoa("lalalalaa");
        obj1.Pessoa();
        System.out.println(obj1);
//        Pessoas obj2 = new Pessoas(2,"dimas","dimas@gmail");
//        Pessoas obj2 = new Pessoas(2);
//        JOptionPane.showMessageDialog(null, "Ola mundo", "Cadastro de Pessoa", JOptionPane.WARNING_MESSAGE);
//        JOptionPane msg = new JOptionPane();
//        msg.showMessageDialog(null, "Ola de novo!");
        TesteMensagem.msg("Ola de novo");
        TesteMensagem.confirm("?");
    }
}
