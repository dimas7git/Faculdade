#include "cCalc.h"
#include <iostream>

using namespace std;

cCalc::cCalc() {
}

cCalc::cCalc(const cCalc& orig) {
}

cCalc::~cCalc() {
}

void cCalc::lerNotas() {
    cout << "Informe a nota 1 " << endl;
    cin >> n1;
    cout << "Informe a nota 2 " << endl;
    cin >> n2;
    cout << "Informe a nota 3 " << endl;
    cin >> n3;
}

float cCalc::calcNotas() {

    media = (n1 + n2 + n3) / 3;

    return media;
}

void cCalc::situNotas() {
    if (media >= 6)
        cout << "Aprovado";
    else
        cout << "Reprovado";
}