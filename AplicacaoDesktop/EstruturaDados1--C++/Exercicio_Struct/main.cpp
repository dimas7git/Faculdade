#include <cstdlib>
#include <iostream>
#include "Aluno.h"

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    
    Aluno *obj1 = new Aluno();
    obj1->cadastro();
    obj1->relatorio();
    if (obj1->pesquisar())
        cout<<"Aluno encontrado";
    
    //cout<<obj1->pesquisar();

    return 0;
}

