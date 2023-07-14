#include <cstdlib>
#include <iostream>

#include "cExpressao.h"
using namespace std;


int main(int argc, char** argv) {

    cExpressao obj1;
    obj1.lerDados();
   cout << obj1.calcExpressao();
    
    return 0;
}

