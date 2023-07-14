/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/main.cc to edit this template
 */

/* 
 * File:   main.cpp
 * Author: Aluno
 *
 * Created on 23 de junho de 2022, 13:29
 */

#include <cstdlib>
#include "sorting.h"
#include <iostream>
using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    sorting *obj = new sorting();
 int arr[] = { 3, 4, 2, 5, 7, 6};
    int n = 6;
 
    obj->quickSort(arr, 0, n - 1);
 
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
    
    return 0;
}

