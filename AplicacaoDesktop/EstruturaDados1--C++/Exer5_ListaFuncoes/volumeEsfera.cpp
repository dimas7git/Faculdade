#include "volumeEsfera.h"
#include <iostream>
#include <math.h>
using namespace std;
volumeEsfera::volumeEsfera() {
}

volumeEsfera::volumeEsfera(const volumeEsfera& orig) {
}

volumeEsfera::~volumeEsfera() {
}

/*void volumeEsfera::lerDadosE(){
    //Pradigmo estruturado
    float raio;
    cout << "Digite o raio da esfera";
    cin >>raio;
    cout << this->calcularVolumeE(raio);
}
*/


/**
float volumeEsfera::calcularVolumeE(float raio){

    float volume = 4/3 * 3.14 * pow(raio, 3);
    return volume;
}
 */

void volumeEsfera::lerDadosOO(){
    //Pradigmo orientado objeto
    cout << "Digite o raio da esfera";
    cin >>this->raio;
    cout << this->calcularVolumeOO();
}

float volumeEsfera::calcularVolumeOO(){

    float volume = 4/3 * 3.14 * pow(this->raio, 3);
    return volume;
}