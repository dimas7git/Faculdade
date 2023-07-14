/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.assados.dao;
import java.sql.ResultSet;

/**
 *
 * @author DimasFerreira
 */
    public interface GenericDAO<G> {

	public boolean inserir(G g);

	public ResultSet consultar(G g, int opcao);

	public boolean alterar(G g);

	public boolean deletar(G g);
}
