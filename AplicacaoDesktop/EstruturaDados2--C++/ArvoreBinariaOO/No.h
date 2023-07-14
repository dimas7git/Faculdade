/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   No.h
 * Author: aluno
 *
 * Created on 27 de Fevereiro de 2020, 20:14
 */

#ifndef NO_H
#define NO_H

class No {
public:
    No();
    No(int valor);
    virtual ~No();
    int valor;
    No *direito, *esquerdo;
private:

};

#endif /* NO_H */