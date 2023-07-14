/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   No.cpp
 * Author: Aluno
 * 
 * Created on 31 de março de 2022, 11:17
 */

#include "No.h"
#include <cstdlib>

No::No() {
}

No::No(const No& orig) {
}

No::~No() {
}

void No::insere(int valor){
    No *temp = new No;
    No *ant = NULL;
    
    while(temp != NULL){
        ant = temp;
        if(temp->valor < valor){
            temp = this->direito;
        } else {
            temp = this->esquerdo;
        }
    }
    
    if(this->vazio()){
        new No(valor);
    } else {
        if(ant->valor < valor){
            this->direito = new No(valor);
        } else {
            this->esquerdo = new No(valor);
        }
    }
}

bool No::vazio(){
    return this->No == NULL;
}