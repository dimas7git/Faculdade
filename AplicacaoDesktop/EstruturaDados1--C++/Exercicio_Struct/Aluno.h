/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Aluno.h
 * Author: byteapath
 *
 * Created on August 20, 2019, 9:18 PM
 */

#ifndef ALUNO_H
#define ALUNO_H

//Novo tipo de dado
struct DadosAluno{
      char nome[40];
      int matricula;
      float nota1, nota2;    
};
    

class Aluno {
public:
    
    DadosAluno ListaAlunos[3];

    
    void cadastro();
    bool pesquisar();
    void relatorio();
    
    
    Aluno();
    Aluno(const Aluno& orig);
    virtual ~Aluno();
private:

};

#endif /* ALUNO_H */

