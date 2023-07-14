/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   sortAlgorithm.h
 * Author: byteapath
 *
 * Created on 22 de junho de 2022, 10:39
 */

#ifndef SORTALGORITHM_H
#define SORTALGORITHM_H

class sortAlgorithm {
public:
    sortAlgorithm();
    sortAlgorithm(const sortAlgorithm& orig);
    virtual ~sortAlgorithm();
    
    void quickSort(int arr[], int start, int end);
    int partition(int arr[], int start, int end);
    void swap(int *a, int *b);

private:

};

#endif /* SORTALGORITHM_H */

