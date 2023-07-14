#include <cstdlib>
#include <iostream>
#include "implementacao.h"
using namespace std;

int main(int argc, char** argv) {
   int n = 6;
    int vet[n] = {20, 12, 18, 5, 10, 18};
    
    implementacao *obj1 = new implementacao();
    
    obj1->insercao(n, vet);
    


    return 0;
}

