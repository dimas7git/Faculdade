/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Arvore.cpp
 * Author: aluno
 * 
 * Created on 17 de Março de 2022, 09:45
 */

#include "Arvore.h"
#include <cstdlib>
#include <iostream>

using namespace std;

Arvore::Arvore() {
}

Arvore::Arvore(const Arvore& orig) {
}

Arvore::~Arvore() {
}

void Arvore::insere(int valor){
    No *temp = this->raiz;
    No *ant = NULL;
    
    while(temp != NULL){
        ant = temp;
        if(temp->valor < valor){
            temp = temp->direita;
        } else {
            temp = temp->esquerda;
        }
    }
    
    if(this->vazio()){
        this->raiz = (No*) malloc(sizeof(No));
        this->raiz->valor = valor;
    } else {
        if(ant->valor < valor){
            ant->direita = (No*) malloc(sizeof(No));
            ant->direita->valor = valor;
        } else {
            ant->esquerda = (No*) malloc(sizeof(No));
            ant->esquerda->valor = valor;
        }
    }
}

void Arvore::listar(No *no){
    if(no != NULL){
        this->listar(no->esquerda);
        cout << no->valor << " ";
        this->listar(no->direita);
    }
}

bool Arvore::vazio(){
    return this->raiz == NULL;
}