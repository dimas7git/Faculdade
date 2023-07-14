/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   ArvoreBinaria.cpp
 * Author: aluno
 * 
 * Created on 27 de Fevereiro de 2020, 20:23
 */

#include "ArvoreBinaria.h"
#include <cstdlib>
#include "iostream"
#include "No.h"
#include <stddef.h>
using namespace std;


ArvoreBinaria::ArvoreBinaria() {
    this->raiz=NULL;
}

ArvoreBinaria::ArvoreBinaria(const ArvoreBinaria& orig) {
}

ArvoreBinaria::~ArvoreBinaria() {
}

bool ArvoreBinaria::vazio() {
    return this->raiz == NULL;
}

No* ArvoreBinaria::insereRec(No *inicio, int valor){
    if(inicio == NULL){
        inicio = new No(valor);
    } else { 
        if(valor < inicio->valor)
            inicio->esquerdo=insereRec(inicio->esquerdo, valor);
        else
            inicio->direito = insereRec(inicio->direito, valor);
    }
    return(inicio);
}

void ArvoreBinaria::insere(int valor){ 
    No *tmp = this->raiz;
    No *ant = NULL;
    
    while (tmp != NULL){
        ant = tmp;
        if (tmp->valor <= valor)
            tmp = tmp->direito;
        else
            tmp = tmp->esquerdo;
    }
   if (this->vazio()){
        this->raiz=new No(valor);
    }else 
        if(ant->valor <= valor){
            ant->direito =new No(valor);
        }else{
            ant->esquerdo =new No(valor);
        }
}

void ArvoreBinaria::emOrdem(No *inicio) {
    if (inicio != NULL) {
        this->emOrdem(inicio->esquerdo);   
        cout << inicio->valor << " ";
        this->emOrdem(inicio->direito);
    }
}

void ArvoreBinaria::emOrdemSoma(No *inicio, int &valor) {
    if (inicio != NULL) {
        this->emOrdemSoma(inicio->esquerdo, valor);   
        valor += inicio->valor;
        this->emOrdemSoma(inicio->direito, valor);
    }
}

void ArvoreBinaria::PosOrdem(No* inicio){
     if (inicio != NULL) {
        this->PosOrdem (inicio->esquerdo);   
        this->PosOrdem (inicio->direito);
        cout << inicio->valor << " ";
    }
}

void ArvoreBinaria::PreOrdem(No* inicio){
     if (inicio != NULL) {
        cout << inicio->valor << " ";
        this->PreOrdem (inicio->esquerdo);   
        this->PreOrdem (inicio->direito);
        
    }
}

void ArvoreBinaria::maiorElem(No* inicio){
    int maiorValor;
    
    while(inicio != NULL){
        maiorValor = inicio->valor;
        inicio = inicio->direito;
    }
    
    cout << maiorValor << " ";
}

No* ArvoreBinaria::maiorElemRecursivo(No* inicio){
        if(inicio->direito == NULL){
            return inicio;
        } else {
            this->maiorElem(inicio->direito);
        }
}

int ArvoreBinaria::buscarElem(No* inicio, int valor){
    if(inicio == NULL){
        return 0;
    } else if (inicio->valor == valor){
        return valor;
    } else {
        if(valor > inicio->valor){
            this->buscarElem(inicio->direito, valor);
        } else {
            this->buscarElem(inicio->esquerdo, valor);
        }
    }
}

int ArvoreBinaria::checkAltura(No *inicio){
    if(inicio == NULL){
        return -1;
    } else {
        int alturaEsquerda = this->checkAltura(inicio->esquerdo);
        int alturaDireita = this->checkAltura(inicio->direito);
    
        if(alturaEsquerda > alturaDireita){
            return alturaEsquerda + 1;
        } else {
            return alturaDireita + 1;
        }
    }
}

int ArvoreBinaria::somaElem(No* inicio){
    int soma = 0;
    
    //this->emOrdemSoma(inicio, soma);
    if(inicio != NULL){
        soma = inicio->valor + this->somaElem(inicio->direito) + this->somaElem(inicio->esquerdo);
    }
    
    return soma;
}

int ArvoreBinaria::buscarNivelElem(No* inicio, int elem){
    int nivel = 0;
    
    while(inicio != NULL){
        if(inicio == NULL){
            return 0;
        } else if (inicio->valor == elem){
            return nivel;
        } else {
            if(elem > inicio->valor){
                inicio = inicio->direito;
                nivel += 1;
            } else {
                inicio = inicio->esquerdo;
                nivel += 1;
            }
        }
    }
}

void ArvoreBinaria::buscarFolha(No *inicio){
    if(inicio->esquerdo == NULL && inicio->direito == NULL){
         cout << inicio->valor << " ";
    }
    if(inicio->esquerdo != NULL){
        this->buscarFolha(inicio->esquerdo);
    } 
    if(inicio->direito != NULL){
        this->buscarFolha(inicio->direito);  
    }
}