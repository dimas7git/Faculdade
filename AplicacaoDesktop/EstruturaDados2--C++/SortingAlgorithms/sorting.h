/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.h to edit this template
 */

/* 
 * File:   sorting.h
 * Author: Aluno
 *
 * Created on 23 de junho de 2022, 13:31
 */

#ifndef SORTING_H
#define SORTING_H

class sorting {
public:
    
    int partition(int arr[], int start, int end);
    void quickSort(int arr[], int start, int end);
    int main();
    
    
    sorting();
    sorting(const sorting& orig);
    virtual ~sorting();
private:

};

#endif /* SORTING_H */

