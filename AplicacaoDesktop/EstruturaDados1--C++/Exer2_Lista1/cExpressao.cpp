#include "cExpressao.h"
#include <iostream>
#include <math.h>

using namespace std;

cExpressao::cExpressao() {
}

cExpressao::cExpressao(const cExpressao& orig) {
}

cExpressao::~cExpressao() {
}

void cExpressao::lerDados() {
   
    cout << "Digite o valor A" << endl;
    cin>> a;
    cout << "Digite o valor B" << endl;
    cin >> b;
    cout << "Digite o valor C" << endl;
    cin >> c;
}


float cExpressao::calcExpressao() {

    r = pow((a + b),2);
    s = pow((b+c),2);
    d = (r+s)/2;
   
    return d;
}