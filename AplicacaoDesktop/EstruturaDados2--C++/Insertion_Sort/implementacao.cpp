#include "implementacao.h"
#include <iostream>
#include <queue>
#include <stddef.h>

using namespace std;

implementacao::implementacao() {
}

implementacao::implementacao(const implementacao& orig) {
}

implementacao::~implementacao() {
}

void implementacao::insercao(int m, int vet[]) {
    int i, j, aux;
    for (i = 1; i < m; i++) {
        aux = vet[i];
        for(j = i-1; (j>=0) && (aux<vet[j]); j--){
            vet [j + 1] = vet[j];
            vet[j] = aux;
            this-> listar(m,vet);
        
        }
    }
}

void implementacao::listar(int tam, int vet2[]){
    for(int i = 0; i < tam; i++){
   
        cout << vet2[i] << " ";;
    }
    cout << endl;
}




void implementacao::bubble(int n[], int tam){
    int aux;
    for (int i=0; i<tam; ++i){
        for (int j=i; j<tam; ++j){
            if (n[i]>n[j]){
                aux = n[i];
                n[i] = n[j];
                n[j] = aux;
            }
        }
    }
}


void implementacao::insertion(int n[], int tamanho) {
      int i=0, j=0, tmp=0;
      for (i = 1; i < tamanho; i++) {
            j = i;
            while (j > 0 && n[j - 1] < n[j]) {
                  tmp = n[j];
                  n[j] = n[j - 1];
                  n[j - 1] = tmp;
                  j--;
            }
      }
}