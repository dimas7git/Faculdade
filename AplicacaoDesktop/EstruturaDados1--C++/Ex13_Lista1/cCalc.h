
#ifndef CCALC_H
#define CCALC_H

class cCalc {
public:
    int n1,n2,n3;
    
    cCalc();
    cCalc(const cCalc& orig);
    virtual ~cCalc();
    
    void lerDados();
    void mostrarDados();
private:

};

#endif /* CCALC_H */

