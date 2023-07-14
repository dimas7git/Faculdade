/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ArvoreBinaria.h
 * Author: aluno
 *
 * Created on 27 de Fevereiro de 2020, 20:23
 */

#ifndef ARVOREBINARIA_H
#define ARVOREBINARIA_H

#include "No.h"

class ArvoreBinaria {
public:
    ArvoreBinaria();
    ArvoreBinaria(const ArvoreBinaria& orig);
    virtual ~ArvoreBinaria();
    
    No *raiz;
    void insere(int valor);
    bool vazio();
    void PreOrdem(No *inicio);
    void emOrdem (No *inicio);
    void emOrdemSoma (No *inicio, int &valor);
    void PosOrdem (No *inicio);
    int checkAltura(No *inicio);
    void maiorElem (No *inicio);
    int buscarElem(No *inicio, int valor);
    int somaElem(No *inicio);
    int buscarNivelElem(No *inicio, int elem);
    void buscarFolha(No *inicio);
    No* maiorElemRecursivo (No *inicio);
    No* insereRec(No *inicio, int valor);
private:

};

#endif /* ARVOREBINARIA_H */