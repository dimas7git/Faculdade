
#ifndef CEXPRESSAO_H
#define CEXPRESSAO_H

class cExpressao {
public:
    cExpressao();
    cExpressao(const cExpressao& orig);
    virtual ~cExpressao();
    
    int a,b,c,r,s;
    float d;
    void lerDados();
    float calcExpressao();
private:

};

#endif /* CEXPRESSAO_H */

