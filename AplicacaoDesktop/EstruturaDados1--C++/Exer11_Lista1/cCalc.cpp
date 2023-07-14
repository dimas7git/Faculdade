#include "cCalc.h"
#include <iostream>
#include <math.h>
using namespace std;

cCalc::cCalc() {
}

cCalc::cCalc(const cCalc& orig) {
}

cCalc::~cCalc() {
}

void cCalc::lerDados() {
    cout << "Informe um numero para A " << endl;
    cin >> a;
    cout << "Informe um numero para B " << endl;
    cin >> b;
}

void cCalc::verificarDados() {
    if (a % b == 0)
        cout << "A e B são multiplos ";
    else
        cout << "A e B não são multiplos";


}