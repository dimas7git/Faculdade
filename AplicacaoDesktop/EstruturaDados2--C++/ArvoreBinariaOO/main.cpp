/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: aluno
 *
 * Created on 27 de Fevereiro de 2020, 20:13
 */

#include <cstdlib>
#include <iostream>
#include "ArvoreBinaria.h"

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    ArvoreBinaria *obj1 = new ArvoreBinaria();
    
    obj1->insere(14);
    obj1->insere(4);
    obj1->insere(15);
    obj1->insere(3);
    obj1->insere(9);
    obj1->insere(14);
    obj1->insere(18);
    obj1->insere(7);
    obj1->insere(9);
    obj1->insere(16);
    obj1->insere(20);
    obj1->insere(5);
    obj1->insere(17);
    obj1->insere(4);
    obj1->insere(5);
    
    //obj1->raiz = obj1->insereRec(obj1->raiz,1);
    //obj1->insereRec(obj1->raiz,6);
    //obj1->insereRec(obj1->raiz,2);
    //obj1->insereRec(obj1->raiz,5);
    //obj1->insereRec(obj1->raiz,3);
    //obj1->insereRec(obj1->raiz,4);
    
    //obj1->buscarFolha(obj1->raiz);
    
    //cout << obj1->buscarNivelElem(obj1->raiz, 5);
    
    cout << obj1->checkAltura(obj1->raiz);
    
    //cout << obj1->somaElem(obj1->raiz);
    
    //cout << obj1->buscarElem(obj1->raiz, 40);
    
    //obj1->maiorElem(obj1->raiz);
    
    //obj1->emOrdem(obj1->raiz);
    //obj1->PreOrdem(obj1->raiz);
    //obj1->PosOrdem(obj1->raiz);

    return 0;
}