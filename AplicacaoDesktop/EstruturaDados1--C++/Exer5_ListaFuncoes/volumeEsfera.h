#ifndef VOLUMEESFERA_H
#define VOLUMEESFERA_H

class volumeEsfera {
public:
   //Paradigma 00
    float raio;
    
    volumeEsfera();
    volumeEsfera(const volumeEsfera& orig);
    virtual ~volumeEsfera();
    
    //void lerDadosE();
    void lerDadosOO();
    //float calcularVolumeE(float raio);
    float calcularVolumeOO();
private:

};

#endif /* VOLUMEESFERA_H */

