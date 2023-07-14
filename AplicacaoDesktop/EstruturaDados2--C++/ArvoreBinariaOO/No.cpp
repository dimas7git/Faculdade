/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   No.cpp
 * Author: aluno
 * 
 * Created on 27 de Fevereiro de 2020, 20:14
 */

#include "No.h"
#include <cstdlib>
#include "iostream"
#include <stddef.h>

No::No() {
    this->direito = this->esquerdo = NULL; 
}

No::No(int valor) {
    this->valor =valor;
    this->direito = this->esquerdo = NULL; 
}

No::~No() {
}