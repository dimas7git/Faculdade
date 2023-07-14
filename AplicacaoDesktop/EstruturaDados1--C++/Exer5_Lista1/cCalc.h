#ifndef CCALC_H
#define CCALC_H

class cCalc {
public:
    float n1,n2,n3;
    
    cCalc();
    cCalc(const cCalc& orig);
    virtual ~cCalc();
    
    void lerNotas();
    float calcNotas();
private:

};

#endif /* CCALC_H */

