#include "calcDistanciaEuclidiana.h"
#include <cstdlib>
#include <iostream>
#include <math.h>
using namespace std;

calcDistanciaEuclidiana::calcDistanciaEuclidiana() {
}

calcDistanciaEuclidiana::calcDistanciaEuclidiana(const calcDistanciaEuclidiana& orig) {
}

calcDistanciaEuclidiana::~calcDistanciaEuclidiana() {
}

void calcDistanciaEuclidiana::lerDados(){

    cout << "Digite o valor de x1 " << endl;
    cin >> x1;
    cout << "Digite o valor de y1 " << endl;
    cin >> y1;
    cout << "Digite o valor de x2 " << endl;
    cin >> x2;
    cout << "Digite o valor de y2 " << endl;
    cin >> y2;
}

float calcDistanciaEuclidiana::calcularDE(){

    float d;
    d = sqrt( pow(x2 - x1, 2) + pow(y2 - y1, 2) );
    cout <<"Distancia = " << d;    
}