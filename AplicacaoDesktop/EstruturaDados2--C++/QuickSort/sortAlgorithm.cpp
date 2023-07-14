/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   sortAlgorithm.cpp
 * Author: byteapath
 * 
 * Created on 22 de junho de 2022, 10:39
 */

#include "sortAlgorithm.h"

sortAlgorithm::sortAlgorithm() {
}

sortAlgorithm::sortAlgorithm(const sortAlgorithm& orig) {
}

sortAlgorithm::~sortAlgorithm() {
}

    // function to swap elements
void sortAlgorithm::swap(int *a, int *b) {
  int t = *a;
  *a = *b;
  *b = t;
}  

 
int sortAlgorithm::partition(int arr[], int start, int end){
 
    int pivot = arr[start];
 
    int count = 0;
    for (int i = start + 1; i <= end; i++) {
        if (arr[i] <= pivot)
            count++;
    }
    
 
    // Giving pivot element its correct position
    int pivotIndex = start + count;
    swap(&arr[pivotIndex], &arr[start]);
 
    // Sorting left and right parts of the pivot element
    int i = start, j = end;
 
    while (i < pivotIndex && j > pivotIndex) {
 
        while (arr[i] <= pivot) {
            i++;
        }
 
        while (arr[j] > pivot) {
            j--;
        }
 
        if (i < pivotIndex && j > pivotIndex) {
            swap(&arr[i++], &arr[j--]);
        }
    }
 
    return pivotIndex;
}
 
void sortAlgorithm::quickSort(int arr[], int start, int end){
 
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
 


