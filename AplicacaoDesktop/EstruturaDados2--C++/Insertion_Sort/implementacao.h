/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   implementacao.h
 * Author: aluno
 *
 * Created on 9 de junho de 2022, 10:24
 */
#include <cstdlib>
#include <iostream>
#include <queue>
#include <stddef.h>
#ifndef IMPLEMENTACAO_H
#define IMPLEMENTACAO_H

class implementacao {
public:
    implementacao();
    implementacao(const implementacao& orig);
    virtual ~implementacao();
    void listar(int tam, int vet2[]);
    void insercao(int m, int vet[]);
    void bubble(int n[], int tam);
    void insertion(int n[], int tamanho);
private:

};

#endif /* IMPLEMENTACAO_H */

