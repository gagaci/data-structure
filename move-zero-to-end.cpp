#include <iostream>
using namespace std;


void moveZerosToTheEnd(int arr[], int n){
    int nonZeroIndex = 0;

    for(int i = 0; i < n; i++){
        if(arr[i] != 0){
            int temp = arr[i];
            arr[i] = arr[nonZeroIndex];
            arr[nonZeroIndex] = temp;
            nonZeroIndex++;
        }

    }


}

int main() {

    int arr[] {1,0,2,0,5,0,15};

    int length = sizeof(arr) / sizeof(arr[0]);

    cout << "original array: ";
    for(int i = 0; i < length; i++){
        cout << arr[i] << " ";
    }

    cout << "\n";

    cout << "after nonzero method array: ";

    moveZerosToTheEnd(arr, length);
    for(int i = 0; i < length -  1; i++){
        cout << arr[i] << " ";
    }

    return 0;
}