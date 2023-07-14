/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   No.h
 * Author: Aluno
 *
 * Created on 31 de março de 2022, 11:17
 */

#ifndef NO_H
#define NO_H

class No {
public:
    No();
    No(const No& orig);
    virtual ~No();
    int valor;
    No *direito, *esquerdo;
    
    void insere(int valor);
    bool vazio();
private:

};

#endif /* NO_H */

