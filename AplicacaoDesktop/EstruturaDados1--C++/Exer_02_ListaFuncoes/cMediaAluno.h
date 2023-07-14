

#ifndef CMEDIAALUNO_H
#define CMEDIAALUNO_H

class cMediaAluno {
public:
    
    cMediaAluno();
    cMediaAluno(const cMediaAluno& orig);
    virtual ~cMediaAluno();
    
    void lerDados();
    float calcMedia(float n1,float n2,float n3, char tipoMedia);
private:

};

#endif /* CMEDIAALUNO_H */

