/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/cppFiles/class.cc to edit this template
 */

/* 
 * File:   sorting.cpp
 * Author: Aluno
 * 
 * Created on 23 de junho de 2022, 13:31
 */

#include "sorting.h"
#include <iostream>

using namespace std;
sorting::sorting() {
}

sorting::sorting(const sorting& orig) {
}

sorting::~sorting() {
}


int sorting::partition(int arr[], int start, int end){
 
    int pivot = arr[start];
    cout <<"pivot"<< pivot << endl;
    cout  <<"start"<<start<<endl;
    int count = 0;
    for (int i = start + 1; i <= end; i++) {
        if (arr[i] <= pivot)
            count++;
        cout <<"count"<< count << endl;
    }
    cout << "ENDDDDDDDDDDDDD" << end <<endl;
    // Giving pivot element its correct position
    int pivotIndex = start + count;
    cout <<"pivotindex"<<pivotIndex<< endl;
    swap(arr[pivotIndex], arr[start]);
    
    
    
                                                    for (int i = 0; i < 6; i++) {
                                                    cout << arr[i] << " ";
    }
                                                    cout <<"\n"<<endl;
 
    // Sorting left and right parts of the pivot element
    int i = start, j = end;
    cout <<"i"<<i<<endl;
    cout <<"j"<<j<<endl;
    cout <<"pivotindex"<<pivotIndex<< endl;
    
    while (i < pivotIndex && j > pivotIndex) {
 
        while (arr[i] <= pivot) {
            i++;
            cout <<"i"<<i<<endl;
        }
 
        while (arr[j] > pivot) {
            j--;
            cout <<"j"<<j<<endl;
        }
 
        if (i < pivotIndex && j > pivotIndex) {

            swap(arr[i++], arr[j--]);
            
            
            cout <<""<<endl;
            cout <<"i"<<i<<endl;
            cout <<"j"<<j<<endl;
            
            
            
                                                    for (int i = 0; i < 6; i++) {
                                                    cout << arr[i] << " ";
    }
                                                    cout <<"\n"<<endl;
        }
    }
 
    return pivotIndex;
}
 
void sorting::quickSort(int arr[], int start, int end){
 
    // base case
    if (start >= end)
        return;
 
    // partitioning the array
    int p = partition(arr, start, end);
 
    // Sorting the left part
    quickSort(arr, start, p - 1);
 
    // Sorting the right part
    quickSort(arr, p + 1, end);
}
 

    

/*int sorting::main(){
 
    int arr[] = { 9, 3, 4, 2, 1, 8 };
    int n = 6;
 
    quickSort(arr, 0, n - 1);
 
    for (int i = 0; i < n; i++) {
        cout << arr[i] << " ";
    }
 
    return 0;
}*/

void swap(int *a, int *b){
    int t = *a;
    *a = *b;
    *b = t;
}

