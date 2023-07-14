#include "cCalc.h"
#include <iostream>

using namespace std;
cCalc::cCalc() {
}

cCalc::cCalc(const cCalc& orig) {
}

cCalc::~cCalc() {
}

void cCalc::lerNotas(){
    cout << "Informe a nota 1 "<< endl;
    cin >> n1;
    cout << "Informe a nota 2 "<< endl;
    cin >> n2;
    cout << "Informe a nota 3 "<< endl;
    cin >> n3;
}

float cCalc::calcNotas(){

    float media;
      media = ((n1*2)+ (n2*3)+ (n3*5))/10;
      return media;
}