/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: aluno
 *
 * Created on 17 de Março de 2022, 09:44
 */

#include <cstdlib>
#include <iostream>

#include "Arvore.h"

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    Arvore *arvore = new Arvore();
    int quantidade, valor;
    
    cout << "Digite a quantidade de elementos da árvore" << endl;
    cin >> quantidade;
    cout << "Digite o valor a ser adicionado" << endl;
    for(int i = 0;i < quantidade;i++){
        cin >> valor;
        arvore->insere(valor);
    }
    
    arvore->listar(arvore->raiz);
    
    return 0;
}

