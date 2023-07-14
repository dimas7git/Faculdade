#ifndef CCALC_H
#define CCALC_H

class cCalc {
public:
    float n1,n2,n3,media;
    
    cCalc();
    cCalc(const cCalc& orig);
    virtual ~cCalc();
    
    void lerNotas();
    float calcNotas();
    void situNotas();
private:

};

#endif /* CCALC_H */

