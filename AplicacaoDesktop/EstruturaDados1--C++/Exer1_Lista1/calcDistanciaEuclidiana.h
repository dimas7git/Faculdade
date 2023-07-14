

#ifndef CALCDISTANCIAEUCLIDIANA_H
#define CALCDISTANCIAEUCLIDIANA_H

class calcDistanciaEuclidiana {
public:
    calcDistanciaEuclidiana();
    calcDistanciaEuclidiana(const calcDistanciaEuclidiana& orig);
    virtual ~calcDistanciaEuclidiana();
    
    int x1, y1, x2, y2;
    
    void lerDados();
    float  calcularDE();
    
private:

};

#endif /* CALCDISTANCIAEUCLIDIANA_H */

