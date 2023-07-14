
#ifndef CCALC_H
#define CCALC_H

class cCalc {
public:
    int cod;
    float qtd;
    
    cCalc();
    cCalc(const cCalc& orig);
    virtual ~cCalc();
    
    void lerDados();
    float calcDados();
private:

};

#endif /* CCALC_H */

