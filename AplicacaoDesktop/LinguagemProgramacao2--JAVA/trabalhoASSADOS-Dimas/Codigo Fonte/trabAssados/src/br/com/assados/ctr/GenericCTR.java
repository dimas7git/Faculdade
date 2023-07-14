package br.com.assados.ctr;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.ResultSet;

/**
 *
 * @author DimasFerreira
 */
public interface GenericCTR<T> {

    public String inserir(T t);

   
    public ResultSet consultar(T t, int opcao);


    public String alterar(T t);


    public String deletar(T t);

    public void CloseDB();
}
