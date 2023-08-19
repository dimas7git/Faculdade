/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import java.util.ArrayList;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import secretaria.Aluno;

/**
 *
 * @author DimasFerreira
 */
public class TesteSecretaria {

    public TesteSecretaria() {
    }

    @Test
    void test1() {
        System.out.println("Teste 1:");
        ArrayList<Aluno> alunos = new ArrayList<>();
        Aluno aluno = new Aluno();
        aluno.setNome("Rafael");
        aluno.setN1(1);
        aluno.setN2(2);
        aluno.setNf(3);
        aluno.setConceito("B");
        alunos.add(aluno);
    }

    @Test
    void test2() {
        System.out.println("Teste 2:");
        ArrayList<Aluno> alunos = new ArrayList<>();
        Aluno aluno = new Aluno();
        aluno.setNome("Rafael");
        aluno.setN1(1);
        aluno.setN2(2);
        aluno.setNf(3);
        aluno.setConceito("B");
        alunos.add(aluno);
        System.out.println(alunos.get(0));
        assertEquals(aluno, aluno);
    }

    @Test
    void test3() {
        System.out.println("Teste 3:");
        ArrayList<Aluno> alunos = new ArrayList<>();
        Aluno aluno = new Aluno();
        aluno.setNome("Rafael");
        aluno.setN1(1);
        aluno.setN2(2);
        aluno.setNf(3);
        aluno.setConceito("B");
        alunos.add(aluno);
        alunos.remove(0);
    }

    @Test
    void test4() {
        System.out.println("Teste 4:");
        ArrayList<Aluno> alunos = new ArrayList<>();
        Aluno aluno = new Aluno();
        aluno.setNome("Rafael");
        aluno.setN1(1);
        aluno.setN2(2);
        aluno.setNf(3);
        aluno.setConceito("B");
        alunos.add(aluno);
        System.out.println(alunos.indexOf(aluno));
    }

    @Test
    void test5() {
        System.out.println("Teste 5:");
        ArrayList<Aluno> alunos = new ArrayList<>();
        Aluno aluno = new Aluno();
        aluno.setNome("Rafael");
        aluno.setN1(1);
        aluno.setN2(2);
        aluno.setNf(3);
        aluno.setConceito("B");
        alunos.add(aluno);
        System.out.println(alunos.contains(aluno));
    }

    @Test
    void test6() {
        fail("Teste ainda não implementado");
    }

    @Ignore
    void test7() {
        System.out.println("Teste 7 em construção");
    }
}
