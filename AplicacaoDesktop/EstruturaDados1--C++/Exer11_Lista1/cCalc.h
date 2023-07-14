#ifndef CCALC_H
#define CCALC_H

class cCalc {
public:
    int a,b;
    
    cCalc();
    cCalc(const cCalc& orig);
    virtual ~cCalc();
    
    void lerDados();
    void  verificarDados();
private:

};

#endif /* CCALC_H */

