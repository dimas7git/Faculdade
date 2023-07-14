package br.edu.ifsp.vtp.projetoteste.view;

import javax.swing.JOptionPane;

public class TesteMensagem extends JOptionPane {

    public static void msg(String texto) {
        showMessageDialog(null, texto, "Sistema de Cadastro", INFORMATION_MESSAGE);
    }

    public static void confirm(String texto) {
        showMessageDialog(null, texto, "Deseja mesmo EXCLUIR", ERROR_MESSAGE);
    }

}
