#include <iostream>
#include "Aluno.h"

using namespace std;

Aluno::Aluno() {
}

Aluno::Aluno(const Aluno& orig) {
}

Aluno::~Aluno() {
}

void Aluno::cadastro(){
    
    for(int i=0; i<=2; i++){
        cout<<"Digite seu nome : ";
        cin>>this->ListaAlunos[i].nome;
        cout<<"Digite sua matricula : ";
        cin>>this->ListaAlunos[i].matricula;
        cout<<"Digite nota 1 : ";
        cin>>this->ListaAlunos[i].nota1;
        cout<<"Digite nota 2 : ";
        cin>>this->ListaAlunos[i].nota2;
    }
}


bool Aluno::pesquisar(){

    int mat;
    bool aux=false;
    
    cout<<"Digite a matricula a ser pesquisada"<<endl;
    cin>> mat;
    
    for(int i=0; i<=2; i++){
        if (mat == this->ListaAlunos[i].matricula)
            aux= true;
            
    }
    
    return aux;
}


void Aluno::relatorio(){

    for(int i=0; i<=2; i++){
        cout<<this->ListaAlunos[i].nome << endl;
        cout<<this->ListaAlunos[i].matricula << endl;
        cout<<this->ListaAlunos[i].nota1 << endl;
        cout<<this->ListaAlunos[i].nota2 << endl;
        cout<<(this->ListaAlunos[i].nota1+this->ListaAlunos[i].nota2)/2;
    }
    
}




