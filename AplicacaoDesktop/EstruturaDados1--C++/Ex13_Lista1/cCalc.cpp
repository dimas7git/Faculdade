#include "cCalc.h"
#include <iostream>

using namespace std;

cCalc::cCalc() {
}

cCalc::cCalc(const cCalc& orig) {
}

cCalc::~cCalc() {
}

void cCalc::lerDados() {

    cout << "informe um numero: " << endl;
    cin >> n1;
    cout << "informe um numero: " << endl;
    cin >> n3;
    cout << "informe um numero: " << endl;
    cin >> n2;
}

void cCalc::mostrarDados() {

    if ((n1 > n2) && (n1 > n3)) {
        cout << "O maior numero é:" << n1;
    }
    if ((n2 > n1) && (n2 > n3)) {
        cout << "O maior numero é:" << n2;
    } else {
        cout << "O maior numero é:" << n3;

    }
  
}