#include "cCalc.h"
#include <iostream>

using namespace std;
cCalc::cCalc() {
}

cCalc::cCalc(const cCalc& orig) {
}

cCalc::~cCalc() {
}

void cCalc::lerDados(){
    
    cout << "Informe o codigo do produto interessado em comprar "<<endl;
    cin >> cod;
    cout << "Informe a quantidade "<<endl;
    cin >> qtd;
}

float cCalc::calcDados(){

    if(cod==1001)
        cout << "O preço total é: " << qtd*5.32;
    if(cod==1324)
        cout << "O preço total é: " << qtd*6.45;
    if(cod==6548)
        cout << "O preço total é: " << qtd*2.37;
    if(cod==5555)
       cout << "O preço total é: " << qtd*5.32;
    //EU NÃO ESTAVA CONSEGUINDO UTLIZAR O NUMERO 0987 NO CODIGO POIS DAVA ESTE ERRO: error: invalid digit "9" in octal constant 
    if(cod==7623)
        cout << "O preço total é: " << qtd*6.45;
       
    return 0; 
}