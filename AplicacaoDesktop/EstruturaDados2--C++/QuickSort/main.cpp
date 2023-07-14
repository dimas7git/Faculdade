/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.cpp
 * Author: byteapath
 *
 * Created on 22 de junho de 2022, 10:39
 */

#include <cstdlib>
#include <iostream>
#include "sortAlgorithm.h"

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    
    sortAlgorithm obj;
    
    int arr[] = { 9, 3, 4, 2, 1, 8 };
    int n = 6;
 
    obj.quickSort(arr, 0, n - 1);
 
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
 
    return 0;
}



