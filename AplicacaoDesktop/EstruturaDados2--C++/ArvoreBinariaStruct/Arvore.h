/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Arvore.h
 * Author: aluno
 *
 * Created on 17 de Março de 2022, 09:45
 */

#ifndef ARVORE_H
#define ARVORE_H

class Arvore {
public:
    Arvore();
    Arvore(const Arvore& orig);
    virtual ~Arvore();
    
    struct No{
        int valor;
        struct No *direita;
        struct No *esquerda;
    }*raiz;
    
    bool vazio();
    void insere(int valor);
    void listar (No *no);
private:

};

#endif /* ARVORE_H */

