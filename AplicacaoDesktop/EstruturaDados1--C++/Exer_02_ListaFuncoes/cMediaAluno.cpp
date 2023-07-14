
#include <iostream>
#include "cMediaAluno.h"

using namespace std;
cMediaAluno::cMediaAluno() {
}

cMediaAluno::cMediaAluno(const cMediaAluno& orig) {
}

cMediaAluno::~cMediaAluno() {
}

void cMediaAluno::lerDados(){
    float n1 = 0.0, n2 = 0.0, n3 = 0.0;
    char tipoMedia;
    
    cout << "Digite n1" <<endl;
    cin>>n1;
    cout << "Digite n2" <<endl;
    cin>>n2;
    cout << "Digite n3" <<endl;
    cin>>n3;
    cout<<"Digite tipo de média ( A OU P)"<<endl;
    cin>>tipoMedia;
    
    cout<< this->calcMedia(n1,n2,n3,tipoMedia);    
}

    
float cMediaAluno::calcMedia(float n1,float n2,float n3, char tipoMedia){
        float media = 0.0;
        if((tipoMedia == 'A' ) || (tipoMedia == 'a'))
            media = (n1+n2+n3)/3;
        
        if((tipoMedia == 'P') || (tipoMedia == 'a'))
            media = ((n1*5)+ (n2*3)+ (n3*2))/10;
        
        return media;
    }