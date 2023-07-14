/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsp.vtp.projetoteste.view;

import br.edu.ifsp.vtp.projetoteste.Pessoas;
import br.edu.ifsp.vtp.projetoteste.Status;
import br.edu.ifsp.vtp.projetoteste.Telefone;
import javax.swing.JOptionPane;

public class CadastroPessoasV2 {

    public static void main(String[] args) {
        Pessoas pessoas = new Pessoas();
        Telefone telefone = new Telefone();
        Status status = new Status();
        String retorno = "";
//        setNomePessoa(obj1, retorno);
//        setDesc(obj1, status,retorno);
//        setTelefone(tel, status, obj1,retorno);

        pessoas.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o id ")));
        pessoas.setNome(JOptionPane.showInputDialog("Digite o nome "));

        retorno += "O Nome é: " + pessoas.getNome() + "\n";

        status.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do status")));
        status.setDescricao(JOptionPane.showInputDialog("Digite a descrição do status"));
        retorno += "Descrição do status: " + status.getDescricao() + "\n";

        pessoas.setStatus(status);
        setTelefone(telefone, status, pessoas, retorno);
        while (JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro telefone?", "Pessoa", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            setTelefone(telefone, status, pessoas, retorno);
        }
        JOptionPane.showMessageDialog(null, retorno);

    }

    private static void setTelefone(Telefone telefone, Status status, Pessoas pessoas, String retorno) {
        telefone.setId(Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do telefone")));
        telefone.setDdd(Integer.parseInt(JOptionPane.showInputDialog("Digite o DDD")));
        telefone.setNumero(JOptionPane.showInputDialog("Digite o numero"));
        telefone.setTipo(JOptionPane.showInputDialog("Digite o tipo numero"));

        retorno += "O DDD é: " + telefone.getDdd() + "\n";
        retorno += "O NUmero é: " + telefone.getNumero() + "\n";
        retorno += "O Tipo é: " + telefone.getTipo() + "\n";
        pessoas.adicionarTelefone(telefone);

    }
}
//    private static void setTelefone(Telefone telefone, Status status, Pessoas pessoas, String retorno) {
//    private static void Mostrar(String retorno){
//    private static void setDesc(Pessoas pessoas, Status status, String retorno) {
//    private static void setNomePessoa(Pessoas pessoas, String retorno) {
